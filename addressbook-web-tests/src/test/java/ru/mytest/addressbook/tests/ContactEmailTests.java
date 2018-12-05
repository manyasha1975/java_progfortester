package ru.mytest.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactEmailTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Fedor").withLastName("Ivanov").withNickName("Vanilla").withTitle("Dev")
              .withCompany("My company").withAddress("Ekaterinburg").withHomePhone("+7 919-234-76-45").withMobilePhone("+79192347641")
              .withWorkPhone("8 (911) 123 45 67").withEmail("fedor@gmail.com").withEmail2("fedor2@gmail.com")
              .withEmail3("fedor3@gmail.com").withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactEmails() {
    ContactData contact = app.contact().all().iterator().next(); //contact is chosen by random method
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    MatcherAssert.assertThat(contact.getAllEmails(), CoreMatchers.equalTo(app.contact().mergeEmails(contactInfoFromEditForm)));
  }

}
