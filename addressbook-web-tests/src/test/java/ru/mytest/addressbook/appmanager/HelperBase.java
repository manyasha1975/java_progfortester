package ru.mytest.addressbook.appmanager;

import org.openqa.selenium.*;

public class HelperBase {

  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void type(By locator, String text) {
    driver.findElement(locator).click();
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  protected void click(By locator) {
    driver.findElement(locator).click();
  }

  protected void submit(By locator) {
    driver.findElement(locator).submit();
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public String closeAlertAndGetItsText(ApplicationManager applicationManager) {
    try {
      Alert alert = applicationManager.driver.switchTo().alert();
      String alertText = alert.getText();
      if (applicationManager.acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      applicationManager.acceptNextAlert = true;
    }
  }
}
