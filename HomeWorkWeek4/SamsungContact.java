package task4;

import java.util.Arrays;

public class SamsungContact extends Contact {
    private int id;
    private String fullName;
    private String phones[] = new String[10];

    public SamsungContact(int id, String fullName, String[] phones) {
        this.id = id;
        this.fullName = fullName;
        this.phones = phones;
    }

    public SamsungContact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    @Override
    public String getPersonalData() {
        return "Id : "+getId()+"\n"+
                "Full name : "+getFullName();
    }

    @Override
    public String getPhone() {
        return Arrays.toString(getPhones()) +"\n";
    }
}
