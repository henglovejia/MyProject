/**
 * 
 */
package cn.edu.ecnu.heng.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import cn.edu.ecnu.heng.base.App;
import cn.edu.ecnu.heng.base.Question;

/**
 * 
 * @author Heng(MacBook)
 *
 * @create 2018年9月22日-下午9:03:15
 *
 * @detail
 */
public class FileUtil {
	public static HashMap<String, double[]> getGlove(String filename) {
		HashMap<String, double[]> map = new HashMap<>();
		try {
			ClassLoader classLoader = FileUtil.class.getClassLoader();
			System.out.println("正在读取:" + filename);
			BufferedReader bReader = new BufferedReader(
					new FileReader(new File(classLoader.getResource(filename).toString().replace("file:", ""))));
			String line;
			while ((line = bReader.readLine()) != null) {
				String[] items = line.split(" ");
				double[] item = new double[items.length - 1];
				for (int i = 1; i < items.length; i++) {
					item[i - 1] = Double.parseDouble(items[i]);
				}
				map.put(items[0], item);
			}
			bReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	public static ArrayList<Question> getQuoraQuestions(String filename) {
		ArrayList<Question> questions = new ArrayList<>(405000);
		try {
			ClassLoader classLoader = FileUtil.class.getClassLoader();
			System.out.println("正在读取:" + filename);
			BufferedReader bReader = new BufferedReader(
					new FileReader(new File(classLoader.getResource(filename).toString().replace("file:", ""))));
			String line = bReader.readLine();
			while ((line = bReader.readLine()) != null) {
				Question question = new Question();
				String[] items = line.split("\t");
				question.setId(Integer.parseInt(items[0]));
				question.setQid1(Integer.parseInt(items[1]));
				question.setQid2(Integer.parseInt(items[2]));
				question.setQuestion1(items[3].toLowerCase().replace("\"", "").replace("?", ""));
				question.setQuestion2(items[4].toLowerCase().replace("\"", "").replace("?", ""));
				question.setIsDuplicate(items[5].equals("1") ? true : false);
				questions.add(question);
			}
			bReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}

	public static HashSet<String> getStopWord(String filename) {
		HashSet<String> stopWord = new HashSet<>();
		try {
			ClassLoader classLoader = FileUtil.class.getClassLoader();
			System.out.println("正在读取:" + filename);
			BufferedReader bReader = new BufferedReader(
					new FileReader(new File(classLoader.getResource(filename).toString().replace("file:", ""))));
			String line;
			while ((line = bReader.readLine()) != null) {
				stopWord.add(line);
			}
			bReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stopWord;
	}

	public static void main(String[] args) {
		System.out.println(App.getWordVectors().get("the"));
	}
}
