package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        homePage = new HomePage();
    }
    @Test (priority = 1)
    public void verifyAdminTitle() {
        String title = homePage.validateHomePageTitle();
        Assert.assertEquals(title,"React App");
    }
    @Test (timeOut = 10000,priority = 2)
    public void searchRole(){
        homePage.search("Planner");

    }
    @Test(timeOut = 5000,priority = 3)
    public void searchName(){
        homePage.search("Lê");
    }
    @Test (priority = 4)
    public void createRole() throws InterruptedException {
        homePage.createRole("Đặng Tấn Bắc","123456789","bac.dang@gmail.com");
    }

}

