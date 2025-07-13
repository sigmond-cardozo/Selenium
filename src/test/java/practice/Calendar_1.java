package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calendar_1 {

    @Test
    public void calendarTest1(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

        driver.findElement(By.id("fifth_date_picker")).click();

        driver.findElement(By.xpath("//a[text()='27']")).click();

        Assert.assertEquals(driver.findElement(By.id("fifth_date_picker")).getAttribute("value"),"06/27/2025");



    }

    @Test
    public void calendarTest2() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

        driver.findElement(By.id("third_date_picker")).click();

        Select dropdown = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
        dropdown.selectByIndex(10);

        Select dropdown2 = new Select(driver.findElement(By.className("ui-datepicker-year")));
        dropdown2.selectByVisibleText("2030");

        driver.findElement(By.xpath("//a[text()='27']")).click();

        Assert.assertEquals(driver.findElement(By.id("third_date_picker")).getAttribute("value"),"11/27/2030");

    }
}
