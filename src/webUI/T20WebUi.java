package webUI;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T20WebUi {
String url = "https://www.toolsqa.com/automation-practice-table/";
	
	//System.setProperty("webdriver.gecko.driver", "./Driver/geckodriverMAC");
	//FirefoxDriver driver = new FirefoxDriver();
	//ChromeDriver driver = new ChromeDriver();
	
	
	@Test
	public void test_Tables() throws Exception{
		
		try {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver2020"); //chromedriverMac
			ChromeDriver driver = new ChromeDriver();
			driver.get(url);
			Assert.assertEquals(driver.getTitle(), "Demo Table for practicing Selenium Automatiooo");
			
			/*
			 * Need to displaythe TR and TD contents of the table
			 * using the path //*[@id="content"]/table/tbody/tr[i]/td[j]
			 * */
			int trCount = driver.findElements(By.xpath("//*[@id='content']/table/tbody/tr")).size();
			System.out.println(trCount);
			int  tdCount = driver.findElements(By.xpath("//*[@id='content']/table/tbody/tr[1]/td")).size();
			System.out.println(tdCount);
			HashMap<String,List> tableMap = new HashMap<String,List>();
			for(int i = 1 ; i <= trCount ; i++) {
				WebElement structure = driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr["+ i+"]/th"));
				String structname = structure.getText();
				List details = new List();
				for (int j = 1 ; j <= tdCount; j++) {
					WebElement detail = driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr["+ i+"]/td["+j+"]"));
					String detailText = detail.getText();
					details.add(detailText);
				}
			//	System.out.println("Details List rows size : "+ details.getRows());
				tableMap.put(structname,details);
			}
			int mapSize = tableMap.size();
			System.out.println("Total table map Sise is : "+mapSize);
			for (Entry e: tableMap.entrySet()) {
				System.out.println(e.getKey());
				List resultList = (List) e.getValue();
				String[] lssa = resultList.getItems();
				for (int i = 0 ; i<lssa.length;i++ ) {
					System.out.println(lssa[i]);
				
				}
				System.out.println("============================= \n");
			}
			
			driver.close();
			driver.quit();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Test
	public void showTableContents_() throws Exception{
		try {
			System.out.println("Namaste");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver2020"); //chromedriverMac
			ChromeDriver driver = new ChromeDriver();
			driver.get(url);
			Assert.assertEquals(driver.getTitle(), "Demo Table for practicing Selenium Automation");
			int trCount = 0;
			int tdCount = 0 ;
			WebElement tBody = driver.findElement(By.xpath("//tbody"));
			 trCount = driver.findElements(By.xpath("//tbody/tr")).size();
			 for (int i = 1; i <= trCount; i++) {
				 tdCount = driver.findElements(By.xpath("//tbody/tr["+i+"]/td")).size();
				 for (int j = 1; j <= tdCount ; j++) {
					String tdText = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.println(tdText); 
				 }
				 
			 }
			 
			 driver.quit();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Test
	public void testJenkins() {
		System.out.println("Hurrah Jenkins is running my stuff");
	}

}
