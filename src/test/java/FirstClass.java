import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver_mac64-2/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }
}