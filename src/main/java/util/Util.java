package util;

public class Util {
	
	// 判斷是否是浮點數
	public static boolean isDouble(String data) {
		try {
			Double.parseDouble(data);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isInt(String data) {
		try {
			Integer.parseInt(data);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
