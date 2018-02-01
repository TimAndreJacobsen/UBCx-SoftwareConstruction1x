package ui;

import model.Transcript;

public class Main {
    public static void main(String[] args){

        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        Transcript t3 = new Transcript("Bob Geldoff", 1234);



        System.out.print(t1.getStudentName() + ": ");
        System.out.println(t1);

        System.out.println(t1.getGPA());



    }
}
