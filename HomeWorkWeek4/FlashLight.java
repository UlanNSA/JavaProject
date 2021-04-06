package task4;

import java.util.ArrayList;

public class FlashLight {
    private ArrayList<Battery> batteries = new ArrayList<>();

    public FlashLight() {

    }

    public double getTotalPower() {
        double sum=0.0;
        for (Battery but:batteries) {
            sum+= but.getPower();
        }
        return sum;
    }

    public FlashLight(ArrayList<Battery> batteries ) {
        this.batteries = batteries;
    }



    public ArrayList<Battery> getBatteries() {
        return batteries;
    }

    public void setBatteries(ArrayList<Battery> batteries) {
        this.batteries = batteries;
    }

    public double getTotalEnergy(){
        double sum=0.0;
        for (Battery but:batteries) {
            sum+= but.getPower();
        }
        return sum;
    }
    public double getTotalLifeTime (){
        double sum=0.0;
        for (Battery but:batteries) {
            sum+= but.getPower();
        }
        return sum;
    }


}
