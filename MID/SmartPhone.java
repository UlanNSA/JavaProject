package MID;

public class SmartPhone  extends Device{
    protected double mgpx;
    protected int generation;

    public SmartPhone(double mgpx, int generation) {
        this.mgpx = mgpx;
        this.generation = generation;
    }

    public SmartPhone(String cpu, int ram, double mgpx, int generation) {
        super(cpu, ram);
        this.mgpx = mgpx;
        this.generation = generation;
    }

    public SmartPhone(int price, String model, int count, String cpu, int ram, double mgpx, int generation) {
        super(price, model, count, cpu, ram);
        this.mgpx = mgpx;
        this.generation = generation;
    }

    @Override
    double getPerformance() {
        return basePerformance()+generation*mgpx;

    }


    @Override
    void showDetails() {
        System.out.println("id = "+ getId() + " price = " + getPrice() + " model = " + getModel() +
                " cpu = " + getCpu() + " ram = " + getRam() + " mgpx = " + getMgpx()+
                " generation = " + getGeneration());
    }


    public double getMgpx() {
        return mgpx;
    }


public String getType(){
        return "SmartPhone";
}
    public void setMgpx(double mgpx) {
        this.mgpx = mgpx;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}

