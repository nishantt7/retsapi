package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Testbase {
	
	public Properties prop;
	
	public Testbase() throws IOException 
	{
		try 
		{
		prop=new Properties();
		FileInputStream fi=new FileInputStream("C:\\eclipse\\restapi\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fi);
	    }
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
     }
}