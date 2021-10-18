package stepDefinition;

import java.io.BufferedReader;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObject.Car_Page;
import pageObject.Car_ResultPage;


public class BaseClass {

	
	public WebDriver driver;
	public Car_Page car;
	public Car_ResultPage result;
	public static Logger logger;
	public Properties configProp;
	public String lineNumber = "";
	public String inputSearch = "BW57BOW";
	public String line = "";
	public BufferedReader bre;
	public String expectedTitle=  "Car Tax Check | Free Vehicle Check  | BW57BOF";

}
