package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import commonMethods.DataprovideData;
import utility.utils;

public class Amphtmlvalidation extends utils{

	
	@BeforeTest
	public void setup() {
		
		Launchbrowser();
	}
	@Test(dataProvider ="AmpUrl", dataProviderClass = DataprovideData.class)
	public void code(String URL) throws Exception {
		driver.get("https://validator.ampproject.org/");
		
driver.findElement(By.xpath("(//*[@id=\"input\"])[2]")).sendKeys(URL,Keys.ENTER);
Thread.sleep(3000);
	
		String message=driver.findElement(By.xpath("//div[@class='ampproject-result style-scope webui-statusbar']/span")).getText();//Status Text


		if(message.equals("PASS")) {
			System.out.println("URL-"+URL);
			System.out.println("Validation Status - "+message);
			
		}else if(message.equals("FAIL")) {
			System.out.println("URL-"+URL);
			System.out.println("Validation Status - "+message);
			String Errormsg=driver.findElement(By.xpath("//*[@id=\"listbox\"]/paper-item[1]")).getText();
			System.out.println("Error message -"+Errormsg);
			String Errormsg1=driver.findElement(By.xpath("//*[@id=\"listbox\"]/paper-item[2]")).getText();
			System.out.println("Error message -"+Errormsg1);
			String Errormsg2=driver.findElement(By.xpath("//*[@id=\"listbox\"]/paper-item[3]")).getText();
			System.out.println("Error message -"+Errormsg2);
			String Errormsg3=driver.findElement(By.xpath("//*[@id=\"listbox\"]/paper-item[4]")).getText();
			System.out.println("Error message -"+Errormsg3);
			
		}
		
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
		
	}
}
