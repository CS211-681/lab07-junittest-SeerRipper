package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {
    StudentListHardCodeDatasource ds = new StudentListHardCodeDatasource();

    @Test
    void testReadData() {
        StudentList list;
        list = ds.readData();
        assertNotNull(list);
        assertNotNull(list.findStudentById("6710400006"));
        assertNotNull(list.findStudentById("6710400007"));
        assertNotNull(list.findStudentById("6710400008"));
        assertNotNull(list.findStudentById("6710400009"));

    }
}