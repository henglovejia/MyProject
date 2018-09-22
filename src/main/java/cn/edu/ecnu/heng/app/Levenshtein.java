/**
 * 
 */
package cn.edu.ecnu.heng.app;

import java.util.ArrayList;
import java.util.Arrays;

import cn.edu.ecnu.heng.base.App;
import cn.edu.ecnu.heng.utils.PropertiesUtil;

/**
 * @author Heng
 *
 *         2018年9月22日-下午12:12:31
 *
 * @detail
 */
public class Levenshtein {

	private static int LevenshteinDistance(ArrayList<String> str1, ArrayList<String> str2) {
		ArrayList<String> minstr, maxstr;
		int minlength, maxlength;
		if (str1.size() < str2.size()) {
			minlength = str1.size();
			minstr = str1;
			maxlength = str2.size();
			maxstr = str2;
		} else {
			minlength = str2.size();
			minstr = str2;
			maxlength = str1.size();
			maxstr = str1;
		}
		double left_top, top, left;
		double LevenshteinDistance = (double) maxlength * (100 - PropertiesUtil.getInteger("levenshteinRate")) / 100;
		double[] matrix_before = new double[maxlength + 1];
		double[] matrix_after = new double[maxlength + 1];
		if (PropertiesUtil.getBoolean("showMatrix")) {
			System.out.print(matrix_before[0] + " ");
		}
		for (int i = 1; i <= maxlength; i++) {
			matrix_before[i] = (double) i;
			if (PropertiesUtil.getBoolean("showMatrix")) {
				System.out.print(matrix_before[i] + " ");
			}
		}
		if (PropertiesUtil.getBoolean("showMatrix")) {
			System.out.println();
		}
		App.getUnimprove().getAndAdd(minlength);
		for (int i = 1; i <= minlength; i++) {
			matrix_after[0] = i;
			if (PropertiesUtil.getBoolean("showMatrix")) {
				System.out.print(matrix_after[0] + " ");
			}
			for (int j = 1; j <= maxlength; j++) {
				left = matrix_after[j - 1];
				top = matrix_before[j];
				left_top = matrix_before[j - 1];
				double min = left > top ? top : left;
				if (min >= left_top) {
					matrix_after[j] = left_top + (minstr.get(i - 1).equals(maxstr.get(j - 1)) ? 0 : 1);
				} else {
					matrix_after[j] = min + 1;
				}
				if (PropertiesUtil.getBoolean("showMatrix")) {
					System.out.print(matrix_after[j] + " ");
				}
			}
			if (PropertiesUtil.getBoolean("useImprove")
					&& matrix_after[maxlength - minlength + i] > LevenshteinDistance) {
				App.getImprove().getAndAdd(i);
				return 0;
			}
			matrix_before = matrix_after;
			matrix_after = new double[maxlength + 1];
			if (PropertiesUtil.getBoolean("showMatrix")) {
				System.out.println();
			}
		}
		App.getImprove().getAndAdd(minlength);
		LevenshteinDistance = matrix_before[maxlength];
		return (int) ((1 - (double) LevenshteinDistance / maxlength) * 100);
	}

	public static void main(String[] args) {
		ArrayList<String> str1 = new ArrayList<>(Arrays.asList("1", "2", "3"));
		ArrayList<String> str2 = new ArrayList<>(Arrays.asList("1", "2", "3"));
		LevenshteinDistance(str1, str2);
	}
}
