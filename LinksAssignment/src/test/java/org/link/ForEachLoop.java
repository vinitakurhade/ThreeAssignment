package org.link;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class ForEachLoop {
public static void main(String[] args) throws IOException, InterruptedException
	{
		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    System.out.println("no of links are   :  "+ links.size());
	    
	//Use foreach loop for printing linktexts 
	System.out.println("print link using for-each loop : - ");
	for (WebElement link : links) {
		System.out.println(link.getAttribute("href"));
	}
}
}
