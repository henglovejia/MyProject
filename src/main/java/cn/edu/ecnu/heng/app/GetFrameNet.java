package cn.edu.ecnu.heng.app;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Heng
 *
 * 2018年9月22日-下午12:23:46
 *
 * @detail
 */
public class GetFrameNet {
	public static File source = new File("E:\\Resource\\DataSet\\questions.txt");
	public static String web = "http://demo.ark.cs.cmu.edu/parse/api/v1/parse?sentence=";

	public static void getHTML(List<String> list) {
		try {
			BufferedWriter bWriter = new BufferedWriter(
					new FileWriter(new File("E:\\Resource\\DataSet\\FrameNet_questions.txt")));
			for (String item : list) {
				StringBuilder sBuilder = new StringBuilder();
				URL url = new URL(web + item);
				BufferedReader bReader = new BufferedReader(new InputStreamReader(url.openStream(), "gb2312"));
				String line;
				while ((line = bReader.readLine()) != null) {
					sBuilder.append(line);
					System.out.println(line);
				}
				System.out.println(sBuilder.toString().replace(" ", ""));
				bReader.close();
			}
			bWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<String> getAllLines() {
		List<String> list = new ArrayList<>(809000);
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(source));
			String line;
			while ((line = bReader.readLine()) != null) {
				list.add(line.replace(" ", "+"));
			}
			bReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getHTML(getAllLines());
	}

}
