package model;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private String name;
    private int id;
    private List<Course> courses;
    private List<Grade> grades;
    private double gpa;

    public Transcript(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<Course>();
        this.grades = new ArrayList<Grade>();
        this.gpa = 0;
    }

    // getters
    public String getStudentName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
    public String getName() {
        return name;
    }
    public List<Grade> getGrades() {
        return grades;
    }
    public Double getGrade(Course c) {
        for (Grade grade : grades) {
            if (grade.getCourse().getName().equals(c.getName())) {
                return grade.getScore();
            }
        }
        return null;
    }
    public int getId() {
        return id;
    }
    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourse(String courseName) {
        for (Course c : courses) {
            if (c.getName().equals(courseName)) {
                return c;
            }
        }
        return null;
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
    public boolean addGrade(Course course, double grade) {
        addCourse(course);

        if (grade >= 0.0 && grade <= 4.0) {
            this.grades.add(new Grade(course, grade));
            return true;
        }
        return false;
    }

    public boolean addCourse(Course course) {
        courses.add(course);
        return true;
    }

    // This method should return course name and grade in some consistent String format
    // REQUIRES: course exists
    // EFFECTS:  returns String format "CourseName: Grade" OR null if no grade
    public String getCourseAndGrade(Course course) {
        if (course != null) {
            return course.getName() + ": " + getGrade(course);
        }
        return null;
    }


    // REQUIRES: grades != null
    // EFFECTS:  prints format "id name GPA"
    @Override
    public String toString() {
        return this.getId() + " " + this.getStudentName() + " " + this.getGPA();
    }

    // REQUIRES: grades > 0, courses > 0
    // MODIFIES: this
    // EFFECTS: returns GPA of this student
    public double getGPA() {
        gpa = calculateGpa();
        return gpa;
    }

    private double calculateGpa() {
        double sum = 0;
        for (Grade g : grades) {
            sum += g.getScore();
        }
        return sum/grades.size();
    }


    //
    public double getAverageOverSelectedCourses(List<String> selectedCourses){
        //TODO: 2a specification
        //TODO: 2b implement
        return 0.0;
        //think about which method you can call as a helper!
    }


}
