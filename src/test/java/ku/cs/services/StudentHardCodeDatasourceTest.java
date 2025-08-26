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
        assertNotNull(list.findStudentById("6610000001"));
        assertNotNull(list.findStudentById("6610000002"));
        assertNotNull(list.findStudentById("6610000003"));
        assertNotNull(list.findStudentById("6610000004"));
    }
}