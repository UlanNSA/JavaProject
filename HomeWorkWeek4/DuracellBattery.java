package task4;

public class DuracellBattery extends Battery{
    private double voltage; // Voltage in volts
    private double currency; // Currency in amperes
    private double energy; // Total energy in joules
    private double internalVoltage; // Internal voltage of battery in volts. (ɛ -epsilon)

    public DuracellBattery(double voltage, double currency, double energy, double internalVoltage) {
        this.voltage = voltage;
        this.currency = currency;
        this.energy = energy;
        this.internalVoltage = internalVoltage;
    }

    public DuracellBattery() {
    }

    public double getVoltage() {
        return voltage+internalVoltage;
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

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getInternalVoltage() {
        return internalVoltage;
    }

    public void setInternalVoltage(double internalVoltage) {
        this.internalVoltage = internalVoltage;
    }

    @Override
    public double getPower() {
        return getVoltage()*currency;
    }

    @Override
    public double getLifeTime() {
        return getEnergy()/getPower();
    }


    @Override
    public double getEnergy() {
        return energy;
    }

}
