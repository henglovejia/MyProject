package cn.edu.ecnu.heng.base;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author Heng
 *
 * @create 2018年9月22日-下午1:25:49
 *
 * @detail
 */
public class App {
	private static AtomicLong improve, unimprove;

	/**
	 * 
	 */
	public App() {
		// TODO Auto-generated constructor stub
		improve = new AtomicLong(0);
		unimprove = new AtomicLong(0);
	}

	public static AtomicLong getImprove() {
		return improve;
	}

	public static AtomicLong getUnimprove() {
		return unimprove;
	}
}
