package newsAutomation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
	/* This will retrieve a property value */
	private String result = "";
	private InputStream inputStream;
	
	public String getProperty(String key) throws IOException {
		
		Properties properties = new Properties();
		
		String propFileName = "framework.properties";
		
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		
		if (inputStream != null) {
			properties.load(inputStream);
			
		} else {
			throw new FileNotFoundException("Properties File not found");
		}
		
		
		String propertyValue = properties.getProperty(key);
		
		this.result = propertyValue;
		
		
		return result;
		
	}

}
