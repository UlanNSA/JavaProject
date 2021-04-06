package Def2;

import java.util.ArrayList;

public class Horse extends Thread {
    String name;
    int distance;
    int speed;
    double slowdown;
    public static final int timeToStorm = 5;
    public static ArrayList <String> RaceResult = new ArrayList<>();

    public Horse(String name, int distance, int speed, double slowdown) {
        this.name = name;
        this.distance = distance;
        this.speed = speed;
        this.slowdown = slowdown;
    }



    @Override
    public void run() {

        System.out.println(name + " went");
        int temp = 0;

        int i = 1;

        while (!isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i < timeToStorm) {
                temp += speed;
                System.out.println(name + " is in " + i + " second " + temp + " meters");
                i++;
            }
            if (i >= timeToStorm) {
                temp += speed -(speed*(1-slowdown)) ;
                if(temp>=3000){
                    System.out.println(name + " is in " + i + " second 3000 meters");
                    i++;
                }
                else{
                System.out.println(name + " is in " + i + " second " + temp + " meters");
                i++;}

            }

            if (temp > distance) {
                RaceResult.add(name);
                System.out.println(name + " finished race");
                interrupt();
            }
        }
    }

    public static void RR(){
            int j=0;
            for (String r:RaceResult) {
                j++;
                System.out.println(j+" "+r);
            }
    }

}

