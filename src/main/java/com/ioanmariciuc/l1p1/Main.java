package com.ioanmariciuc.l1p1;

public class Main{

    public static void main(String[] args) {

        Square square = new Square(3);
        Square square2 = new Square();
        Triangle triangle= new Triangle(Triangle.TYPE.isosceles);
        Triangle triangle2 = new Triangle();

        square.printInfo();
        System.out.println("Square area = " + square.computedArea());
        System.out.println("Square perimeter = " + square.computedPerimeter());

        System.out.println("\n");

        square2.printInfo();
        square2.setLengthOfSides(5);
        square2.printInfo();
        System.out.println("Square area = " + square2.computedArea());
        System.out.println("Square perimeter = " + square2.computedPerimeter());

        System.out.println("\n");

        triangle.printInfo();
        triangle.setLengthOfSide(0, 8);
        triangle.setLengthOfSide(1, 5);
        triangle.printInfo();
        System.out.println("Triangle area = " + triangle.computedArea());
        System.out.println("Triangle perimeter = " + triangle.computedPerimeter());

        System.out.println("\n");

        triangle2.printInfo();
        triangle2.setType(Triangle.TYPE.equilateral);
        triangle2.setLengthOfSide(0, 3);
        triangle2.printInfo();
        System.out.println("Triangle area = " + triangle2.computedArea());
        System.out.println("Triangle perimeter = " + triangle2.computedPerimeter());
    }
}
