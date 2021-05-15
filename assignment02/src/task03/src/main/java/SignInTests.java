import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * @author Jozef Vanický, Michal Zelenák
 * @created 14.05.2021
 * @project pv260-assignment02-task03
 **/
public class SignInTests {
    @Test
    public void PositiveLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            TimeUnit.SECONDS.sleep(5);
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
            WebElement login = driver.findElement(By.id("wpName1"));
            WebElement password = driver.findElement(By.id("wpPassword1"));
            WebElement loginButton = driver.findElement(By.id("wpLoginAttempt"));
            login.sendKeys("MuniAcc");
            password.sendKeys("MasarykUni123");
            loginButton.click();
            driver.findElement(By.linkText("MuniAcc")).isDisplayed();
            assertEquals(true, driver.findElement(By.linkText("MuniAcc")).isDisplayed());
        } finally {
            driver.close();
        }

    }

    @Test
    public void IncorrectLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            TimeUnit.SECONDS.sleep(5);
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");

            WebElement login = driver.findElement(By.id("wpName1"));
            WebElement password = driver.findElement(By.id("wpPassword1"));
            WebElement loginButton = driver.findElement(By.id("wpLoginAttempt"));
            login.sendKeys("MuniAcc2");
            password.sendKeys("MasarykUni123");
            loginButton.click();
            WebElement errorMsg = driver.findElement(By.className("errorbox"));

            String expectedText = "Incorrect username or password entered. Please try again.";
            assertEquals(errorMsg.getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    @Test
    public void titleTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
            WebElement header = driver.findElement(By.id("firstHeading"));

            String expectedText = "Log in";
            assertEquals(header.getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    @Test
    public void forgotPasswordTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");

            driver.findElement(By.linkText("Forgot your password?")).click();
            WebElement header = driver.findElement(By.id("firstHeading"));
            String expectedText = "Reset password";
            assertEquals(header.getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    @Test
    public void HelpLoginTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");

            driver.findElement(By.linkText("Help with logging in")).click();
            WebElement header = driver.findElement(By.id("firstHeading"));
            String expectedText = "Help:Logging in";
            assertEquals(header.getText(), expectedText);
        } finally {
            driver.close();
        }
    }


}
