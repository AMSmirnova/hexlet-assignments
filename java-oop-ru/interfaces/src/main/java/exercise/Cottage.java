package exercise;

// BEGIN
public class Cottage implements Home {

    private final double area;
    private final int floorCounter;

    public Cottage(double area, int floorCounter) {
        this.area = area;
        this.floorCounter = floorCounter;
    }

    @Override
    public String toString() {
        return getFloorCounter() + " этажный коттедж площадью " + getArea() + " метров";
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home secondCottage) {
        if (getArea() == secondCottage.getArea()) {
            return 0;
        }
        return getArea() > secondCottage.getArea() ? 1 : -1;
    }

    public int getFloorCounter() {
        return floorCounter;
    }
}
// END
