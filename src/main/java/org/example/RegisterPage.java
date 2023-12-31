package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.BrowserManager.loadProp;

public class RegisterPage extends Utils{
    public static LoadProp loadProp = new LoadProp();
    public static final String name = loadProp.getProperty("name");
    public static final String password = loadProp.getProperty("password");
    private By _registerSubmitButton = By.id("register-button");
    private By _firstNameField = By.name("FirstName");
    private By _lastNameField = By.name("LastName");
    private By _email = By.name("Email");

    private By _passWord = By.name("Password");
    private By _confirmPassword = By.name("ConfirmPassword");


    public void verifyUSerIsOnRegisterPage(){
        //verify that user is on register page by this assertion
        Assert.assertTrue(driver.getCurrentUrl().contains("register"), "User is NOT on register page");
        System.out.println("user is on Register page ");
    }

    public void enterRegistrationDetails(){
        waitForClickable(_registerSubmitButton, 10);
        //Enter registration details
        typeText(_firstNameField, "FirstNameTest");
        typeText(_lastNameField,"LastNameTest");
        selectByText(By.name("DateOfBirthDay"), "21");
        selectByText(By.name("DateOfBirthMonth"), "May");
        selectByText(By.name("DateOfBirthYear"), "1987");
        filldetail();
    }
    public void filldetail() {
        typeText(_email,"test+"+timeStamp()+"@test.com");
        typeText(_passWord,"testtest1234");
        typeText(_confirmPassword,"testtest1234");
        clickOnElement(By.id("register-button"));
    }

}
