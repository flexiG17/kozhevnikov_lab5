package MyProgram;

class CentripetalAcceleration extends PhysicalCalculation {
    private final double speed;
    private final double radius;

    public CentripetalAcceleration(double speed, double radius) {
        super(Math.pow(speed, 2) / radius);
        this.speed = speed;
        this.radius = radius;
    }

    @Override
    public double calculate() {
        return Math.pow(speed, 2) / radius;
    }

    @Override
    public String toString() {
        return String.format("Центростремительное ускорение a = %.3f м/с^2", calculate());
    }
}
