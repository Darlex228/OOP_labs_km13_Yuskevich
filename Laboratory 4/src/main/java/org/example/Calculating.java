package org.example;

public class Calculating {
    public Input in;
    public Calculating(Input i){
        this.in = i;
    }
    public String check(){
        if(in.l*in.a + in.m*in.b + in.n*in.c == 0){
            if(in.lang.equals("ukrainian")) return "Пряма паралельна до площини";
            return "Line is parallel to a plane";
        }
        if(in.l*in.b == in.a*in.m && in.m*in.c == in.b*in.n){
            if(in.lang.equals("ukrainian")) return "Пряма перпендикулярна до площини";
            return "Line is orthogonal to a plane";
        }
        if(in.lang.equals("ukrainian")) return "Пряма перетинає площину";
        return "Line intersects a plane";
    }
}
