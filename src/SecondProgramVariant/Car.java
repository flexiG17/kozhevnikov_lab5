package SecondProgramVariant;

import java.util.Objects;

class Car {
    private final String makeBy;
    private final String model;
    private final int yearOfProduction;

    public Car(String make, String model, int year) {
        this.makeBy = make;
        this.model = model;
        this.yearOfProduction = year;
    }

    public void carSound() {
        System.out.println("Машина едет");
    }

    @Override
    public String toString() {
        return "\nПараметры машины \n" +
                "производитель: " + makeBy + "\n" +
                "модель: " + model + "\n" +
                "год выпуска: " + yearOfProduction;
    }

    @Override
    public boolean equals(Object secondCar) {
        if (this == secondCar) {
            return true;
        };
        if (secondCar == null || getClass() != secondCar.getClass()) {
            return false;
        };
        Car car = (Car) secondCar;
        return yearOfProduction == car.yearOfProduction &&
                Objects.equals(makeBy, car.makeBy) &&
                Objects.equals(model, car.model);
    }
}