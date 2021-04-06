package task4;

import java.util.Arrays;

public class SamsungApplication implements PhoneApplication{
    private String name;
    private Contact allContacts[] = new Contact[500];
    private int contactSize = 0;

    public SamsungApplication() {
    }

    public SamsungApplication(String name, Contact[] allContacts, int contactSize) {
        this.name = name;
        this.allContacts = allContacts;
        this.contactSize = contactSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact[] getAllContacts() {
        return allContacts;
    }

    public void setAllContacts(Contact[] allContacts) {
        this.allContacts = allContacts;
    }

    public int getContactSize() {
        return contactSize;
    }

    public void setContactSize(int contactSize) {
        this.contactSize = contactSize;
    }

    @Override
    public void addContact(Contact c) {
        for(Contact contact:allContacts){
            printContacts();
        }
    }

    @Override
    public void printContacts() {
        for(Contact contact:allContacts){
            contact.printContactData();
        }
    }


}
