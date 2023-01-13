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

public class C05_tekrarTesti {

    WebDriver driver;

    @Before
    public void beforeTesting (){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void afterTesting () throws InterruptedException {

        Thread.sleep(3000);

        driver.close();


    }


    @Test
    public void test1 (){

        //1- C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin.


        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedKelime = "Google";
        String actualKelime = driver.getTitle();

        if (actualKelime.contains(expectedKelime)){
            System.out.println("Başlık testi PASSED");
        }else {
            System.out.println("Başlık testi FAILED");
        }

        //5- Arama cubuguna “Nutella” yazip aratin

        driver.findElement(By.xpath("//input[@jsaction='paste:puy29d;']")).sendKeys("Nutella"+ Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin

        WebElement nutellaSonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(nutellaSonucSayisi.getText());

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin






        //8- Sayfayi kapatin



    }














}
