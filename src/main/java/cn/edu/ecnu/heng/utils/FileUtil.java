/**
 * 
 */
package cn.edu.ecnu.heng.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import cn.edu.ecnu.heng.base.App;

/**
 * @author Heng
 *
 * @create 2018年9月22日-下午12:57:34
 *
 * @detail
 */
public class FileUtil {
	/**
	 * 
	 */
	public static HashMap<String, double[]> getGlove(String filename) {
		// TODO Auto-generated constructor stub
		ClassLoader classLoader = FileUtil.class.getClassLoader();
		HashMap<String, double[]> map = new HashMap<>();
		System.out.println("正在读取:" + filename);
		try {
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

	public static void main(String[] args) {
		System.out.println(App.getWordVectors().get("the"));
	}
}
