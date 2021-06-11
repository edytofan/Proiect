package Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class test3Comparare {

    public WebDriver driver;

    @Test
    public void TestAutomat3() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edyto\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.cel.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        String ExpectedPageTitle = "CEL.ro - Cel mai Cel, online din 2004";
        String ActualPageTitle = driver.getTitle();
        Assert.assertEquals("Pagina register nu are titlu corect", ExpectedPageTitle, ActualPageTitle);
        System.out.println(ActualPageTitle);

        WebElement TelefoaneMobile=driver.findElement(By.xpath("//a[normalize-space()='Telefoane Mobile & Gadget']"));
        TelefoaneMobile.click();

        WebElement TelefoaneMobileSelect=driver.findElement(By.xpath("//body//div[@id='mainWrapper']//div[@id='bodycode']//div//div//a[1]"));
        TelefoaneMobileSelect.click();

        WebElement Telefon1=driver.findElement(By.xpath("//div[@id='bodycode3']//div[1]//div[2]//div[1]//div[1]//div[1]//a[1]"));
        Telefon1.click();
        WebElement Compara1=driver.findElement(By.xpath("//a[@id='p2733835']"));
        Compara1.click();
        driver.navigate().back();

        WebElement Telefon2=driver.findElement(By.xpath("//div[@id='bodycode3']//div[1]//div[2]//div[2]//div[1]//div[1]//a[1]"));
        Telefon2.click();
        WebElement Compara2=driver.findElement(By.xpath("//a[@id='p398469']"));
        Compara2.click();

        WebElement ComparaTot=driver.findElement(By.xpath("//a[@id='retinute']"));
        ComparaTot.click();

        driver.switchTo().defaultContent();

        WebElement Checkbox=driver.findElement(By.xpath("//input[@id='select_all_TelefoaneMobile']"));
        Checkbox.click();
        WebElement ComparaProduse=driver.findElement(By.xpath("//div[@id='meniu_c']//button[1]//span[1]"));
        ComparaProduse.click();

        WebElement Informatii=driver.findElement(By.xpath("//body/div[@id='mainWrapper']/div/div[@id='bodycode3']/div[@id='bodycode']/div/div/div[1]"));
        System.out.println(Informatii);

    }
}
