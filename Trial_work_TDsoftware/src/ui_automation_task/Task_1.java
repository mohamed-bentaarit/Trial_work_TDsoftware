package ui_automation_task;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;  

public class Task_1 {

public static void main(String[] args) throws InterruptedException {
	
	int min_day					= 1 ;
    int max_day					= 0 ;
	int random_day				= 0 ;
	int currentmonth			= 0 ;
	int nextmonth				= 0 ;
	String projectlocation 		= System.getProperty("user.dir");
	String baseurl 				= "http://webdriveruniversity.com/Datepicker/index.html";
	String xpath_months 		= "//span[contains(@class, 'month')]";
	String xpath_activemonth 	= "//span[@class = 'month active']";
	String xpath_calendar_icon 	= "//i" ;
	String xpath_nextmonth_icon = "//div[contains(@class, 'days')]/table/thead/tr/th[contains(@class, 'next')]";
	String xpath_day			= "//*[@class='day']";
	String xpath_randomday 		= "//*[@class='day' and text()='";

	
	// System Property for Chrome Driver   
    System.setProperty("webdriver.chrome.driver", projectlocation+"\\lib\\chromedriver\\chromedriver.exe");  
    // Instantiate a ChromeDriver class.       
    WebDriver driver= new ChromeDriver();  
	//Open Chrome and go to baseurl.
	driver.navigate().to(baseurl);
	//Maximize the browser  
    driver.manage().window().maximize();  
    
    //Define WebElement needed to open calendar.
    WebElement calendar_icon =  driver.findElement(By.xpath(xpath_calendar_icon)) ;
    
    //Open calendar.
    calendar_icon.click();
    
    //Define WebElement of currentmonth month.
    WebElement activemonth = driver.findElement(By.xpath(xpath_activemonth));
    
    //Get index of active month in listofmonths.
    List<WebElement> ListOfmonths = driver.findElements(By.xpath(xpath_months));
    currentmonth = ListOfmonths.indexOf(activemonth);
    
    //Click nextmonth_icon.
    WebElement nextmonth_icon = driver.findElement(By.xpath(xpath_nextmonth_icon));
    nextmonth_icon.click();
    
    //Delay 2 seconds.
    Thread.sleep(2000);
    
    //Click random day in next month.
    List<WebElement> ListOfdays = driver.findElements(By.xpath(xpath_day));
    Random r 		= new Random();
    max_day			= ListOfdays.size();
    random_day		= r.nextInt(max_day-min_day) + min_day;
    xpath_randomday = (xpath_randomday+ random_day + "']" );
    driver.findElement(By.xpath(xpath_randomday)).click();
    
    //Open calendar.
    calendar_icon.click();

    //Get index of nextmonth in listofmonths.
    ListOfmonths = driver.findElements(By.xpath(xpath_months));
    activemonth = driver.findElement(By.xpath(xpath_activemonth));
    nextmonth = ListOfmonths.indexOf(activemonth);
    
    //Test Date changed to next month or Not.
    if ( nextmonth == currentmonth+1){
    	System.out.println("Test Passed : Date changed to next month");
     
    }else{
    	System.out.println("Test Failed : Date changed to next month");
    }
    
    //Delay 2 seconds.
    Thread.sleep(2000);
    
    //Close Browser.
    driver.quit();
}
}