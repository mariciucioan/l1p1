package com.ioanmariciuc.l1p1;

// Abstract class with 1 encapsulated variable of type int
abstract class Shape implements Interface {
    private int angles;
    protected float[] sides;

    public int getAnglesCount() {
        return angles;
    }

    public void SetAnglesCount(int value) {
        angles = value;
    }

    public float computedPerimeter() {
        float sum=0f;
        for(int i=0; i < getAnglesCount(); i++)
            sum+=sides[i];

        return sum;
    }

    public void Display(String s) {
        System.out.println(s);
    }

    abstract float computedArea();
}
