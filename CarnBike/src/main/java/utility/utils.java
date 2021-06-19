
package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class utils {
	public static WebDriver driver;
	
	public static void Launchbrowser() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mfcwl1\\git\\repository1\\CarnBike\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	public static void LaunchBrowser(String BrowserName) {

		if (BrowserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\mfcwl1\\git\\repository1\\CarnBike\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\mfcwl1\\git\\CarNBikeprodRepo\\MavenPro\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}
	public static ArrayList<String> readExcel(String filepath,String Sheetname) throws IOException {
		FileInputStream file = new FileInputStream(filepath);
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheet(Sheetname);
		HSSFCell row = sheet.getRow(0).getCell(0);

		Iterator<Row> rowit = sheet.iterator();
		ArrayList<String> list = new ArrayList<String>();
		while (rowit.hasNext()) {

			list.add(rowit.next().getCell(0).getStringCellValue());

		}

		return list;
	}

}
