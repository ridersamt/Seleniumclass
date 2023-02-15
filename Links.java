package Links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Links {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "Utils/chromedriver_win32/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        

        driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
        Thread.sleep(5000);

        byxpath();
     //   linksbytagname();
        //driver.quit();
    }


    public static void linksbytagname()
    {
        System.out.println("By tagName,getText, getAttribute method");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        //Traversing through the list and printing its text along with link address
        for(WebElement link:allLinks){
            System.out.println(link.getText() + " - " + link.getAttribute("href"));
            System.out.println("------------------------------------------------------");
        }

    }

    public static void byxpath()
    {
        System.out.println("By Xpath method");

        String xp="//a[@class=\"sl-sobe-carousel-sub-card-link\"]";
        List<WebElement> alllinks = driver.findElements(By.xpath(xp));
        for(WebElement link:alllinks)
        {
            System.out.println(link.getText()+" - "+link.getAttribute("href"));
        }
    }
}
