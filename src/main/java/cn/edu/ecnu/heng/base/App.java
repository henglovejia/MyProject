package cn.edu.ecnu.heng.base;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import cn.edu.ecnu.heng.utils.FileUtil;

/**
 * 
 * @author Heng(MacBook)
 *
 * @create 2018年9月22日-下午7:53:44
 *
 * @detail
 */
public class App {
	private static AtomicLong improve, unimprove;
	private static HashMap<String, double[]> wordVectors;
	static {
		// TODO Auto-generated constructor stub
		improve = new AtomicLong(0);
		unimprove = new AtomicLong(0);
		wordVectors = FileUtil.getGlove("glove.840B.300d.filter.txt");
	}

	public static HashMap<String, double[]> getWordVectors() {
		return wordVectors;
	}

	public static AtomicLong getImprove() {
		return improve;
	}

	public static AtomicLong getUnimprove() {
		return unimprove;
	}
}
