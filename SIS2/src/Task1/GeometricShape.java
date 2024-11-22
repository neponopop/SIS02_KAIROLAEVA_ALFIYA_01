package Task1;

import java.io.Serializable;

abstract class GeometricShape implements Serializable {
    public abstract double calculateArea();
    public abstract String getShapeType();
}

class Circle extends GeometricShape {
    private double radius;

    public Circle(double radius) {      // SIS2_Kairolaeva_Alfiya_2301
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String getShapeType() {
        return "Circle";
    }
}

class Rectangle extends GeometricShape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;         // SIS2_Kairolaeva_Alfiya_2301
    }

    @Override
    public String getShapeType() {
        return "Rectangle";
    }
}

