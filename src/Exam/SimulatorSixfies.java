package Exam;

import java.util.ArrayList;
import java.util.List;

public class SimulatorSixfies {

}

class QuestionSixtwo {
    public static void main(String[] args) {
        DoInterface doi= new DoClass();
        doi.m1(100);
        doi.m2(200);
    }

    interface DoInterface {
        void m1(int n);
        public void m2(int n);
    }

    static class DoClass implements DoInterface{
        int x1,x2;
        DoClass(){
            this.x1 = 0;
            this.x2= 10;
        }
        @Override
        public void m1(int p1) {
            x1 += p1;
            System.out.println(x1);
        }

        @Override
        public void m2(int p1) {
            x2 += p1;
            System.out.println(x2);
        }
    }
}

class QuestionSistyThree{
    public static void main(String[] args) {
        List<Alpha> stra = new ArrayList<>();
        stra.add(new Alpha());
        stra.add(new Beta());
        stra.add(new Gamma());

        for (Alpha t:stra) {
            System.out.println(t.doStuff("Java"));
        }
    }

    static class Alpha{
        public String doStuff(String msg) {
            return msg;
        }
    }

    static class Beta extends Alpha {
        public String doStuff(String msg) {
            return msg.replace('a', 'e');
        }
    }

    static class Gamma extends Beta {
        public String doStuff(String msg) {
            return msg.substring(2);
        }
    }
}