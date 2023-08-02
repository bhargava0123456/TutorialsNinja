package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;

	public static Properties initiazeproperties() throws IOException  {
		
		Properties prop= new Properties();		
		FileInputStream fis = new FileInputStream("C:\\Bhargav Files\\config.properties");
		prop.load(fis);
		return prop;
	      
	}
	
	
	public String getReportConfigPath(){
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
