import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTest {

    WebDriver driver;

    @BeforeAll
    static void setUpAll() {
       WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "driver/LICENSE.chromedriver");
    }

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void teardown() {

        driver.quit();
        driver=null;
    }

    @Test
    void test() throws InterruptedException {
      driver.get("http://localhost:9999");
        WebElement form= driver.findElement(By.cssSelector("[form form_size_m form_theme_alfa-on-white]"));
        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иван Иванов");
        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79059654525");
        form.findElement(By.cssSelector("[button button_view_extra button_size_m button_theme_alfa-on-white] input")).click();
        Thread.sleep(5000);
    }

}

