package tests;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TranscriptTest {

    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
        //TODO: write new values in testTranscript constructor
    }

    @Test
    public void testAddGrade(){
        testAddAndGetGrade("test1", 1.0);
        testAddAndGetGrade("test2", 2.0);

        // TODO 1: create test that checks if invalid grades are rejected.
        // TODO 1: REQUIRES: Grade is valid(0.0 <-> 4.0), course != null

    }


    private void testAddAndGetGrade(String course, double grade) {
        assertTrue(testTranscript.addGrade(course, grade));
        assertEquals(testTranscript.getCourseAndGrade(course), grade);
    }
}