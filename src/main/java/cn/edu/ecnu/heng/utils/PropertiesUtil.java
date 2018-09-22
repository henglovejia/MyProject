/**
 * 
 */
package cn.edu.ecnu.heng.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Heng
 *
 * @create 2018年9月22日-下午12:54:13
 *
 * @detail
 */
public class PropertiesUtil {
	private static Properties pro = new Properties();
	static {
		ClassLoader classLoader = PropertiesUtil.class.getClassLoader();
		try {
			pro.load(classLoader.getResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getString(String code) {
		return pro.getProperty(code);
	}

	public static Integer getInteger(String code) {
		return Integer.parseInt(pro.getProperty(code));
	}

	public static Double getDouble(String code) {
		return Double.parseDouble(pro.getProperty(code));
	}
	
	public static Boolean getBoolean(String code) {
		return Boolean.parseBoolean(pro.getProperty(code));
	}
	public static void saveProperties() {
		
	}
}
