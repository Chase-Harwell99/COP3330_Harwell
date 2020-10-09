public class Triangle extends Shape2D{

    private double length1;
    private double length2;

    public Triangle(double length1, double length2) {
        this.length1 = length1;
        this.length2 = length2;
    }

    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public double getArea() {
        return (length1*length2)/2;
    }

}
