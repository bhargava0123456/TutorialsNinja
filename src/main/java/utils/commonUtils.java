package utils;

import java.util.Date;

public class commonUtils {

	public static final int ImPLICI_WAIT_TIME= 10;
	public static final int PAGE_LOAD_TIME = 10;
	
	public static String getemailwithtimestamp() {
		Date d= new Date();
		return "rage"+d.toString().replace(" ","_").replace(":","_")+"@gmail.com";
	}
	
	
}
