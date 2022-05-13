package reviewClass01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertions {
    WebDriver driver;
    @BeforeMethod
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alternativebrewing.com.au/blogs/coffee-guides/coffee-grinding-guide");
    }
    @Test
    public void testFile(){
        String actualTitle = driver.findElement(By.xpath("//h1[@class='page__title heading h1']")).getText();
        String expectedTitle="Coffee Grinding Guide";
        Assert.assertEquals(actualTitle, expectedTitle);

        String title2 = driver.findElement(By.id("coffeefreshnessisfleetingHeader")).getText();
        String expectedTitle2 = "Coffee Freshness Is Fleeting";
        System.out.println("H:E:L:L:O");
        Assert.assertEquals(title2,expectedTitle2);
        SoftAssert soft = null;
        soft.assertEquals(title2,expectedTitle2);
        soft.assertAll();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
