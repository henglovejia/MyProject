package cn.edu.ecnu.heng.base;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {
	private Integer id, qid1, qid2;
	private String question1, question2;
	private ArrayList<String> question1List, question2List;
	private Boolean isDuplicate, cosDuplicate, levenshteinDuplicate, levenshteinAndCosDuplicate;

	public Boolean getCosDuplicate() {
		return cosDuplicate;
	}

	public void setCosDuplicate(Boolean cosDuplicate) {
		this.cosDuplicate = cosDuplicate;
	}

	public Boolean getLevenshteinDuplicate() {
		return levenshteinDuplicate;
	}

	public void setLevenshteinDuplicate(Boolean levenshteinDuplicate) {
		this.levenshteinDuplicate = levenshteinDuplicate;
	}

	public Boolean getLevenshteinAndCosDuplicate() {
		return levenshteinAndCosDuplicate;
	}

	public void setLevenshteinAndCosDuplicate(Boolean levenshteinAndCosDuplicate) {
		this.levenshteinAndCosDuplicate = levenshteinAndCosDuplicate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQid1() {
		return qid1;
	}

	public void setQid1(Integer qid1) {
		this.qid1 = qid1;
	}

	public Integer getQid2() {
		return qid2;
	}

	public void setQid2(Integer qid2) {
		this.qid2 = qid2;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
		question1List = new ArrayList<>(
				Arrays.asList(question1.toLowerCase().replace("\"", "").replace("?", "").split(" ")));
		for (int i = 0; i < question1List.size(); i++) {
			if (App.getStopWord().contains(question1List.get(i))) {
				question1List.remove(i);
				i--;
			}
		}
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
		question2List = new ArrayList<>(
				Arrays.asList(question2.toLowerCase().replace("\"", "").replace("?", "").split(" ")));
		for (int i = 0; i < question2List.size(); i++) {
			if (App.getStopWord().contains(question2List.get(i))) {
				question2List.remove(i);
				i--;
			}
		}
	}

	public Boolean getIsDuplicate() {
		return isDuplicate;
	}

	public void setIsDuplicate(Boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
	}

	public ArrayList<String> getQuestion1List() {
		return question1List;
	}

	public ArrayList<String> getQuestion2List() {
		return question2List;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "\t" + qid1 + "\t" + qid2 + "\t" + question1 + "\t" + question2 + "\t" + isDuplicate + "\t"
				+ levenshteinDuplicate + "\t" + cosDuplicate + "\t" + levenshteinAndCosDuplicate;
	}
}
