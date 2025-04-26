import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }
    @Test
    public void TextBoxExample(){
        //Type your Name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Dasuni Nethmini");

        //Append Country to the city
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("Sri Lanka");

        //verify if the text box is disabled
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box enabled : "+ enabled);

        //clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //Retrieve the typed text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        //Type email and Tab.Confirm control moved to next element
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("dasuninagodavithana@gmail.com"+ Keys.TAB +"Confirm control moved to next element");





    }
}
