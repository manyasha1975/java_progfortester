package ru.mytest.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mytest.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Fedor11").withLastName("Sidorov").withNickName("Fedora11").withTitle("Tester11")
            .withAddress("Ekaterinburg11").withMobile("+79192347655").withEmail("fedor@gmail.com").withGroup("Group4");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
    }
}
