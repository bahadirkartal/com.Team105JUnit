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

public class C03_sahibindenTesti {


    WebDriver driver;


        @Before
        public  void beforeTesting () {

            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }

        @After
    public  void afterTesting () throws InterruptedException {
            Thread.sleep(5000);

            driver.close();

        }



        @Test
        public  void sahibindencomTest1 (){

            // https://www.sahibinden.com adresine gidin
            driver.get("https://www.sahibinden.com");

            // çerezleri reddet butonuna tıklayın.
            driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();

            // arama kutusuna ford mustang yazın ve enter a basın.
            driver.findElement(By.xpath("//input[@id='searchText']")).sendKeys("ford mustang"+ Keys.ENTER);


            // çıkan ilk sonucun fiyatını yazdırın.

            WebElement ilkurunfiyati = driver.findElement(By.xpath("(//div[@class='classified-price-container'])[1]"));
            System.out.println("ilk ürün fiyatı: "+ilkurunfiyati.getText());



            // ilk sonucun ilan tarihinin görünür olup olmadığını test edin.


            WebElement ilanTarihi = driver.findElement(By.xpath("(//td[@class='searchResultsDateValue'])[1]"));
            if (ilanTarihi.isDisplayed()){
                System.out.println("Test PASSED");


            }






            //








        }




}
