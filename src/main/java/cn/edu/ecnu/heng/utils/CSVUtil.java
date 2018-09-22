/**
 * 
 */
package cn.edu.ecnu.heng.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * @author Heng
 *
 * @create 2018年9月22日-下午12:57:34
 *
 * @detail
 */
public class CSVUtil {
	/**
	 * 
	 */
	public static HashMap<String, Double[]> getGlove(String filename) {
		// TODO Auto-generated constructor stub
		ClassLoader classLoader = CSVUtil.class.getClassLoader();
		HashMap<String, Double[]> map = new HashMap<>();
		try {
			BufferedReader bReader = new BufferedReader(
					new FileReader(new File(classLoader.getResource(filename).toString().replace("file:", ""))));
			String line;
			while ((line = bReader.readLine()) != null) {
				String[] items = line.split(" ");
				Double[] item = new Double[items.length-1];
				for (int i = 1; i < items.length; i++) {
					item[i-1] = Double.parseDouble(items[i]);
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
		HashMap<String, Double[]> map = getGlove("glove.840B.300d.filter.txt");
		System.out.println(map.get("the"));
	}
}
