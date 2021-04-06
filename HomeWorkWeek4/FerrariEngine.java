package task4;

public class FerrariEngine extends Engine{

    public FerrariEngine() {
    }

    public FerrariEngine(double engineVolume, int cylinderAmount, double engineWeight) {
        super(engineVolume, cylinderAmount, engineWeight);
    }

    @Override
    double efficiency() {
        return 0.25;
    }

    @Override
    double throttleEnergy() {

        return getEngineVolume() * getCylinderAmount() * 100;
    }

    @Override
    double breakEnergy() {
        return  getEngineWeight() * 2;
    }


}
