package cn.edu.ecnu.heng.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CMD {
	public static void cmd(String cmd) {
		Runtime run = Runtime.getRuntime();
		try {
			Process process = run.exec(cmd);
			InputStream input = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String szline;
			while ((szline = reader.readLine()) != null) {
				System.out.println(szline);
			}
			reader.close();
			process.waitFor();
			process.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		cmd("Rscript E:\\Python\\qna-master\\Test.R");
	}
}
