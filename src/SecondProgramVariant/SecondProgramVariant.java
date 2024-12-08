package SecondProgramVariant;

public class SecondProgramVariant {
    public static void main(String[] args) {
        Car[] cars = new Car[3];

        cars[0] = new ElectricCar("Tesla", "Model S", 2022, 100);
        cars[1] = new GasolineCar("Toyota", "Camry", 2021, 60);

        for (Car car : cars) {
            System.out.println(car.toString());
            car.carSound();
        }

        ElectricCar car1 = new ElectricCar("Tesla", "Model S", 2022, 100);
        System.out.println("Tesla Model S = Tesla Model S это - " + car1.equals(cars[0]));
    }
}
