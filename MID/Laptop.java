package MID;

public class Laptop  extends Computer{
    protected double weight;
    protected boolean touch;

    public Laptop(boolean ssd, int memory, double weight, boolean touch) {
        super(ssd, memory);
        this.weight = weight;
        this.touch = touch;
    }

    public Laptop(String cpu, int ram, boolean ssd, int memory, double weight, boolean touch) {
        super(cpu, ram, ssd, memory);
        this.weight = weight;
        this.touch = touch;
    }

    public Laptop(int price, String model, int count, String cpu, int ram, boolean ssd, int memory, double weight, boolean touch) {
        super(price, model, count, cpu, ram, ssd, memory);
        this.weight = weight;
        this.touch = touch;
    }
    @Override
    void showDetails() {
        System.out.println("id = "+ getId() + " price = " + getPrice() + " model = " + getModel() +
                " cpu = " + getCpu() + " ram = " + getRam() + " ssd = " + isSsd()+
                " memory = " + getMemory() + " weight = " + getWeight() + " touch = "+isTouch());
    }

    @Override
    double getPerformance() {
        return basePerformance();
    }

    public double getWeight() {
        return weight;
    }
    public String getType(){
        return "Laptop";
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }
}
