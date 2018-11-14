package ru.mytest.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.mytest.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {

  public ContactHelper(ApplicationManager app) {
    super(app);
  }

  public void submitContactCreation() {
    click(By.xpath("//input[@value='Enter']"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getContactFirstName());
    type(By.name("lastname"), contactData.getContactLastName());
    type(By.name("nickname"), contactData.getContactNickName());
    type(By.name("title"), contactData.getContactTitle());
    type(By.name("company"), contactData.getContactCompany());
    type(By.name("address"), contactData.getContactAddress());
    type(By.name("mobile"), contactData.getContactMobile());
    type(By.name("email"), contactData.getContactEmail());
    if (creation) {
      if (isThereAGroupInList(contactData)) {
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("[none]");
        /*app.group().create(new GroupData(contactData.getGroup(), null, null));
        create(contactData, creation);*/
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void gotoNewContact() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    driver.findElements(By.xpath("//table[@id='maintable']//input[@name='selected[]']")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void modify(int index, ContactData contact) {
    initContactModification(index);
    fillContactForm(contact, false);
    submitContactModification();
    app.goTo().homePage();
  }

  public void delete(int index) {
    selectContact(index);
    app.acceptNextAlert = true;
    deleteSelectedContacts();
    closeDialogWindow();
    app.goTo().homePage();
  }

  public void initContactModification(int index) {
    driver.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void closeDialogWindow() {
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    driver.findElement(By.cssSelector("div.msgbox"));
  }

  public void create(ContactData contactData, boolean creation) {
    gotoNewContact();
    fillContactForm(contactData, creation);
    submitContactCreation();
    app.goTo().homePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public boolean isThereAGroupInList(ContactData contactData) {
    try {
      new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public int getContactCount() {
    return driver.findElements(By.xpath("//table[@id='maintable']//input[@name='selected[]']")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = driver.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> columns = element.findElements(By.cssSelector("td"));
      String lastName = columns.get(1).getText();
      String firstName = columns.get(2).getText();
      String address = columns.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstName, lastName, null, null, null, address, null, null, null);
      contacts.add(contact);
      System.out.println(firstName);
      System.out.println(lastName);
      System.out.println(address);
      }
      return contacts;
    }
  }
