package com.example.Squrt_x;

public class SolutionTwo {
    public int mySqrt(int x) {
        double x0 = x;
        double x1 = (x0 + x / x0) / 2;

        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2;
        }
        return (int) x1;
    }
}
