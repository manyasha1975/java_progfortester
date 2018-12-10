package ru.mytest.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactsInGroup extends ForwardingSet<ContactInGroupData> {

  private Set<ContactInGroupData> delegate;

  public ContactsInGroup (ContactsInGroup contactsInGroup) {
    this.delegate = new HashSet<ContactInGroupData>(contactsInGroup.delegate);
  }

  public ContactsInGroup (int id) {
    this.delegate = new HashSet<ContactInGroupData>(id);
  }

  public ContactsInGroup() {
    this.delegate = new HashSet<ContactInGroupData>();
  }

  public ContactsInGroup(List<ContactInGroupData> result) {
    this.delegate = new HashSet<ContactInGroupData>();
  }

  @Override
  protected Set<ContactInGroupData> delegate() {
    return delegate;
  }

  public ContactsInGroup withContact(ContactInGroupData contact) {
    ContactsInGroup contactsInAGroup = new ContactsInGroup(this);
    contactsInAGroup.add(contact);
    return contactsInAGroup;
  }
}
