package cn.edu.ecnu.heng.app;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Heng
 *
 * 2018年9月22日-下午12:24:26
 *
 * @detail
 */
public class GetThunder {

	private static String web;

	public static void getAllThunder() {
		List<String> source = getHTML();
		StringBuilder sBuilder = new StringBuilder();
		int count = 0;
		try {
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File("thunders.txt")));
			for (String line : source) {
				if (line.indexOf("thunder://") != -1) {
					for (String item : line.split("\"")) {
						if (item.indexOf("thunder://") != -1) {
							sBuilder.append(item + "\n");
							count++;
						}
					}
				}
			}
			bWriter.write(sBuilder.toString());
			setSysClipboardText(sBuilder.toString());
			bWriter.close();
			System.out.println("Get " + count + " thunders");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/** 
     * 将字符串复制到剪切板。 
     */  
    public static void setSysClipboardText(String writeMe) {  
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();  
        Transferable tText = new StringSelection(writeMe);  
        clip.setContents(tText, null);  
    } 

	public static List<String> getHTML() {
		List<String> list = new ArrayList<>();
		try {
			URL url = new URL(web);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(url.openStream(), "gb2312"));
			String line;
			while ((line = bReader.readLine()) != null) {
				list.add(line);
			}
			bReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the url:");
		web = in.nextLine();
		in.close();
		getAllThunder();
	}

}
