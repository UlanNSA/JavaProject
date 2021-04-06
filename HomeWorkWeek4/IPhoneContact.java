package task4;

public class IPhoneContact extends Contact {
    private int id;
    private String name;
    private String surname;
    private String firstPhone;
    private String secondPhone;
    private String thirdPhone;

    public IPhoneContact(int id, String name, String surname, String firstPhone, String secondPhone, String thirdPhone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.firstPhone = firstPhone;
        this.secondPhone = secondPhone;
        this.thirdPhone = thirdPhone;
    }

    public IPhoneContact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstPhone() {
        return firstPhone;
    }

    public void setFirstPhone(String firstPhone) {
        this.firstPhone = firstPhone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    public String getThirdPhone() {
        return thirdPhone;
    }

    public void setThirdPhone(String thirdPhone) {
        this.thirdPhone = thirdPhone;
    }

    @Override
    public String getPersonalData() {
        return "Id : "+getId()+"\n"+
                "Name : "+getName()+"\n"+
                "Surname : "+getSurname();
    }

    @Override
    public String getPhone() {
        return "First Phone : "+getFirstPhone()+"\n"+
                "Second Phone : "+getSecondPhone()+"\n"+
                "Third Phone : "+getThirdPhone()+"\n";
    }
}
