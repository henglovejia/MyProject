package cn.edu.ecnu.heng.app;

import cn.edu.ecnu.heng.base.App;
import cn.edu.ecnu.heng.base.Question;
import cn.edu.ecnu.heng.utils.FileUtil;
import cn.edu.ecnu.heng.utils.PropertiesUtil;

public class Calculate {

	public static void main(String[] args) {
		// Question question = new Question();
		// question.setQuestion1("How can I be a good geologist?");
		// question.setQuestion2("What should I do to be a great geologist?");
		for (Question question : App.getQuestions()) {
			question.setLevenshteinDuplicate(
					Levenshtein.calculate(question.getQuestion1List(), question.getQuestion2List(), false));
			question.setCosDuplicate(Cos.calculate(Cos.meanCos(question.getQuestion1List()),
					Cos.meanCos(question.getQuestion2List()), PropertiesUtil.getDouble("cosRate")));
			question.setLevenshteinAndCosDuplicate(
					Levenshtein.calculate(question.getQuestion1List(), question.getQuestion2List(), true));
		}
		statisticsData();
		FileUtil.writeResult("result.txt");
	}

	public static void statisticsData() {
		int cosDuplicate = 0, levenshteinDuplicate = 0, levenshteinAndCosDuplicate = 0;
		for (Question question : App.getQuestions()) {
			if (question.getIsDuplicate()) {
				if (question.getLevenshteinDuplicate()) {
					levenshteinDuplicate++;
				}
				if (question.getCosDuplicate()) {
					cosDuplicate++;
				}
				if (question.getLevenshteinAndCosDuplicate()) {
					levenshteinAndCosDuplicate++;
				}
			} else {
				if (!question.getLevenshteinDuplicate()) {
					levenshteinDuplicate++;
				}
				if (!question.getCosDuplicate()) {
					cosDuplicate++;
				}
				if (!question.getLevenshteinAndCosDuplicate()) {
					levenshteinAndCosDuplicate++;
				}
			}
		}
		System.out.println("levenshteinDuplicate:" + levenshteinDuplicate);
		System.out.println("cosDuplicate:" + cosDuplicate);
		System.out.println("levenshteinAndCosDuplicate:" + levenshteinAndCosDuplicate);
		System.out.println("levenshteinDuplicate:" + ((double) levenshteinDuplicate / App.getQuestions().size()));
		System.out.println("cosDuplicate:" + ((double) cosDuplicate / App.getQuestions().size()));
		System.out.println(
				"levenshteinAndCosDuplicate:" + ((double) levenshteinAndCosDuplicate / App.getQuestions().size()));
	}
}
