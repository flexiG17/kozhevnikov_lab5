package SecondProgramVariant;

class ElectricCar extends Car {
    private final int batteryCapacity;

    public ElectricCar(String makeBy, String model, int yearOfProduction, int batteryCapacity) {
        super(makeBy, model, yearOfProduction);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void carSound() {
        System.out.println("Едет бесшумно");
    }

    @Override
    public String toString() {
        return "\nЭлектромобиль" +
                super.toString() + "\n" +
                "объем батареи: " + batteryCapacity + "кв/ч";
    }

    @Override
    public boolean equals(Object secondCar) {
        if (!super.equals(secondCar)) {
            return false;
        };
        ElectricCar currentCar = (ElectricCar) secondCar;
        return batteryCapacity == currentCar.batteryCapacity;
    }
}
