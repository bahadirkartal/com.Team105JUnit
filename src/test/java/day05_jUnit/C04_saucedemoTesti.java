package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_saucedemoTesti {

    /*
        1. “https://www.saucedemo.com” Adresine gidin

        2. Username kutusuna “standard_user” yazdirin

        3. Password kutusuna “secret_sauce” yazdirin
        4. Login tusuna basin

        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        6. Add to Cart butonuna basin

        7. Alisveris sepetine tiklayin

        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

        9. Sayfayi kapatin

     */

    WebDriver driver;

    @Before
    public void beforeTesting (){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }
    @After
    public void afterTesting () throws InterruptedException {

        Thread.sleep(3000);

        driver.close();
    }

    @Test
    public void test1 (){

       //1. “https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");

       //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user"+ Keys.ENTER);

       //3. Password kutusuna “secret_sauce” yazdirin

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce"+Keys.ENTER);

       //4. Login tusuna basin

        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

       //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement ilkUrunIsmi = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));

        ilkUrunIsmi.click();

       //6. Add to Cart butonuna basin

       driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();

       //7. Alisveris sepetine tiklayin

        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

       //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

       WebElement sepet= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
       if (sepet.isDisplayed()){
           System.out.println("Ürün sepete eklendi");
       }else {
           System.out.println("Ürün sepete eklenemedi");
       }





    }

























}
