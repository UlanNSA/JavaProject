package task4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Engine[] car = new Engine[]{
                new FerrariEngine(6.0, 12, 350),
                new FerrariEngine(7.0, 14, 200),
                new FerrariEngine(5.0, 10, 370),
                new FerrariEngine(7.0, 16, 380),
                new FerrariEngine(9.0, 20, 400),
                new RenaultEnigine(1.6, 4, 200, 2.5),
                new RenaultEnigine(2.6, 6, 120, 4.5),
                new RenaultEnigine(2.9, 8, 145, 1.5),
                new RenaultEnigine(1.8, 4, 100, 1.8),
                new RenaultEnigine(2.0, 10, 198, 2.0)
        };

        for (Engine e:car) {
            System.out.println(e.getMaxSpeed());
            
        }
        System.out.println("50-69%");

        Battery toshibaBattery = new ToshibaBattery(1.5, 1, 100, 40);
        Battery toshibaBattery1 = new ToshibaBattery(1, 2, 200, 50);
        Battery toshibaBattery2 = new ToshibaBattery(2, 3, 300, 30);
        Battery toshibaBattery3 = new ToshibaBattery(3, 5, 400, 10);
        Battery toshibaBattery4 = new ToshibaBattery(2.5, 10, 500, 20);
        Battery duracellBattery = new DuracellBattery(5, 2, 300, 4);
        Battery duracellBattery1 = new DuracellBattery(3, 5, 400, 4);
        Battery duracellBattery2 = new DuracellBattery(2, 5, 100, 4);
        Battery duracellBattery3 = new DuracellBattery(1, 8, 240, 4);
        Battery duracellBattery4 = new DuracellBattery(6, 1, 430, 4);
        ArrayList<Battery> batteries = new ArrayList<>();
        ArrayList<Battery> batteries1 = new ArrayList<>();
        ArrayList<Battery> batteries2 = new ArrayList<>();
        ArrayList<Battery> batteries3 = new ArrayList<>();
        ArrayList<Battery> batteries4 = new ArrayList<>();

        batteries.add(toshibaBattery);
        batteries.add(duracellBattery);

        batteries1.add(toshibaBattery1);
        batteries1.add(duracellBattery1);

        batteries2.add(toshibaBattery2);
        batteries2.add(duracellBattery2);

        batteries3.add(toshibaBattery3);
        batteries3.add(duracellBattery3);

        batteries4.add(toshibaBattery4);
        batteries4.add(duracellBattery4);
        FlashLight flashLight = new FlashLight(batteries);
        FlashLight flashLight1 = new FlashLight(batteries1);
        FlashLight flashLight2 = new FlashLight(batteries2);
        FlashLight flashLight3 = new FlashLight(batteries3);
        FlashLight flashLight4 = new FlashLight(batteries4);
        ArrayList<FlashLight>flashLights = new ArrayList<>();
        flashLights.add(flashLight);
        flashLights.add(flashLight1);
        flashLights.add(flashLight2);
        flashLights.add(flashLight3);
        flashLights.add(flashLight4);
        FlashLight temp = new FlashLight();
        double max = Double.MIN_VALUE;
        for(FlashLight flashLight5: flashLights){
            System.out.println(flashLight5.getTotalLifeTime());
            if(max<=flashLight5.getTotalLifeTime()){
                temp =flashLight5;
                max = flashLight5.getTotalLifeTime();
            }
        }
        System.out.println("Data of flashlight with maximum lifetime value");
        System.out.println("Total energy: "+ temp.getTotalEnergy());
        System.out.println("Total power: " + temp.getTotalPower());
        System.out.println("Total LifeTime: " +temp.getTotalLifeTime());


        System.out.println("70-89%");


        User user = new Student(1, "ULAN25","qwerty","Ulan","Yerikov","ITNSA-1901",3.5);
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("Physics");
        User user1 = new Teacher(2, "QR","001","Rama","Vahter",subjects);
        System.out.println(user.getUserData());
        System.out.println(user1.getUserData());

        System.out.println("90-100%");
        Contact[] contacts = new Contact[]{
                new IPhoneContact(1,"Camden","Brewer", "+1-410-555-0156","+1-410-555-0151","+1-410-555-0138"),
                new IPhoneContact(2,"Nieve","Hewitt", "+1-410-555-0146","+1-410-555-0114","+1-410-555-0148"),
                new IPhoneContact(3,"Keagan","Boyd", "+1-501-555-0101","+1-501-555-0110","+1-501-555-0177"),
                new IPhoneContact(4,"Lennie","Weston", "+1-501-555-0125","+1-501-555-0137","+1-501-555-0120"),
                new IPhoneContact(5,"Hugh","Gardner", "+1-775-555-0110","+1-775-555-0179","+1-775-555-0147")
        };
        String[] cont = new String[]{"+1-202-555-0145","+1-202-555-0136"};
        String[] cont1 = new String[]{"+1-202-555-0113","+1-202-555-0119"};
        String[] cont2 = new String[]{"+1-202-555-0170","+1-202-555-0117"};
        String[] cont3 = new String[]{"+1-202-555-0170","+1-518-555-0156"};

        Contact[] contacts1 = new Contact[]{
                new SamsungContact(1,"Tamzin Kent",cont),
                new SamsungContact(2,"Lucie Lancaster", cont1),
                new SamsungContact(3,"Romana Goodwin", cont2),
                new SamsungContact(4,"Marjorie Wharton", cont3),
                new SamsungContact(5,"Gabrielle Harwood", cont1),
        };

        SamsungApplication samsungApplication = new SamsungApplication("Samsung phones",contacts1,contacts1.length);
        IPhoneApplication iPhoneApplication = new IPhoneApplication("Iphone phones", contacts,contacts.length);


        samsungApplication.printContacts();
        iPhoneApplication.printContacts();
    }


}
