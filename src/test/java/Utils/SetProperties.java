package Utils;

import java.io.File;

public class SetProperties {

	// create reference of ReadProperties class.
	public static ReadProperties appConfig;


	public SetProperties() {
		try {
			appConfig = new ReadProperties();
	

			// Read appConfig properties file
			appConfig.readFile(new File(System.getProperty("user.dir") + "/src/test/java/PropertyFiles/appConfig.properties"));

			
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ReadProperties getObjectReference(String objReference) {

		throw new IllegalArgumentException("Selected object doesn't exist");
	}
}
//adfgshtyjtyhjrtg TEST