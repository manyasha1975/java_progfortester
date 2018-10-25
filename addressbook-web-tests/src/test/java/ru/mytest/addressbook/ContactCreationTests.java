package ru.mytest.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoNewContact();
    fillContactForm(new ContactData("Fedor", "Petrov", "Fedora", "Tester", "Test company", "Ekaterinburg", "+79192347658", "fedor@gmail.com"));
    submitContactCreation();
    gotoHomePage();
  }

}
