package ui;

import model.Transcript;

public class Main {
    public static void main(String[] args){

        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        Transcript t3 = new Transcript("Bob Geldoff", 1234);

        t1.addGrade("CPSC-210", 3.5);
        t1.addGrade("ENGL-201", 4.0);
        t1.addGrade("CPSC-110", 3.1);

        t2.addGrade("CPSC-210", 1.0);
        t2.addGrade("ENGL-201", 3.2);
        t2.addGrade("CPSC-110", 4.1);

        t3.addGrade("CS-101", 3.9);
        t3.addGrade("CS-102", 3.9);

        System.out.print(t1.getStudentName() + ": ");
        t1.printTranscript();

        System.out.println(t1.getGPA());



    }
}
