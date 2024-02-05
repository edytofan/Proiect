package Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test1CumparareProdus {

    public WebDriver driver;
    private List<WebElement> Submit;

    @Test
    public void TestAutomat1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edyto\\Desktop\\driver");
        driver = new ChromeDriver();
        driver.get("https://www.cel.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        String ExpectedPageTitle="CEL.ro - Cel mai Cel, online din 2004";
        String ActualPageTitle=driver.getTitle();
        Assert.assertEquals("Pagina register nu are titlu corect",ExpectedPageTitle,ActualPageTitle);
        System.out.println(ActualPageTitle);


        WebElement SwitchToMenu=driver.findElement(By.xpath("//a[@class='iconUser']"));
        Actions Action=new Actions(driver);
        Action.moveToElement(SwitchToMenu).perform();

        WebElement Login=driver.findElement(By.xpath("//div[@class='myAccountMenu']/a"));
        Login.click();

        String ActualPageTitle1=driver.getTitle();
        System.out.println(ActualPageTitle1);

        WebElement Email=driver.findElement(By.xpath("//input[@id='email_address']"));
        Email.sendKeys("edytofan3333@gmail.com");
        WebElement Password=driver.findElement(By.xpath("//input[@type='password']"));
        Password.sendKeys("Scorpion01");
        WebElement Submit=driver.findElement(By.xpath("//div[@id='logintable']//button[@type='submit']"));
        Submit.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        String ActualPageTitle2=driver.getTitle();
        System.out.println(ActualPageTitle2);

        WebElement Produs=driver.findElement(By.xpath("//img[@alt=\"Monitoare LCD LED Monitor LED IPS Huawei 23.8'', Full HD, 60Hz, 5ms, HDMI, VGA, AD80\"]"));
        Produs.click();

        WebElement AdaugaInCos=driver.findElement(By.xpath("//button[@class='btn btn-special btn_add_to_cart']"));
        AdaugaInCos.click();
        String ActualPageTitle3=driver.getTitle();
        System.out.println(ActualPageTitle3);
    }
}




