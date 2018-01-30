package tests;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TranscriptTest {

    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
        //TODO: write new values in testTranscript constructor
    }

    @Test
    public void testAddGrade() {
        testAddGetValidGrade("courseOne" , 2.5);   // Middle of range test case
        testAddGetValidGrade("courseTwo" , 0.0);   // lower boundary test case
        testAddGetValidGrade("courseThree" , 4.0); // upper boundary test case

        testAddGetInvalidGrade("failOne", 6.0);   // lower range test case
        testAddGetInvalidGrade("failTwo", 4.1);   // lower boundary test case
        testAddGetInvalidGrade("failThree", -0.1);// upper boundary test case
        testAddGetInvalidGrade("failFour", -2);   // upper range test case
    }

    @Test
    public void testSetName() {
        testTranscript.setName("Bob");
        assertEquals(testTranscript.getStudentName(), "Bob");
    }

    @Test
    public void testGetGPA() {
        // instantiate a new student
        Transcript student = new Transcript("Foo", 007);

        // Add grades
        student.addGrade("1", 2.0);
        student.addGrade("2", 3.0);
        student.addGrade("3", 4.0);

        // check that it returns the correct GPA of a student
        double expected = (2.0 + 3.0 + 4.0) / 3;
        assertEquals(expected, student.getGPA());
    }


    private void testAddGetInvalidGrade(String course, double grade) {
        assertFalse(testTranscript.addGrade(course, grade));
        assertTrue(testTranscript.getCourseAndGrade(course) == null);
    }
    private void testAddGetValidGrade(String course, double grade) {
        assertTrue(testTranscript.addGrade(course, grade));
        assertEquals(testTranscript.getCourseAndGrade(course), grade);
    }
}