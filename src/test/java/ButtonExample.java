import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }
    @Test
    public void TextBoxExample(){
        //click and confirm title

        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle ="Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title Match");
        }else{
            System.out.println("Title Not Match");
        }

        //Find the position of submit button
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xypoint = getPosition.getLocation();
        int x = xypoint.getX();
        int y = xypoint.getY();
        System.out.println("X Point : " + x + " Y Point : " + y);

        //find the save button colour
        WebElement buttonColour = driver.findElement(By.id("j_idt88:j_idt96"));
        String colour = buttonColour.getCssValue("background-color");
        System.out.println("colour : " + colour);

        //find the height and width of this button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height : " + height + " Width : " + width);


    }
}
