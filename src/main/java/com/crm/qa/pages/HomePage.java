package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HomePage extends TestBase {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input")
    WebElement inputSearch;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/button")
    WebElement createRoleBtn;

    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;

    @FindBy(name = "role")
    WebElement role;

    @FindBy(name = "email")
    WebElement email;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/div/button")
    WebElement creatBtn;
    public HomePage (){
        PageFactory.initElements(driver,this);
    }
    public String validateHomePageTitle(){
        return driver.getTitle();
    }

    public void search(String textSearch){
        inputSearch.sendKeys(textSearch);
        inputSearch.clear();
    }

    public  void createRole(String user,String pass,String ema) throws InterruptedException {
        createRoleBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select select = new Select(role);
        select.selectByValue("Planner");
        username.sendKeys(user);
        password.sendKeys(pass);
        email.sendKeys(ema);
        creatBtn.click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }


}
