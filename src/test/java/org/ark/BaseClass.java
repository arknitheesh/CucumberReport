package org.ark;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void launchBrowserChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Framwork\\DataDrivenProj\\drivers\\chromedrivers.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	
	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	public static void currentDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy, h:mm a");
		Date date = new Date();
		System.out.println(date);

	}
	
	public static void closetheBrowser() {
		driver.close();

	}
	
	public static File f;
	
	public static void createExcel(String strData) throws IOException {
		f = new File("D:\\Framwork\\DataDrivenProj\\excel\\exce.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Test");
		XSSFRow ro = sheet.createRow(0);
		XSSFCell ce = ro.createCell(0);
		ce.setCellValue(strData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}
	
	public static void readExcel() {
		

	}
	
	public static void createRow(int cro , int roData,String rodata) throws IOException {
		f = new File("D:\\Framwork\\DataDrivenProj\\excel\\exce.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Test");
		Row ro = sheet.createRow(cro);
		Cell cc = ro.createCell(roData);
		cc.setCellValue(rodata);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		

	}
	
	public static void createCell(int cro , int cedata,String data) throws IOException {
		f = new File("D:\\Framwork\\DataDrivenProj\\excel\\exce.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Test");
		Row ro = sheet.getRow(cro);
		Cell cc = ro.createCell(cedata);
		cc.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		

	}

}
