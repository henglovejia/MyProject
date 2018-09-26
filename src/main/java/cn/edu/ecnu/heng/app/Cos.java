package cn.edu.ecnu.heng.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.edu.ecnu.heng.base.App;
import cn.edu.ecnu.heng.base.Question;
import cn.edu.ecnu.heng.utils.PropertiesUtil;

public class Cos {
	public static String Input_emb = "E:\\Resource\\DataSet\\glove.840B.300d.txt";
	public static Map<String, String[]> words = new HashMap<>();

	public static double[] meanCos(ArrayList<String> word) {
		double[] vector = new double[300];
		for (int i = 0; i < word.size(); i++) {
			try {
				double[] vectorTmp = App.getWordVectors(word.get(i));
				for (int j = 0; j < vectorTmp.length; j++) {
					vector[j] += (vectorTmp[j] / word.size());
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(word.get(i));
			}
		}
		return vector;
	}

	public static Boolean calculate(double[] x, double[] y, double cosRate) {
		double vector1Modulo = 0.00;// 向量1的模
		double vector2Modulo = 0.00;// 向量2的模
		double vectorProduct = 0.00; // 向量积
		for (int i = 0; i < x.length; i++) {
			vector1Modulo += x[i] * x[i];
			vector2Modulo += y[i] * y[i];
			vectorProduct += x[i] * y[i];
		}
		vector1Modulo = Math.sqrt(vector1Modulo);
		vector2Modulo = Math.sqrt(vector2Modulo);
		if ((vectorProduct / (vector1Modulo * vector2Modulo)) < cosRate)
			return false;
		return true;
	}

	public static void filter() {
		StringBuilder sBuilder = new StringBuilder();
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(new File(Input_emb)));
			String line;
			while ((line = bReader.readLine()) != null) {
				String tmp[] = line.split(" ");
				if (words.containsKey(tmp[0])) {
					sBuilder.append(line + "\n");
					words.put(tmp[0], tmp);
				}
			}
			bReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question question = new Question();
		question.setQuestion1("How can I be a good geologist?");
		question.setQuestion2("What should I do to be a great geologist?");
		System.out.println(calculate(meanCos(question.getQuestion1List()), meanCos(question.getQuestion2List()),
				PropertiesUtil.getDouble("cosRate")));
	}
}
