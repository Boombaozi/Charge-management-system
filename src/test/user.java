package test;

import test.utils.datainfo;

public class user {
    public  int a;
    public String b;

    static {
        datainfoc a = new datainfoc();
        a.doGet();




    }
    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getB() {
        return b;
    }
}
