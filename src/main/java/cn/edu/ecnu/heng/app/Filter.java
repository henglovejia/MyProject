package cn.edu.ecnu.heng.app;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Heng
 *
 * 2018年9月22日-下午12:23:31
 *
 * @detail
 */
public class Filter {
	public static Map<String, Integer> words;
	public static String Source = "E:\\Resource\\DataSet\\quora_duplicate_questions.txt";
	public static String Input_emb = "E:\\Resource\\DataSet\\glove.840B.300d.txt";
	public static String Output_emb = "E:\\Resource\\DataSet\\glove.840B.300d.filter.txt";
	public static int Count = 0, find = 0;

	public static void readFile() {
		try {
			int count = 0;
			BufferedReader bReader = new BufferedReader(new FileReader(new File(Source)));
			String line = bReader.readLine();
			while ((line = bReader.readLine()) != null) {
				for (String item : line.split(" ")) {
					if (!words.containsKey(item)) {
						words.put(item, count++);
					}
				}
			}
			bReader.close();
			System.out.println("独立的单词有:" + words.size() + "个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void filter() {
		StringBuilder sBuilder = new StringBuilder();
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(new File(Input_emb)));
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(Output_emb)));
			String line;
			while ((line = bReader.readLine()) != null) {
				if (++Count % 88888 == 0) {
					bWriter.write(sBuilder.toString());
					System.out.println(String.format("共%d个独立单词,已找到%d个", words.size(), find));
					sBuilder = new StringBuilder();
				}
				if (words.containsKey(line.split(" ")[0])) {
					sBuilder.append(line + "\n");
					find++;
					if (find == words.size()) {
						break;
					}
				}
			}
			bWriter.write(sBuilder.toString());
			bReader.close();
			bWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		words = new HashMap<>(240000);
		readFile();
		filter();
	}
}
