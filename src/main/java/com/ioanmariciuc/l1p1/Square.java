package com.ioanmariciuc.l1p1;

// Square is a class inherited from abstract class Shape
public class Square extends Shape {
    private boolean hasValues;

    public Square() {
        hasValues = false;
        SetAnglesCount(4);
        sides = new float[getAnglesCount()];
    }
    public Square(float L) {
        SetAnglesCount(4);
        sides = new float[getAnglesCount()];
        setLengthOfSides(L);
    }

    public void setLengthOfSides(float value) {
        for(int i=0; i<getAnglesCount(); i++) {
            sides[i] = value;
        }

        hasValues = true;
    }

    @Override
    public float computedPerimeter() {
        return 4*sides[0];
    }

    public void printInfo() {
        if(hasValues)
            Display("The shape is a square (l=" + sides[0] + ")");
        else Display("No valid length of side input.");
    }

    public float computedArea() {
        return sides[0]*sides[1];
    }
}
