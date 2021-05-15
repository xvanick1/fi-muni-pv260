import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Jozef Vanický, Michal Zelenák
 * @created 14.05.2021
 * @project pv260-assignment02-task03
 **/

public class LeftNavigationTests {
    @Test
    public void LeftUpperNavigationGoToTalkThenMain(){
        WebDriver driver = new SafariDriver();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        WebElement menuElementTalk = driver.findElement(By.id("ca-talk"));
        menuElementTalk.click();

        String expectedUrl = "https://en.wikipedia.org/wiki/Talk:Main_Page";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);


        menuElementTalk = driver.findElement(By.id("ca-nstab-main"));
        menuElementTalk.click();

        expectedUrl = "https://en.wikipedia.org/wiki/Main_Page";
        actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void LeftUpperNavigationGoToTalkFailed(){
        final ExpectedException exception = ExpectedException.none();

        WebDriver driver = new SafariDriver();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        WebElement menuElementTalk = driver.findElement(By.id("ca-talks"));
        exception.expect(Exception.class);
    }





}
