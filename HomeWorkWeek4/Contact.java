package task4;

public abstract class Contact {
    abstract public String getPersonalData();
    abstract public  String getPhone();
    void printContactData(){
        System.out.println(getPersonalData());
        System.out.println(getPhone());
    }


}
