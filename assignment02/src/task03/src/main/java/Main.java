import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * @author Jozef Vanický, Michal Zelenák
 * @created 14.05.2021
 * @project pv260-assignment02-task03
 **/

public class Main {
    @Test
    public void PositiveSearch(){
        WebDriver driver = new SafariDriver();

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






}
