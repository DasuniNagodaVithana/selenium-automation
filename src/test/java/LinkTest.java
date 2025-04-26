import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTests(){
        //01) Take me to dashboard
      WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
      homeLink.click();
      driver.navigate().back();

      //02)Find my destination
        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This link is going to: " + path);

      //03) Am I broken link ?
        WebElement brokenLink = driver.findElement(By.partialLinkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("This link is broken");
        }else {
            System.out.println("This link is not broken");
        }
        driver.navigate().back();

        //04) Duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //05) Count page Links
        List<WebElement> countfullpageLinks = driver.findElements(By.tagName("a"));
        int pageLinkCount = countfullpageLinks.size();
        System.out.println("Page link count is: "+pageLinkCount);

        //06) Count layout links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("Layout link count is: "+countOfLayoutLinks.size());






    }
}
