import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * @author Jozef Vanický, Michal Zelenák
 * @created 14.05.2021
 * @project pv260-assignment02-task03
 **/

public class SearchBarTests {

    /**
     * Test Search panel
     */
    @Test
    public void PositiveSearch(){
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.wikipedia.org");

            WebElement searchBar = driver.findElement(By.id("searchInput"));
            WebElement searchButton = driver.findElement(By.className("pure-button-primary-progressive"));

            searchBar.sendKeys("Masarykova univerzita");
            searchButton.click();

            String expectedUrl = "https://sk.wikipedia.org/wiki/Masarykova_univerzita";
            String actualUrl = driver.getCurrentUrl();

            assertEquals(actualUrl, expectedUrl);
        }
        finally {
            driver.close();
        }
    }

    /**
     * Test switching languages in search panel
     */
    @Test
    public void PositiveSearchInEnglishLanguage(){

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.wikipedia.org");

            WebElement searchBar = driver.findElement(By.id("searchInput"));
            WebElement searchButton = driver.findElement(By.className("pure-button-primary-progressive"));

            Select languageSetting = new Select(driver.findElement(By.id("searchLanguage")));
            languageSetting.selectByValue("de");

            searchBar.sendKeys("Adolf Hitler");
            searchButton.click();

            String expectedUrl = "https://de.wikipedia.org/wiki/Adolf_Hitler";
            String actualUrl = driver.getCurrentUrl();

            assertEquals(actualUrl, expectedUrl);
        }
        finally {
            driver.close();
        }
    }

    /**
     * Test switching the language to deutch in SearchPanel
     */
    @Test
    public void NegativeSearchInEnglishLanguage(){
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.wikipedia.org");

            WebElement searchBar = driver.findElement(By.id("searchInput"));
            WebElement searchButton = driver.findElement(By.className("pure-button-primary-progressive"));

            Select languageSetting = new Select(driver.findElement(By.id("searchLanguage")));
            languageSetting.selectByValue("de");

            searchBar.sendKeys("Adolf Hitler");
            searchButton.click();

            String expectedUrl = "https://sk.wikipedia.org/wiki/Adolf_Hitler";
            String actualUrl = driver.getCurrentUrl();

            assertNotEquals(actualUrl, expectedUrl);
        }
        finally {
            driver.close();
        }
    }

}
