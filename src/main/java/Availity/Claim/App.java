package Availity.Claim;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException, AWTException
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\PonkumarE\\chromedriver\\chromedriver.exe");
	    ChromeOptions options=new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    WebDriver driver=new ChromeDriver(options);
	    driver.get("https://apps.availity.com/availity/web/public.elegant.login");
	    driver.manage().window().maximize();
	    int err=1;
	    while(err<100)
	    {
	    	try
	    	{
	    		driver.findElement(By.id("userId")).sendKeys("WLPonkumar0254");
	    		Thread.sleep(500);
	    		break;
	    	}
	    	catch(Exception e)
	    	{
	    		err+=1;
	    		Thread.sleep(1000);
	    	}
	    }
	    driver.findElement(By.id("password")).sendKeys("Waterlabs@1234!");
	    Thread.sleep(500);
	    driver.findElement(By.id("loginFormSubmit")).click();  
	    File f=new File("C:\\Users\\PonkumarE\\Documents\\Availity\\Claim status\\Input\\input.xlsx");
	    FileInputStream fis=new FileInputStream(f);
	  	 XSSFWorkbook xsf=new XSSFWorkbook(fis);
	  	 XSSFSheet sheet= xsf.getSheetAt(0);
	  	DataFormatter formatter = new DataFormatter();	
	  	
	    DesktopKeyboard keyboard = new DesktopKeyboard();
	    Robot robot = new Robot();
	    for(int i=1;i<=sheet.getLastRowNum();i++)
	    {
	    	String currstate=formatter.formatCellValue(sheet.getRow(i).getCell(0));
	    	String prevstate="";
	    	int j=i-1;
	    	
	    		 prevstate=formatter.formatCellValue(sheet.getRow(j).getCell(0));
	    		 String payer=formatter.formatCellValue(sheet.getRow(i).getCell(1));
	    		 String currnpi=formatter.formatCellValue(sheet.getRow(i).getCell(2));
	    		 String prevnpi=formatter.formatCellValue(sheet.getRow(j).getCell(2));
	    		 String memid=formatter.formatCellValue(sheet.getRow(i).getCell(3));
	    		 String lastname=formatter.formatCellValue(sheet.getRow(i).getCell(4));
	    		 String firstname=formatter.formatCellValue(sheet.getRow(i).getCell(5));
	    		 String dob=formatter.formatCellValue(sheet.getRow(i).getCell(6));
	    		 String fromdate=formatter.formatCellValue(sheet.getRow(i).getCell(7));
	    		 String todate=formatter.formatCellValue(sheet.getRow(i).getCell(8));
	    		 boolean b=!currstate.equals(prevstate);
		    	 boolean c=!currnpi.equals(prevnpi);
	 	    	
	 	    	if(b)
	 	    	{
	 	    		 
	 	    		        Thread.sleep(7000);
	 	    		        int err1=1;
	 	    		       while(err1<500)
	 	    		       {
	 	    		    	   try
	 	    		    	   {
	 	    		    		   driver.switchTo().defaultContent();
	 	    		    		   Thread.sleep(3000);
	 	    		    		   driver.findElement(By.xpath("(//li[@class='av-nav-lg'])[1]")).click();
	 	   	    	    		Thread.sleep(3000);
	 	   	    	    		break;
	 	   	    	    		
	 	    		    	   }
	 	    		    	   catch(Exception e)
	 	    		    	   {
	 	    		    		   
	 	    		    		   err1+=1;
	 	    		    		  
	 	    		    		   Thread.sleep(1000);
	 	    		    	   }
	 	    		       }
	 	    	    		
	 	    		
	 	    		driver.findElement(By.xpath("//div[@class='select2-search']//input[1]")).sendKeys(currstate);
	 	    	    robot.keyPress(KeyEvent.VK_ENTER);
	 	            robot.keyRelease(KeyEvent.VK_ENTER);
	 	            Thread.sleep(5000);
	 	            driver.switchTo().frame("newBody");
	 	            Thread.sleep(2000);
	 	            driver.findElement(By.xpath("//h3[text()='Claim Status']")).click();
	 	    	}
	 	    	int err2=1;
		    	while(err2<500)
			       {
			    	   try
			    	   {
			    		  driver.findElement(By.xpath("//div[@class='payer-select__input-container css-vcw2c9']")).click();
			    		  Thread.sleep(500);
			    		  StringSelection stringSelection = new StringSelection(payer);
			    	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			    	        clipboard.setContents(stringSelection, stringSelection);
			    	        robot.keyPress(KeyEvent.VK_CONTROL);
			    	        robot.keyPress(KeyEvent.VK_V);
			    	        robot.keyRelease(KeyEvent.VK_V);
			    	        robot.keyRelease(KeyEvent.VK_CONTROL);
			    	        
			    	        Thread.sleep(500);
			    	        robot.keyPress(KeyEvent.VK_TAB);
			    	        robot.keyRelease(KeyEvent.VK_TAB);
			    	        
	    	    		break;
	    	    		
			    	   }
			    	   catch(Exception e)
			    	   {	
			    		   
			    		   err2+=1;
			    		  
			    		   Thread.sleep(1000);
			    	   }
			       }
		    	Thread.sleep(3000);
		    	try
		    	{
		    		driver.findElement(By.id("HIPAA Standard")).click();
		    		Thread.sleep(2000);
		    		
		    	}
		    	catch(Exception e)
		    	{
		    		
		    	}
		    	driver.findElement(By.xpath("//*[@id='providerSelect'	]/div/div[1]/div[2]")).click();
		    	 Thread.sleep(500);
	    		  StringSelection stringSelection = new StringSelection(currnpi);
	    	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    	        clipboard.setContents(stringSelection, stringSelection);
	    	        robot.keyPress(KeyEvent.VK_CONTROL);
	    	        robot.keyPress(KeyEvent.VK_V);
	    	        robot.keyRelease(KeyEvent.VK_V);
	    	        robot.keyRelease(KeyEvent.VK_CONTROL);
	    	        //if(c)
	    	        Thread.sleep(3500);
	    	       // else
	    	        	//Thread.sleep(1000);
	    	        robot.keyPress(KeyEvent.VK_TAB);
	    	        robot.keyRelease(KeyEvent.VK_TAB);
	    	        Thread.sleep(1000);
	    	        driver.findElement(By.id("patientMemberId")).click();
	    	        Thread.sleep(500);
	    	        StringSelection stringSelection1 = new StringSelection(memid);
	    	        Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
	    	        clipboard1.setContents(stringSelection1, stringSelection1);
	    	        robot.keyPress(KeyEvent.VK_CONTROL);
	    	        robot.keyPress(KeyEvent.VK_V);
	    	        robot.keyRelease(KeyEvent.VK_V);
	    	        robot.keyRelease(KeyEvent.VK_CONTROL);
	    	        
	    	        Thread.sleep(1000);
	    	        robot.keyPress(KeyEvent.VK_TAB);
	    	        robot.keyRelease(KeyEvent.VK_TAB);
	    	        Thread.sleep(1000);
	    	        driver.findElement(By.name("patientLastName")).click();
	    	        Thread.sleep(500);
	    	        StringSelection stringSelection2 = new StringSelection(lastname);
	    	        Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
	    	        clipboard2.setContents(stringSelection2, stringSelection2);
	    	        robot.keyPress(KeyEvent.VK_CONTROL);
	    	        robot.keyPress(KeyEvent.VK_V);
	    	        robot.keyRelease(KeyEvent.VK_V);
	    	        robot.keyRelease(KeyEvent.VK_CONTROL);
	    	        
	    	        Thread.sleep(1000);
	    	        robot.keyPress(KeyEvent.VK_TAB);
	    	        robot.keyRelease(KeyEvent.VK_TAB);
	    	        Thread.sleep(1000);
	    	        driver.findElement(By.name("patientFirstName")).click();
	    	        Thread.sleep(500);
	    	        StringSelection stringSelection3 = new StringSelection(firstname);
	    	        Clipboard clipboard3 = Toolkit.getDefaultToolkit().getSystemClipboard();
	    	        clipboard3.setContents(stringSelection3, stringSelection3);
	    	        robot.keyPress(KeyEvent.VK_CONTROL);
	    	        robot.keyPress(KeyEvent.VK_V);
	    	        robot.keyRelease(KeyEvent.VK_V);
	    	        robot.keyRelease(KeyEvent.VK_CONTROL);
	    	        
	    	        Thread.sleep(1000);
	    	        robot.keyPress(KeyEvent.VK_TAB);
	    	        robot.keyRelease(KeyEvent.VK_TAB);
	    	        Thread.sleep(1000);
	    	        String dateofb;
	    	        String[] dateComponents = dob.split("/");
	    	        if (dateComponents.length == 3) {
	    	            
	    	            int month = Integer.parseInt(dateComponents[0]);
	    	            int day = Integer.parseInt(dateComponents[1]);
	    	            int year = Integer.parseInt(dateComponents[2]);
	    	            System.out.println(year);
	    	            // Determine the century for the year component
	    	            if (year < 25) {
	    	                year += 2000;
	    	            } else {
	    	                year += 1900;
	    	            }
	    	            
	    	            // Create the output date string in "MM/dd/yyyy" format
	    	             dateofb = String.format("%02d/%02d/%04d", month, day, year);
	    	             typeText(robot, dateofb);
	    	             Thread.sleep(1000);
	    	             robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	    	           	 robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    	           	 Thread.sleep(2000);
	    	        }
	    	        driver.findElement(By.id("serviceDates-start")).click();
	    	        Thread.sleep(500);
	    	        String fdate;
	    	        String[] dateComponents1 = fromdate.split("/");
	    	        if (dateComponents1.length == 3) {
	    	            
	    	            int month1 = Integer.parseInt(dateComponents1[0]);
	    	            int day1 = Integer.parseInt(dateComponents1[1]);
	    	            int year1 = Integer.parseInt(dateComponents1[2]);
	    	            System.out.println(year1);
	    	            // Determine the century for the year component
	    	            if (year1 < 25) {
	    	                year1 += 2000;
	    	            } else {
	    	                year1 += 1900;
	    	            }
	    	            
	    	            // Create the output date string in "MM/dd/yyyy" format
	    	             fdate = String.format("%02d/%02d/%04d", month1, day1, year1);
	    	             typeText(robot, fdate);
	    	             
	    	             Thread.sleep(1000);
	    	        }
	    	        driver.findElement(By.id("serviceDates-end")).click();
	    	       /* Thread.sleep(500);
	    	        String tdate;
	    	        String[] dateComponents2 = todate.split("/");
	    	        if (dateComponents1.length == 3) {
	    	            
	    	            int month2 = Integer.parseInt(dateComponents1[0]);
	    	            int day2 = Integer.parseInt(dateComponents1[1]);
	    	            int year2 = Integer.parseInt(dateComponents1[2]);
	    	            System.out.println(year2);
	    	            // Determine the century for the year component
	    	            if (year2 < 25) {
	    	                year2 += 2000;
	    	            } else {
	    	                year2 += 1900;
	    	            }
	    	            
	    	            // Create the output date string in "MM/dd/yyyy" format
	    	             tdate = String.format("%02d/%02d/%04d", month2, day2, year2);
	    	             typeText(robot, tdate);
	    	             
	    	            
	    	        }*/
	    	        Thread.sleep(1000);
	    	        driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    	        Thread.sleep(13000);
	    	        try
	    	        {
	    	        	String error=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]")).getText();
	    	        }
	    	        catch(Exception e)
	    	        {
	    	        	
	    	        		String name=driver.findElement(By.className("h2")).getText();
	    	        		String memberid=driver.findElement(By.xpath("(//span[@class='font-weight-bold'])[1]")).getText();
	    	        		String dateob=driver.findElement(By.xpath("(//span[@class='font-weight-bold'])[2]")).getText();
	    	        		String subsc=driver.findElement(By.xpath("(//span[@class='font-weight-bold'])[3]")).getText();
	    	        		String provi= driver.findElement(By.xpath("(//span[@class='font-weight-bold'])[4]")).getText();
	    	        	    String provid=driver.findElement(By.xpath("(//span[@class='font-weight-bold'])[5]")).getText();
	    	        	    String claim=driver.findElement(By.xpath("//span[@class='my-2 h3']")).getText();
	    	        	    String claimno=claim.substring(6);
	    	        	    String dos=driver.findElement(By.xpath("(//*[text()='Dates of Service'])[2]/following::div[1]")).getText();
	    	        	    String status=driver.findElement(By.xpath("(//*[text()='Dates of Service'])[2]/following::div[7]")).getText();
	    	        	    String processeddate=driver.findElement(By.xpath("(//*[text()='Dates of Service'])[2]/following::div[4]")).getText();
	    	        	    String checkno=driver.findElement(By.xpath("(//*[text()='Dates of Service'])[2]/following::div[28]")).getText();
	    	        	    String accountno=driver.findElement(By.xpath("(//*[text()='Dates of Service'])[2]/following::div[31]")).getText();
	    	        	    
	    	        
	    	        driver.findElement(By.id("printBtn")).click();
	    	        if(i==1)
	    	        {
	    	        	Thread.sleep(15000);
	    	        }
	    	        else
	    	        {
	    	        	Thread.sleep(3000);
	    	        	
	    	        }
	    	        keyboard.keyDown(KeyEvent.VK_ENTER);
	                keyboard.keyUp(KeyEvent.VK_ENTER);
	                Thread.sleep(3000);
	                
	                String path1="C:\\Users\\PonkumarE\\Documents\\Availity\\Claim status\\"+memid;
	                
	                StringSelection stringSelection7 = new StringSelection(path1);
	                Clipboard clipboard7 = Toolkit.getDefaultToolkit().getSystemClipboard();
	                clipboard7.setContents(stringSelection7, stringSelection7);
	                robot.keyPress(KeyEvent.VK_CONTROL);
	                robot.keyPress(KeyEvent.VK_V);
	                robot.keyRelease(KeyEvent.VK_V);
	                robot.keyRelease(KeyEvent.VK_CONTROL);
	                Thread.sleep(1000);
	                keyboard.keyDown(KeyEvent.VK_ENTER);
	                keyboard.keyUp(KeyEvent.VK_ENTER);
	                  Thread.sleep(2000);
	                  driver.findElement(By.id("newSearchBtn")).click();
	    	        }
	    }
    }
	    public static void typeText(Robot robot, String text) {
	        for (char c : text.toCharArray()) {
	            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
	            robot.keyPress(keyCode);      
	            robot.keyRelease(keyCode);    
	        }
	    }
}
