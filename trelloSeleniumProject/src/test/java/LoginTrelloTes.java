import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class LoginTrelloTes {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void LoginTrelloTes() {

        openSite();
        wd.findElement(By.cssSelector("div.global-header.u-clearfix")).click();
        wd.findElement(By.linkText("Зарегистрироваться")).click();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).sendKeys("\\undefined");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).sendKeys("\\undefined");


        enterUserName("elena.telran@yahoo.com");
        enterPassword("12345.com");
        confirmLogin();
    }

    private void confirmLogin() {
        wd.findElement(By.id("login")).click();
    }

    private void enterPassword(String pwd) {
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys(pwd);
    }

    private void enterUserName(String userName) {
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys(userName);
    }


    private void openSite() {
        wd.get("https://trello.com/");
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
