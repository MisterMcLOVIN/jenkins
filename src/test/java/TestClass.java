import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
    }

    @Test
    public void testHover() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        WebElement hoverElement = driver.findElement(By.xpath("//li[text()=' Practice magic']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        WebElement delete = hoverElement.findElement(By.tagName("i"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", delete);
    }

    @Test
    public void testEntries() {
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        driver.manage().window().maximize();
        WebElement entryElement = driver.findElement(By.id("zone2-entries"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", entryElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(entryElement).perform();
        String elementText = js.executeScript("return arguments[0].innerText;", entryElement).toString();
        String expectedEntryCount = "1 Entries";

        if (elementText.equals(expectedEntryCount)) {
            System.out.println("Validation successful - " + elementText);
        } else {
            System.out.println("Entry count is not as we wanted - " + elementText);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
