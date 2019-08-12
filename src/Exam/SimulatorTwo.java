package Exam;

public class SimulatorTwo {
}

class QuestionsTwentyFive{
    public static void main(String[] args) {
        String color = "teal";

        switch (color) {
            case "Red":
                System.out.println("Found Red");
            case "Blue":
                System.out.println("Found Blue");
                break;
            case "Teal":
                System.out.println("Found Teal");
                break;
            default:
                System.out.println("Found Default");

        }
    }
}

class QuestionsTwentyEight{
    static class MissingInfoException extends Exception{}
    class AgeOutofRangeException extends Exception{}

    static class Cadidante{
        String name;
        int age;

        Cadidante(String name, int age) throws Exception{
            if(name == null){
                throw new MissingInfoException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Cadidante c = new Cadidante("James", 20);
    }
}