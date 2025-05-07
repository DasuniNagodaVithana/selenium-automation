import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Radio_Checkbox {
    WebDriver driver;

    @BeforeMethod
    public void RadioCheckboxBeforeMethod() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void LeafGroundPageRadioButtonTest() {
        //Find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeradioOption  = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxradioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption  = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption    = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeradioOption) {
          String chromeText   = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
          System.out.println("Default select radio button is " + chromeText);
        }else if (firefoxradioOption) {
            String firefoxText   = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default select radio button is " + firefoxText);
        }else if (safariradioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default select radio button is " + safariText);
        }else if (edgeradioOption) {
            String edgeText   = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default select radio button is " + edgeText);

        }
        // Select the age group (only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked= myAgeGroup.isSelected();
        if (!isChecked){
            //myAgeGroup.click();
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }



    }

    @Test
    public void LeafGroundPageCheckboxTest() {

    }
}
