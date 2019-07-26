package org.test;

public class Absquare {
    public static void main(String[] args) {
        System.out.println(abSumSquare(96, 85));
    }

    private static long abSumSquare(int a, int b){
        return a*a + b*b + 2*a*b;
    }
}
