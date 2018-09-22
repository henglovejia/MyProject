package cn.edu.ecnu.heng.app;
import java.io.File;

public class RenameVedio {
	public static String file = "F:\\Video\\美食的俘虏";
	public static String format = ".rmvb";

	public static void readAllFile() {
		File vedio = new File(file);
		for (File item : vedio.listFiles()) {
			if (item.getName().endsWith(format)) {
				int start = item.getName().indexOf("]") + 1;
				int end = item.getName().lastIndexOf("]") + 1;
				if (start != end) {
					System.out.println(item.getName());
					item.renameTo(new File(file + File.separator + item.getName().substring(start)));
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readAllFile();
	}

}
