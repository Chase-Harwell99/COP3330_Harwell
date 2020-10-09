public class Sphere extends Shape3D{

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        return 4*(radius*radius)*Math.PI;
    }

    @Override
    public double getVolume() {
        return (4*(radius*radius*radius)*Math.PI)/3;
    }
}
