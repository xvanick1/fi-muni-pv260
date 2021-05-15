import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;

/**
 * @author Jozef Vanický, Michal Zelenák
 * @created 14.05.2021
 * @project pv260-assignment02-task03
 **/

public class FootTests {

    /**
     * Test Privacy policy link in footer
     */
    @Test
    public void privacyPolicyTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.linkText("Privacy policy")).click();
            WebElement header = driver.findElement(By.id("firstHeading"));
            String expectedText = "Privacy policy";
            assertEquals(header.getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    /**
     * Test About Wikipedia link in footer
     */
    @Test
    public void aboutWikipediaTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.linkText("About Wikipedia")).click();
            WebElement header = driver.findElement(By.id("firstHeading"));
            String expectedText = "Wikipedia:About";

            assertEquals(header.getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    /**
     * Test Disclaimers link in footer
     */
    @Test
    public void disclaimersTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.linkText("Disclaimers")).click();
            WebElement header = driver.findElement(By.id("firstHeading"));
            String expectedText = "Wikipedia:General disclaimer";

            assertEquals(header.getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    /**
     * Test Contact Wikipedia link in footer
     */
    @Test
    public void contactLinkTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.linkText("Contact Wikipedia")).click();
            WebElement header = driver.findElement(By.id("firstHeading"));
            String expectedText = "Wikipedia:Contact us";

            assertEquals(header.getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    /**
     * Test Mobile view link in footer
     */
    @Test
    public void mobileViewTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.linkText("Mobile view")).click();
            String expectedUrl = "https://en.wikipedia.org";
            String currentUrl = driver.getCurrentUrl().substring(0, 24);

            assertNotEquals(currentUrl, expectedUrl);
        } finally {
            driver.close();
        }
    }

    /**
     * Test Developers link in footer
     */
    @Test
    public void developersTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.linkText("Developers")).click();
            WebElement header = driver.findElement(By.id("firstHeading"));
            String expectedText = "How to contribute";

            assertEquals(header.getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    /**
     * Test Statistics link in footer
     */
    @Test
    public void statisticsTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.linkText("Statistics")).click();
            String expectedURL = "https://stats.wikimedia.org/#/en.wikipedia.org";

            assertEquals(driver.getCurrentUrl(), expectedURL);
        } finally {
            driver.close();
        }
    }

    /**
     * Test Cookie statement link in footer
     */
    @Test
    public void cookieStatementTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.linkText("Cookie statement")).click();
            WebElement header = driver.findElement(By.id("firstHeading"));
            String expectedText = "Cookie statement";
            assertEquals(header.getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    /**
     * Test Wikimedia Foundation link in footer
     */
    @Test
    public void wikiMediaFoundationTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.xpath("//img[@alt='Wikimedia Foundation']")).click();
            String expectedUrl = "https://wikimediafoundation.org/";

            assertEquals(driver.getCurrentUrl(), expectedUrl);
        } finally {
            driver.close();
        }
    }

    /**
     * Test Powered by MediaWiki link in footer
     */
    @Test
    public void poweredByMediaWikiFoundationTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            driver.findElement(By.xpath("//img[@alt='Powered by MediaWiki']")).click();
            String expectedUrl = "https://www.mediawiki.org/wiki/MediaWiki";

            assertEquals(driver.getCurrentUrl(), expectedUrl);
        } finally {
            driver.close();
        }
    }

}
