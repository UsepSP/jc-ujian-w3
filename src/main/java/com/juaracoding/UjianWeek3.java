package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UjianWeek3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://juice-shop.herokuapp.com/#/");

        //Click modal = Dismiss
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]/span[1]/span")).click();
        System.out.println("Dismiss");

        //Tutup iklan
        driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();
        System.out.println("Clos iklan");

        //Login
        driver.findElement(By.id("navbarAccount")).click();
        driver.findElement(By.id("navbarLoginButton")).click();
        System.out.println("To Login");

        //login= email & password
        driver.findElement(By.name("email")).sendKeys("usep.sph@gmail.com");
        driver.findElement(By.name("password")).sendKeys("testselenium");
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]")).click();
        System.out.println("Login");

        //if
        delay(1);
        String login =  driver.getCurrentUrl();
        if (login.equals("https://juice-shop.herokuapp.com/#/search")){
            System.out.println("Passes");
        } else {
            System.out.println("Failed");
        }

        //Add product
        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[8]/div/mat-card/div[2]/button/span[1]/span")).click();
        System.out.println("Product ditambahkan");

        //Checkout
        delay(2);
        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]/span[1]/span[1]")).click();
        delay(2);
        driver.findElement(By.id("checkoutButton")).click();
        System.out.println("Checkout Selesai");

        //Delay
        delay(10);
        driver.quit();
        System.out.println("Quit Browser");

    }


    static void delay (long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}