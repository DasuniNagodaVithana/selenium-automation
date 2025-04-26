import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {
    WebDriver driver;

    @BeforeMethod
    public void DropDownExample(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void LeafGroundPageDropDownTest() {
        //1.1)ways of select values in Basic dropdown
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class ='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");

        //1.2)Get the number of dropdown options
        List<WebElement> listOptions = select.getOptions();
        int listOptionSize = listOptions.size();
        System.out.println("Number of dropdown options: " + listOptionSize);
        for (WebElement element:listOptions) {
            System.out.println(element.getText());
        }

        //1.3)using sendkeys select dropdown value
        dropDown.sendKeys("Puppeteer");

        //1.4)select values in bootstrap dropdwon
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@ id ='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listofdropdown2values = driver.findElements(By.xpath("//ul[@ id ='j_idt87:country_items']/li"));
        for (WebElement element:listofdropdown2values) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")) {
                element.click();
                break;

            }

        }







    }

//2)Google search
    @Test
    public void GoogleSearchPageDropDownTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
       List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role = 'listbox']/li//div[@class='wM6W7d']"));
       System.out.println(googleSearchList.size());
       for (WebElement googleSearch:googleSearchList) {
           System.out.println(googleSearch.getText());

       }




    }

//3)Handle hidde  auto suggestions drop down and search using DOM Debugger Trick
}

