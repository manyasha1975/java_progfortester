package ru.mytest.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;
import ru.mytest.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Fedor").withLastName("Ivanov").withNickName("Vanilla").withTitle("Dev")
              .withAddress("Ekaterinburg").withHomePhone("+7 919-234-76-45").withMobilePhone("+79192347641")
              .withWorkPhone("+7 919 234 76 45").withEmail("fedor@gmail.com").withGroup("Group5"), true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next(); //contact is chosen by random method
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Fedor_2").withLastName("Petrov").withNickName("Fedora_mod").withTitle("Tester_mod").
            withCompany("Test company_mod").withAddress("Ekaterinburg_mod").withMobilePhone("+79192347685").withEmail("fedor_mod@gmail.com");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
