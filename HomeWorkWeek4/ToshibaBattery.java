package task4;

public class ToshibaBattery  extends Battery {
    private double voltage;
    private double currency;
    private double energy;
    private double extraEnergy;

    public ToshibaBattery() {
    }

    public ToshibaBattery(double voltage, double currency, double energy, double extraEnergy) {
        this.voltage = voltage;
        this.currency = currency;
        this.energy = energy;
        this.extraEnergy = extraEnergy;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    @Override
    public double getEnergy() {
        return energy+getExtraEnergy();
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getExtraEnergy() {
        return extraEnergy;
    }

    public void setExtraEnergy(double extraEnergy) {
        this.extraEnergy = extraEnergy;
    }

    @Override
    double getPower() {
        return getCurrency()*getVoltage();
    }

    @Override
    double getLifeTime() {
        return getEnergy()/getPower();
    }

}
