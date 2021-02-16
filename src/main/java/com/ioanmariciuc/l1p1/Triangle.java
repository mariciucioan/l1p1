package com.ioanmariciuc.l1p1;


public class Triangle extends Shape {

    private boolean hasValues;

    enum TYPE {
        equilateral,
        isosceles,
        rectangular,
        other
    }

    private TYPE type;

    public Triangle() {
        SetAnglesCount(3);
        type = TYPE.other;
        sides = new float[getAnglesCount()];
        hasValues = false;
    }
    public Triangle(TYPE type) {
        SetAnglesCount(3);
        sides = new float[getAnglesCount()];
        this.type = type;
        hasValues = false;
    }
    public Triangle(TYPE type, float l1, float l2, float l3) {
        this.type = type;
        SetAnglesCount(3);
        sides = new float[getAnglesCount()];
        sides[0] = l1;
        sides[1] = l2;
        sides[2] = l3;
        hasValues = true;
    }
    public Triangle(TYPE type, float l[]) {
        SetAnglesCount(3);
        sides = new float[getAnglesCount()];
        this.type = type;
        if(l.length > getAnglesCount()) {
            return;
        }
        for(int i=0; i<getAnglesCount(); i++) {
            sides[i] = l[i];
        }

        hasValues = true;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public void setLengthOfSide(int sidePos, float value) {
        switch (type) {
            case equilateral:
                sides[0] = sides[1] = sides[2] = value;
                break;
            case isosceles:
                if(sidePos == 1 || sidePos == 2) {
                    sides[1] = sides[2] = value;
                }
            case rectangular:
                if(sidePos == 0) {
                    if(value > sides[1] && value > sides[2])
                        sides[sidePos] = value;
                    else Display("Value of the hypotenuza was not modified. Reason: bad input.");
                } else if (sidePos > 0 && value < sides[0] && sides[0] != 0) {
                    sides[sidePos] = value;
                } else if(sides[0] == 0)
                    Display("You have to give a value to the hypotenuza first.");
                break;
            case other:
                sides[sidePos] = value;
        }

        hasValues = true;
    }

    public void printInfo() {
        if(hasValues) {
            switch (type) {
                case equilateral:
                    Display("The shape is a equilateral triangle. (l=" + sides[0] + ")");
                    break;
                case isosceles:
                    Display("The shape is a isosceles triangle. (b=" + sides[0] + " l1="
                            + sides[1] + " l2=" + sides[2] + ")");
                    break;
                case rectangular:
                    Display("The shape is a rectangular triangle. (i=" + sides[0] + " c1="
                            + sides[1] + " c2=" + sides[2] + ")");
                    break;
                case other:
                    Display("The shape is a triangle (l1=" + sides[0] + " l2="
                            + sides[1] + " l3=" + sides[2] + ")");
                    break;
            }
        } else Display("No valid input values were found for the triangle.");
    }

    public float computedArea() {
        float c1, c2, base, height, l, p, a, b, c;
        switch (type) {
            case rectangular:
                c1 = sides[1];
                c2 = sides[2];
                return (c1*c2) / 2;
            case isosceles:
                c1 = Math.max(sides[1], sides[2]);
                c2 = Math.min(sides[1], sides[2]);
                base = sides[0];
                height = c1*c1-c2*c2;
                return (base*height)/2;
            case equilateral:
                l = sides[0];
                return (float) (((l*l)*Math.sqrt(3))/4);
            case other:
                p = computedPerimeter()/2;
                a = sides[0];
                b = sides[1];
                c = sides[2];
                return (float) Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }
        return (float) -1.0;
    }
}