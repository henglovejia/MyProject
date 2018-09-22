package cn.edu.ecnu.heng.app;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Point {
	int px;
	int py;
	boolean visited;

	public Point(int px, int py) {
		this.px = px;
		this.py = py;
		this.visited = false;
	}

	public int getLength(Point p) {
		return Math.abs(px - p.px) + Math.abs(py - p.py);
	}
}
/**
 * 
 * @author Heng
 *
 * 2018年8月30日-下午3:51:33
 *
 * @detail 测试
 */
public class Test {

	/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
	static final Point START = new Point(0, 0);
	static int minpath = Integer.MAX_VALUE;

	public static int calculate(Point start, Point[] points, int sum, int count) {
		if (count == points.length) {
			minpath = Math.min(minpath, sum + start.getLength(START));
			return minpath;
		}
		for (int i = 0; i < points.length; i++) {
			if (points[i].visited == false) {
				sum += points[i].getLength(start);
				if (sum < minpath) {
					points[i].visited = true;
					calculate(points[i], points, sum, count + 1);
				}
				sum -= points[i].getLength(start);
				points[i].visited = false;
			}
		}
		return minpath;
	}

	public static void main(String[] args) {
		// Scanner input = new Scanner(System.in);
		// int pnum = Integer.parseInt(input.nextLine().trim());
		// /**构建点集*/
		// Point[] points = new Point[pnum];
		// for(int i = 0; i<pnum; i++){
		// String[] locations = input.nextLine().trim().split(",");
		// points[i] = new Point(Integer.parseInt(locations[0]),
		// Integer.parseInt(locations[1]));
		// }
		// input.close();
		// int min = calculate(START, points, 0, 0);
		// System.out.println(min);

	}
}