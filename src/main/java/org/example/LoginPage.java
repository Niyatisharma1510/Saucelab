package org.example;

import org.openqa.selenium.By;

public class LoginPage extends Utils{
    public void enterLoginDetails(){
        typeText(By.xpath("//input[@type=\"email\"]"),email);
        typeText(By.xpath("//input[@type=\"password\"]"), loadProp.getProperty("password"));
        clickOnElement(By.xpath("//input[@type=\"submit\"]"));
    }
}
