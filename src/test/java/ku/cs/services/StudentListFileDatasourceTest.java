package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {

    private static final String TEST_DIR = "test_data";
    private static final String TEST_FILE = "test_students.csv";
    private StudentListFileDatasource datasource;
    private File testFile;

    @BeforeEach
    void setUp() {

        datasource = new StudentListFileDatasource(TEST_DIR, TEST_FILE);
        testFile = new File(TEST_DIR + File.separator + TEST_FILE);
    }

    @AfterEach
    void tearDown() {

        if (testFile.exists()) {
            testFile.delete();
        }
        File dir = new File(TEST_DIR);
        if (dir.exists() && dir.isDirectory()) {
            dir.delete();
        }
    }

    @Test
    @DisplayName("ทดสอบอ่านไฟล์ว่าง ต้องได้ StudentList ว่าง")
    void testReadEmptyFile() {
        StudentList students = datasource.readData();
        assertNotNull(students);
        assertEquals(0, students.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบ writeData และ readData ต้องได้ข้อมูลตรงกัน")
    void testWriteAndRead() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("1", "Alice", 90.5);
        studentList.addNewStudent("2", "Bob", 75.0);


        datasource.writeData(studentList);


        StudentList readList = datasource.readData();

        assertEquals(2, readList.getStudents().size());

        Student s1 = readList.getStudents().get(0);
        assertEquals("1", s1.getId());
        assertEquals("Alice", s1.getName());
        assertEquals(90.5, s1.getScore());

        Student s2 = readList.getStudents().get(1);
        assertEquals("2", s2.getId());
        assertEquals("Bob", s2.getName());
        assertEquals(75.0, s2.getScore());
    }

    @Test
    @DisplayName("ทดสอบ writeData ทับไฟล์เก่า ต้องได้ข้อมูลใหม่เท่านั้น")
    void testOverwriteFile() {
        StudentList firstList = new StudentList();
        firstList.addNewStudent("1", "Old", 10.0);
        datasource.writeData(firstList);

        StudentList newList = new StudentList();
        newList.addNewStudent("2", "New", 100.0);
        datasource.writeData(newList);

        StudentList readList = datasource.readData();

        assertEquals(1, readList.getStudents().size());
        assertEquals("2", readList.getStudents().get(0).getId());
        assertEquals("New", readList.getStudents().get(0).getName());
        assertEquals(100.0, readList.getStudents().get(0).getScore());
    }
}
