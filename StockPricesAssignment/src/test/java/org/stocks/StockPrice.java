package org.stocks;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StockPrice {


public static void main(String[] args) throws InterruptedException, IOException {

    WebDriver driver = (WebDriver) new ChromeDriver();

    driver.get("https://money.rediff.com/losers/bse/daily/groupall");

    Thread.sleep(3000);

    // Find and store the stock prices in a HashMap using Selenium
    Map<String, String> stockPricesSelenium = new HashMap<>();
    WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']"));
    for (WebElement row : table.findElements(By.xpath(".//tr[position()>1]"))) {
        String stockName = row.findElement(By.xpath(".//td[1]")).getText();
        String stockPrice = row.findElement(By.xpath(".//td[4]")).getText();
        stockPricesSelenium.put(stockName, stockPrice);
    }

    // Read data from Excel file and store in a HashMap
    Map<String, String> stockPricesExcel = new HashMap<>();
    FileInputStream file = new FileInputStream(new File("path_to_excel_file"));
    Workbook workbook = new XSSFWorkbook(file);
    Sheet sheet = workbook.getSheetAt(0);
    for (Row row : sheet) {
        String stockName = row.getCell(0).getStringCellValue();
        String stockPrice = String.valueOf(row.getCell(1).getNumericCellValue());
        stockPricesExcel.put(stockName, stockPrice);
    }
    workbook.close();

    // Compare the values stored in the two HashMaps
    for (String stock : stockPricesExcel.keySet()) {
        String priceFromExcel = stockPricesExcel.get(stock);
        String priceFromSelenium = stockPricesSelenium.get(stock);
        if (priceFromExcel.equals(priceFromSelenium)) {
            System.out.println(stock + ": Prices Matched!");
        } else {
            System.out.println(stock + ": Prices DID NOT Match!");
        }
    }

    // Close the WebDriver
    driver.quit();
}}
