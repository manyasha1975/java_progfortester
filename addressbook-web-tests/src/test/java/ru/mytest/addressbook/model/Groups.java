package ru.mytest.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

  private Set<GroupData> delegate;  //object, to which delegate these methods

  public Groups(Groups groups) {  //to take set with groups
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }

  public Groups(Collection<GroupData> groups) {
    this.delegate = new HashSet<GroupData>(groups);
  }

  @Override
  protected Set<GroupData> delegate() {  //method "delegate" return ths object 'delegate'
    return delegate;
  }

  public Groups withAdded(GroupData group) {
    Groups groups = new Groups(this); //create copy of object
    groups.add(group);
    return groups;
  }

  public Groups without(GroupData group) {
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }

  public GroupData findGroupForContact(ContactData contact, Groups groups) {
    Groups groupsWithoutCurrentContact = new Groups();
    for (GroupData group: groups) {
      if (!group.getContacts().contains(contact)) {
        groupsWithoutCurrentContact.add(new GroupData().withId(group.getGrid())
                .withName(group.getGrname()).withHeader(group.getGrheader())
                .withFooter(group.getGrfooter()));
      }
    }
    return groupsWithoutCurrentContact.iterator().next();
  }

}
