package ru.mytest.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.mytest.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static  void main(String[] args) throws IOException {
    //we get two parameters - count of group and file path to which data to generate
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator); //jcommander is library for work with command line
    try {
      jCommander.parse(args); // to get some args from command line and try to parse
    } catch (ParameterException ex) {
      jCommander.usage(); //if parameters are incorrect, jcommander sends how to use this GroupDataGenerator program
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")){
      saveAsJson(contacts, new File(file));
    } else
      System.out.println("Unrecognized format " + format);
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    //Gson gson = new Gson(); //create gson, but it will have not very good format, not convenient for reading
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    //GsonBuilder will create gson in good format
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file); //open file to write
    writer.write(json);
    writer.close();
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class); //read annotations in ContactData.class
    String xml = xStream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);  //open file to write
    for (ContactData contact : contacts) {  //to write in CSV format (comma-separated-values)
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getNickName()
              , contact.getCompany(), contact.getAddress(), contact.getMobilePhone(), contact.getEmail()));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("Fedor %s", i)).withLastName(String.format("Petrov %s", i))
              .withNickName(String.format("Fedora %s", i)).withCompany(String.format("Company %s", i)).withAddress(String.format("City %s", i))
              .withMobilePhone(String.format("+7912123456%s", i)).withEmail(String.format("email%s@mail.com", i)));
    }
    return contacts;
  }
}
