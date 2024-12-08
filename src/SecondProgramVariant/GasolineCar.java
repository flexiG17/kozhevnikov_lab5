package SecondProgramVariant;

class GasolineCar extends Car {
    private final double fuelTankCapacity;

    public GasolineCar(String makeBy, String model, int yearOfProduction, int fuelTankCapacity) {
        super(makeBy, model, yearOfProduction);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void carSound() {
        System.out.println("Едет со звуком двигателя внутреннего сгорания");
    }

    @Override
    public String toString() {
        return "\nБезниновый автомобиль" +
                super.toString() + "\n" +
                "объем бака: " + fuelTankCapacity + " литров";
    }

    @Override
    public boolean equals(Object secondCar) {
        if (!super.equals(secondCar)) return false;
        GasolineCar currentCar = (GasolineCar) secondCar;
        return Double.compare(currentCar.fuelTankCapacity, fuelTankCapacity) == 0;
    }
}
