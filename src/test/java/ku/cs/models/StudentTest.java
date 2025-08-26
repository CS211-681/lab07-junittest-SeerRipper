package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("P", s.grade());
    }

    @Test
    @DisplayName("test changeName method")
    void testChangeName(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.changeName("Tony");
        assertEquals("Tony", s.getName());
    }

    @Test
    @DisplayName("test isId method")
    void testIsId(){
        Student s = new Student("6610450153", "StudentTest");
        assertEquals(true, s.isId("6610450153"));
    }

    @Test
    @DisplayName("test isNameContains method")
    void testIsNameContains(){
        Student s = new Student("6610450153", "Barry");
        assertEquals(true, s.isNameContains("Barry"));
    }

    @Test
    @DisplayName("test toString method")
    void testToString(){
        Student s = new Student("6610450153", "StudentTest", 50);
        assertEquals("{id: '6610450153', name: 'StudentTest', score: 50.0}",  s.toString());
    }
}