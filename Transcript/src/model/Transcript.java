package model;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private List<Course> courses;

    public Transcript() {
        this.courses = new ArrayList<Course>();
    }

    // REQUIRES: Grade is valid(0.0 <-> 4.0), course != null
    // MODIFIES: this
    // EFFECTS:  adds grade to course
    public void addGrade(String course, double grade){ }

    // This method should return course name and grade in some consistent String format
    // REQUIRES: course exists
    // EFFECTS:  returns String format "CourseName: Grade"
    public String getCourseAndGrade(String course){ return null; }

    // REQUIRES: grades != null
    // EFFECTS:  prints out grades in course
    //           display student academic record
    public void printTranscript(){ }

    // EFFECTS: calculates GPA from Grade
    public double getGPA(){ return 0.0; }



}
