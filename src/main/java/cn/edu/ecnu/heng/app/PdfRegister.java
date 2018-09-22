package cn.edu.ecnu.heng.app;
/**
 * 
 * @author Heng
 *
 * 2018年9月22日-下午12:24:52
 *
 * @detail
 */
public class PdfRegister {
	static public String getRegCode(String machineCode){
        long num = Long.parseLong(machineCode);
        for (int i = 0; i < 100; i++){
        	String text = String.valueOf(num*2L);
            if (text.length() <= 12){
                num = Long.parseLong(text);
            }
            else{
                num = Long.parseLong(text.substring(0, 12));
            }
        }
        return String.valueOf(num);
    }
	public static void main(String[] args) {
		String machineCode = "759134111";
		System.out.println(getRegCode(machineCode));
	}
}
