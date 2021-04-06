package Def2;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Horse> corral = new ArrayList<>();
        int dis = 3000;
        corral.add(new Horse("Trojan horse",dis,250,0.7));
        corral.add(new Horse("Pegasus",dis,400,0.8));
        corral.add(new Horse("Bucephalus",dis,175,0.8));
        corral.add(new Horse("Unicorn",dis,300,0.3));
        corral.add(new Horse("Absinthe",dis,375,0.5));

        for (Horse h:corral) {
                h.start();
        }
        for (Horse h:corral) {
            h.join();
        }

        System.out.println("Winners scoreboard:");
        Horse.RR();
}

}
