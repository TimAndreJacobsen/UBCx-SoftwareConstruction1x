package model;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private String name;
    private int id;
    private List<Course> courses;


    public Transcript(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<Course>();
    }

    // getters
    public String getStudentName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public List<Course> getCourses() {
        return courses;
    }

    // setters

    // MODIFIES: this
    // EFFECTS : change name
    public void setName(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS : change id
    public void setId(int id) {
        this.id = id;
    }

    // REQUIRES: Grade is valid(0.0 <-> 4.0), course != null
    // MODIFIES: this
    // EFFECTS:  adds grade to course
    public void addGrade(String course, double grade){
        assert (grade > 0.0 && grade <= 4.0);
    }

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
