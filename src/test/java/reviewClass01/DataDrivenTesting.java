package reviewClass01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {
    WebDriver driver;

    @DataProvider(name = "credentials")
    public Object[][] data() {
        Object[][] login = {
                {"login@codility.com", "password", "Welcome to Codility"},
                {"unknown@codility.com", "password", "You shall not pass! Arr!"},
                {"unknowncodility.com", "password", "Enter a valid email"},
                {"", "password", "Email is required"},
                {"login@codility.com", "", "Password is required"}};
        return login;
    }

    // validate for credentials
    @Test(dataProvider = "credentials")
    public void validateCredentials(String email, String password, String expectedMessage) {
        WebElement emailCredentials = driver.findElement(By.id("email-input"));
        WebElement passwordCredentials = driver.findElement(By.id("password-input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // send the credentials
        emailCredentials.sendKeys(email);
        passwordCredentials.sendKeys(password);
        loginButton.click();
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='message success']"));
        String actualMsg = actualMessage.getText();

        // Assert and check
        Assert.assertEquals(actualMsg, expectedMessage);



    }


    // check the visibility of the elements
    @Test
    public void visibilityOfElements() {
        WebElement email = driver.findElement(By.id("email-input"));
        WebElement password = driver.findElement(By.id("password-input"));
        Boolean isEmailDisplayed = email.isDisplayed();
        Boolean isPasswordDisplayed = password.isDisplayed();
        Assert.assertTrue(isEmailDisplayed);
        Assert.assertTrue(isPasswordDisplayed);
    }

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

