package dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyObjectProvider
{
	public Properties getAuthPropObj() throws IOException
	{
		Properties prop = new Properties();
		InputStream inStream = new FileInputStream("C:\\Users\\Prabhanjan_Kulkarni\\eclipse-workplace-1\\WebScrapingJsoup\\src\\main\\resources\\Authenticate.properties");
		prop.load(inStream);
		return prop;
	}
	public Properties getMailPropObj() throws IOException
	{
		Properties prop = new Properties();
		InputStream inStream = new FileInputStream("C:\\Users\\Prabhanjan_Kulkarni\\eclipse-workplace-1\\WebScrapingJsoup\\src\\main\\resources\\Mail.properties");
		prop.load(inStream);
		return prop;
	}
	public Properties getConfigPropObj() throws IOException
	{
		Properties prop = new Properties();
		InputStream inStream = new FileInputStream("C:\\Users\\Prabhanjan_Kulkarni\\eclipse-workplace-1\\WebScrapingJsoup\\src\\main\\resources\\Config.properties");
		prop.load(inStream);
		return prop;
	}
}

