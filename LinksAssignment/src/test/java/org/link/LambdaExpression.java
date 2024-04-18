package org.link;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class LambdaExpression {
public static void main(String[] args) throws IOException, InterruptedException
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	List<WebElement> links = driver.findElements(By.tagName("a"));
	
	System.out.println("no of links are"+ links.size());
    links.forEach(link-> System.out.println(link.getAttribute("href")));
	driver.quit();
	

}
}
