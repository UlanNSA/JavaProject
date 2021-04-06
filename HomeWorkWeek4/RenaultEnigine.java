package task4;

public class RenaultEnigine extends Engine {
private double extraTurboEnergy;

    public RenaultEnigine(double extraTurboEnergy) {
        this.extraTurboEnergy = extraTurboEnergy;
    }

    public RenaultEnigine(double engineVolume, int cylinderAmount, double engineWeight, double extraTurboEnergy) {
        super(engineVolume, cylinderAmount, engineWeight);
        this.extraTurboEnergy = extraTurboEnergy;
    }

    @Override
    double efficiency() {
        return 0.27;
    }

    @Override
    double throttleEnergy() {
        return getEngineVolume() * getCylinderAmount() * 110 +
                extraTurboEnergy;
    }

    @Override
    double breakEnergy() {
        return getEngineWeight() * 2.1;
    }
}
