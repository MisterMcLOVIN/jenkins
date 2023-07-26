import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwoopTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.swoop.ge/");
    }

    @Test
    public void logInTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement logInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='HeaderTools swoop-login']/p")));
        logInButton.click();

        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='close-button']/a/img")));
        closeButton.click();
    }

}
