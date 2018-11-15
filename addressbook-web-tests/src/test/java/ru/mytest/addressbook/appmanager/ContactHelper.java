package ru.mytest.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.mytest.addressbook.model.ContactData;
import ru.mytest.addressbook.model.Contacts;

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

  public void selectContactById(int id) {
    driver.findElement(By.xpath("//table[@id='maintable']//input[@value='" + id + "']")).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    app.goTo().homePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    app.acceptNextAlert = true;
    deleteSelectedContacts();
    closeDialogWindow();
    contactCache = null;
    app.goTo().homePage();
  }

  public void initContactModification(int index) {
    driver.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
  }

  private void initContactModificationById(int id) {
    driver.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
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
    contactCache = null;
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

  public int count() {
    return driver.findElements(By.xpath("//table[@id='maintable']//input[@name='selected[]']")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache); //return copy of contactCache
    }
    contactCache = new Contacts();
    List<WebElement> elements = driver.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> columns = element.findElements(By.cssSelector("td"));
      String lastName = columns.get(1).getText();
      String firstName = columns.get(2).getText();
      String address = columns.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address);
      contactCache.add(contact);
      System.out.println(id + ", " + firstName + ", " + lastName + ", " + address);
    }
    return new Contacts(contactCache);
  }
}
