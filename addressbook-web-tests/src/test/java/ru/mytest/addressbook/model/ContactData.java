package ru.mytest.addressbook.model;

public class ContactData {
    private final String contactFirstName;
    private final String contactLastName;
    private final String contactNickName;
    private final String contactTitle;
    private final String contactCompany;
    private final String contactAddress;
    private final String contactMobile;
    private final String contactEmail;

    public ContactData(String contactFirstName, String contactLastName, String contactNickName, String contactTitle, String contactCompany, String contactAddress, String contactMobile, String contactEmail) {
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactNickName = contactNickName;
        this.contactTitle = contactTitle;
        this.contactCompany = contactCompany;
        this.contactAddress = contactAddress;
        this.contactMobile = contactMobile;
        this.contactEmail = contactEmail;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactNickName() {
        return contactNickName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public String getContactCompany() {
        return contactCompany;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}
