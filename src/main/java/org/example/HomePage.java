package org.example;

import org.openqa.selenium.By;

public class HomePage extends Utils {
    public void clickOnRegisterButton() {
        //Click on Register link on homepage
        clickOnElement(By.linkText("Register"));
    }


}
