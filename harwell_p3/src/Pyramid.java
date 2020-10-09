public class Pyramid extends Shape3D{

    private double length;
    private double width;
    private double height;


    public Pyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName() {
        return "pyramid";
    }

    @Override
    public double getArea() {
        return (length*width) + (length*Math.sqrt((width/2)*(width/2)+(height*height))) + (width*Math.sqrt((length/2)*(length/2)+(height*height)));
    }

    @Override
    public double getVolume() {
        return (length*width*height)/3;
    }
}
