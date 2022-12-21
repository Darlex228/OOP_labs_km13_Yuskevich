package org.example;

import java.util.Scanner;

public class Input {
    public int x0, y0, z0, l, m, n;
    public int a, b, c, d;
    public String lang;
    public Input(int x00, int y00, int z00, int l0, int m0, int n0, int a0, int b0, int c0, int d0){
        this.x0=x00;
        this.y0=y00;
        this.z0=z00;
        this.l=l0;
        this.m=m0;
        this.n=n0;
        this.a=a0;
        this.b=b0;
        this.c=c0;
        this.d=d0;
    }
    public Input(){
        Scanner s = new Scanner(System.in);
        lang = s.next();
        if(lang.equals("ukrainian")){
            System.out.println("Введіть коефіцієнти прямої заданої канонічним рівнянням (x-x0)/l = (y-y0)/m = (z-z0)/n: ");
        }
        else{
            System.out.println("Input coefficients in canonical equivalence of line (x-x0)/l = (y-y0)/m = (z-z0)/n: ");
        }
        System.out.println("x0=");
        x0 = s.nextInt();
        System.out.println("y0=");
        y0 = s.nextInt();
        System.out.println("z0=");
        z0 = s.nextInt();
        System.out.println("l=");
        l = s.nextInt();
        System.out.println("m=");
        m = s.nextInt();
        System.out.println("n=");
        n = s.nextInt();
        if(lang.equals("ukrainian")){
            System.out.println("Введіть коефіцієнти площини заданої канонічним рівнянням ax+by+cz+d=0: ");
        }
        else{
            System.out.println("Input coefficients in canonical equivalence of plane ax+by+cz+d=0: ");
        }
        System.out.println("a=");
        a = s.nextInt();
        System.out.println("b=");
        b = s.nextInt();
        System.out.println("c=");
        c = s.nextInt();
        System.out.println("d=");
        d = s.nextInt();
    }
}
