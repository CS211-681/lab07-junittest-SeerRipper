package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    StudentHardCodeDatasource ds = new StudentHardCodeDatasource();

    @Test
    void testReadData() {
        StudentList list;
        list = ds.readData();
        assertNotNull(list);
        assertNotNull(list.findStudentById("6710400001"));
        assertNotNull(list.findStudentById("6710400002"));
        assertNotNull(list.findStudentById("6710400003"));
        assertNotNull(list.findStudentById("6710400004"));

    }
}