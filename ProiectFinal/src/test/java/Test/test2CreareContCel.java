package Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class test2CreareContCel {


    public WebDriver driver;

    @Test
    public void TestAutomat2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edyto\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.cel.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        String ExpectedPageTitle = "CEL.ro - Cel mai Cel, online din 2004";
        String ActualPageTitle = driver.getTitle();
        Assert.assertEquals("Pagina register nu are titlu corect", ExpectedPageTitle, ActualPageTitle);
        System.out.println(ActualPageTitle);

        WebElement SwitchToMenu = driver.findElement(By.xpath("//a[@class='iconUser']"));
        Actions Action = new Actions(driver);
        Action.moveToElement(SwitchToMenu).perform();

        WebElement Create = driver.findElement(By.xpath("//div[@class='myAccountMenu']/a[2]"));
        Create.click();

        String ActualPageTitle2=driver.getTitle();
        System.out.println(ActualPageTitle2);

        WebElement SuntClientNou=driver.findElement(By.xpath("//body/div[@id='mainWrapper']/div/div[@id='bodycode3']/div[@id='bodycode']/div/div/div[1]/div[2]"));
        SuntClientNou.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(300,0)", "");

        WebElement Nume=driver.findElement(By.xpath("//input[@id='firstname']"));
        Nume.sendKeys("Tofan");
        WebElement Prenume=driver.findElement(By.xpath("//input[@id='lastname']"));
        Prenume.sendKeys("Eduard");
        WebElement Email=driver.findElement(By.xpath("//tbody//tr//td//div//div//div//div//div//input[@id='email_address']"));
        Email.sendKeys("edytofan33@gmail.com");

        WebElement GenulWeb=driver.findElement(By.xpath("//select[@id='customers_gender']"));
        String GenValue="Doamna";
        Select GenSelect=new Select(GenulWeb);
        GenSelect.selectByVisibleText(GenValue);

        WebElement Telefon=driver.findElement(By.xpath("//input[@id='telephone']"));
        Telefon.sendKeys("0787720837");

        WebElement Adresa=driver.findElement(By.xpath("//textarea[@id='street_address']"));
        Adresa.sendKeys("Erich Bergel 32");

        WebElement LocalitateaWeb=driver.findElement(By.xpath("//select[@id='entry_suburb']"));
        String LocalitateaValue="Cluj";
        Select LocalitateaSelect=new Select(LocalitateaWeb);
        LocalitateaSelect.selectByVisibleText(LocalitateaValue);

        WebElement Checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        Checkbox.click();
        JavascriptExecutor jos = (JavascriptExecutor) driver;
        jos.executeScript("window.scrollBy(0,300)", "");

        //WebElement Submit=driver.findElement(By.xpath("//button[@onclick='if(checkall()) return false;']"));
        //Submit.click();
        //String ActualPageTitle1=driver.getTitle();
        //System.out.println(ActualPageTitle1);
    }
}
