package cn.edu.ecnu.heng.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONObject;
/**
 * 
 * @author Heng
 *
 * 2018年9月22日-下午12:27:06
 *
 * @detail
 */
public class ReadJson {
	public static void read(String fileName) {
		try {
			String json;
			BufferedReader bReader = new BufferedReader(new FileReader(new File(fileName)));
			StringBuilder sBuilder = new StringBuilder();
			String line;
			while ((line = bReader.readLine()) != null) {
				sBuilder.append(line);
			}
			json = sBuilder.toString();
			System.out.println("json:" + json);
			JSONObject jsonObject = new JSONObject(json);
			bReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
