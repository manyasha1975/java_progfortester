package ru.mytest.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact") //set tag name
public class ContactData {
    @XStreamOmitField //miss this field
    private int id = Integer.MAX_VALUE;
    @Expose
    private String contactFirstName;
    @Expose
    private String contactLastName;
    @Expose
    private String contactNickName;
    private String contactTitle;
    @Expose
    private String contactCompany;
    @Expose
    private String contactAddress;
    private String contactHomePhone;
    @Expose
    private String contactMobilePhone;
    private String contactWorkPhone;
    private String allPhones;
    @Expose
    private String contactEmail;
    private String contactEmail2;
    private String contactEmail3;
    private String allEmails;
    @Expose
    private String group;
    private File photo;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return contactFirstName;
    }

    public String getLastName() {
        return contactLastName;
    }

    public String getNickName() {
        return contactNickName;
    }

    public String getTitle() {
        return contactTitle;
    }

    public String getCompany() {
        return contactCompany;
    }

    public String getAddress() {
        return contactAddress;
    }

    public String getHomePhone() {
        return contactHomePhone;
    }

    public String getMobilePhone() {
        return contactMobilePhone;
    }

    public String getWorkPhone() {
        return contactWorkPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail() {
        return contactEmail;
    }

    public String getEmail2() {
        return contactEmail2;
    }

    public String getEmail3() {
        return contactEmail3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getGroup() {
        return group;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
        return this;
    }

    public ContactData withLastName(String contactLastName) {
        this.contactLastName = contactLastName;
        return this;
    }

    public ContactData withNickName(String contactNickName) {
        this.contactNickName = contactNickName;
        return this;
    }

    public ContactData withTitle(String contactTitle) {
        this.contactTitle = contactTitle;
        return this;
    }

    public ContactData withCompany(String contactCompany) {
        this.contactCompany = contactCompany;
        return this;
    }

    public ContactData withAddress(String contactAddress) {
        this.contactAddress = contactAddress;
        return this;
    }

    public ContactData withHomePhone(String contactHomePhone) {
        this.contactHomePhone = contactHomePhone;
        return this;
    }

    public ContactData withMobilePhone(String contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String contactWorkPhone) {
        this.contactWorkPhone = contactWorkPhone;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        return this;
    }

    public ContactData withEmail2(String contactEmail2) {
        this.contactEmail2 = contactEmail2;
        return this;
    }

    public ContactData withEmail3(String contactEmail3) {
        this.contactEmail3 = contactEmail3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "contactFirstName='" + contactFirstName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(contactFirstName, that.contactFirstName) &&
                Objects.equals(contactLastName, that.contactLastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, contactFirstName, contactLastName);
    }

}
