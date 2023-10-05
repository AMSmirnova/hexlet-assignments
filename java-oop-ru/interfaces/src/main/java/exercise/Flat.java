package exercise;

// BEGIN
public class Flat implements Home {
    private final double area;
    private final double balconyArea;
    private final int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }


    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + getFloor() + " этаже";
    }

    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    @Override
    public int compareTo(Home secondFlat) {
        if (getArea() == secondFlat.getArea()) {
            return 0;
        }
        return getArea() > secondFlat.getArea() ? 1 : -1;
    }

    public int getFloor() {
        return floor;
    }
}
// END
