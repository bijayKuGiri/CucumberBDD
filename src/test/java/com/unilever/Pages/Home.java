package com.unilever.Pages;

import Base.BaseUtilities;
import Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Home extends BaseUtilities {

    private RemoteWebDriver _driver;
    private BaseUtilities base;

    public Home(RemoteWebDriver driver) {
        _driver=driver;
    }

    public void NavigateToProd(){
        _driver.navigate().to("https://www.magnumicecream.com/br/home.html");
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        _driver.manage().timeouts().pageLoadTimeout  (40, TimeUnit.SECONDS);
    }

    public void NavigateToUAT(){
        _driver.navigate().to("https://magnumicecream-com-uat-aemcs.unileversolutions.com/br/home.html");
        _driver.navigate().to("https://unileveraemcs:Un1l2v2r@A3mcs@magnumicecream-com-uat-aemcs.unileversolutions.com/br/home.html");
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        _driver.manage().timeouts().pageLoadTimeout  (40, TimeUnit.SECONDS);
    }

    public List<String> getLinktext(){
        List<String> linkTxt=new ArrayList<String>();
        List<WebElement> links=_driver.findElement(By.xpath("//header")).findElements(By.tagName("li"));
        for (WebElement var : links)
        {
            System.out.println(var.getText() );//+" "+url);
            linkTxt.add(var.getText());
        }
        return linkTxt;
    }

    public void quit(){
        _driver.close();
       _driver.quit();
    }

    public void Initialize(){
        _driver=new ChromeDriver();
        _driver.manage().window().maximize();
    }


}
