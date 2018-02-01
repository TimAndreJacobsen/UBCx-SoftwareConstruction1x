package tests;

import model.Course;
import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TranscriptTest {

    private Transcript testTranscript;
    private Course course1;
    private Course course2;
    private Course course3;
    private Course course4;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
    }

    @Test
    public void testAddGrade() {
        // SETUP:
        Course course1 = new Course("test1");
        Course course2 = new Course("test2");
        Course course3 = new Course("test3");
        Course course4 = new Course("test4");
        testTranscript.addCourse(course1);
        testTranscript.addCourse(course2);
        testTranscript.addCourse(course3);

        // TEST:
        assertTrue(testTranscript.addGrade(course1, 2.5));   // Middle of range test case
        assertTrue(testTranscript.addGrade(course2, 0.0));   // lower boundary test case
        assertTrue(testTranscript.addGrade(course3, 4.0)); // upper boundary test case
        assertTrue(testTranscript.addGrade(course4, 3.0));

        // VERIFY:
        assertEquals(testTranscript.getGrade(course1), 2.5);
        assertEquals(testTranscript.getGrade(course2), 0.0);
        assertEquals(testTranscript.getGrade(course3), 4.0);
        assertEquals(testTranscript.getGrade(course4), 3.0);

    }

    @Test
    public void testAddInvalidGrade() {
        Course course1 = new Course("test1");
        Course course2 = new Course("test2");
        Course course3 = new Course("test3");
        Course course4 = new Course("test4");
        testTranscript.addCourse(course1);
        testTranscript.addCourse(course2);
        testTranscript.addCourse(course3);
        testTranscript.addCourse(course4);

        assertFalse(testTranscript.addGrade(course1, 6.0 ));   // Middle of range test case
        assertFalse(testTranscript.addGrade(course2, 4.1 ));   // lower boundary test case
        assertFalse(testTranscript.addGrade(course3, -0.1)); // upper boundary test case
        assertFalse(testTranscript.addGrade(course4, -2  )); // upper boundary test case

        assertEquals(testTranscript.getGrade(course1), null );
        assertEquals(testTranscript.getGrade(course2), null);
        assertEquals(testTranscript.getGrade(course3), null);
        assertEquals(testTranscript.getGrade(course4), null);

    }

    @Test
    public void testSetName() {
        testTranscript.setName("Bob");
        assertEquals(testTranscript.getStudentName(), "Bob");
    }

    @Test
    public void addCourse() {
        // SETUP:
        Course courseAdd1 = new Course("1");
        Course courseAdd2 = new Course("2");
        Course courseAdd3 = new Course("3");
        // TEST:
        assertTrue(testTranscript.addCourse(courseAdd1));
        assertTrue(testTranscript.addCourse(courseAdd2));
        assertTrue(testTranscript.addCourse(courseAdd3));
        // VERIFY:
        assertEquals(testTranscript.getCourses().size(), 3);
        assertEquals(testTranscript.getCourse("1"), courseAdd1);
        assertEquals(testTranscript.getCourse("2"), courseAdd2);
        assertEquals(testTranscript.getCourse("3"), courseAdd3);

    }

    @Test
    public void getInvalidCourses() {
        assertFalse(testTranscript.addGrade(course1, -0.1));
        assertFalse(testTranscript.addGrade(course2, -5));
        assertFalse(testTranscript.addGrade(course3, 4.1));
        assertFalse(testTranscript.addGrade(course4, 10));

        assertEquals(testTranscript.getCourses().get(0), null);
        assertEquals(testTranscript.getCourses().get(1), null);
        assertEquals(testTranscript.getCourses().get(2), null);
        assertEquals(testTranscript.getCourses().get(3), null);
    }

    @Test
    public void testSetId() {
        testTranscript.setId(10);
        assertEquals(testTranscript.getId(),10);
    }

    @Test
    public void testGetGPA() {
        // instantiate a new student
        Transcript student = new Transcript("Foo", 007);

        // Add grades
        student.addGrade(course1, 2.0);
        student.addGrade(course2, 3.0);
        student.addGrade(course3, 4.0);

        // check that it returns the correct GPA of a student
        double expected = (2.0 + 3.0 + 4.0) / 3;
        assertEquals(expected, student.getGPA());
    }


    @Test
    public void testgetAverageOverSelectedCourses() {
        // TODO: 2: test case
    }
}