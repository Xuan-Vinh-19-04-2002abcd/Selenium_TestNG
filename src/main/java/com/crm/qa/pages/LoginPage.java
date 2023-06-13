package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import jdk.jfr.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends TestBase {
    //Page Factory - OR:
    @FindBy(id = "user-type")
    WebElement role;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"root\"]/div/form/div[4]/button")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"ui\"]/div/div/div[2]/a")
    WebElement signupBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public HomePage login(String em ,String pwd){
        Select select = new Select(role);
        select.selectByValue("Admin");
        email.sendKeys(em);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage();
    }
}
