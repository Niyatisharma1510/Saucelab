package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    HomePage homepage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    RegisterResultPage registerResultPage = new RegisterResultPage();

    @Test(priority = 1)
    public void verifyUsershouldAbleToClickOnRegisterSuccessfully(){
        homepage.clickOnRegisterButton();
        registerPage.verifyUSerIsOnRegisterPage();
       }
       @Test(priority = 2)
    public void verifyUserAbleToEnterDetailOnRegisterPage(){
           homepage.clickOnRegisterButton();
           registerPage.verifyUSerIsOnRegisterPage();
           registerPage.enterRegistrationDetails();
           registerResultPage.verifyUserRegisteredSuccessfully();
    }



}
