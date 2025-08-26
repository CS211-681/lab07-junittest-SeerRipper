package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่")
    void testAddNewStudent() {
        StudentList list = new StudentList();
        list.addNewStudent("1", "Pas");
        list.addNewStudent( "2","Hong");
        assertEquals(2.  , list.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่พร้อมคะแนน")
    void testAddNewStudentWithScore() {
        StudentList list = new StudentList();
        list.addNewStudent("2", "Bob", 70);
        assertEquals(1, list.getStudents().size());
        assertEquals(70, list.findStudentById("2").getScore());
    }

    @Test
    @DisplayName("ทดสอบการหานักเรียนด้วย ID")
    void testFindStudentById() {
        StudentList list = new StudentList();
        list.addNewStudent("3", "Not");
        Student s = list.findStudentById("3");
        assertNotNull(s);
        assertEquals("Not", s.isNameContains("Not") ? "Not" : "");
    }

    @Test
    @DisplayName("ทดสอบการ filter ตามชื่อ")
    void testFilterByName() {
        StudentList list = new StudentList();
        list.addNewStudent("4", "David");
        list.addNewStudent("5", "Daisy");

        StudentList filtered = list.filterByName("Da");
        assertEquals(2, filtered.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนกับนักเรียนตาม ID")
    void testGiveScoreToId() {
        StudentList list = new StudentList();
        list.addNewStudent("6", "Eve");

        list.giveScoreToId("6", 50.5);
        assertEquals(50.5, list.findStudentById("6").getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดนักเรียนจาก ID")
    void testViewGradeOfId() {
        StudentList list = new StudentList();
        list.addNewStudent("7", "Frank", 82);
        assertEquals("A", list.viewGradeOfId("7"));
        list.addNewStudent("8","Hong",60);
        assertEquals("C",list.viewGradeOfId("8"));
    }
}
