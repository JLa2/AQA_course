import java.util.ArrayList;
import java.util.List;
public class MainTask {
public static void main(String[]args) {
    List<Student> students=new ArrayList<>();
    List<Integer>gradesRick=List.of(5, 5, 4, 5);
    List<Integer>gradesBubble=List.of(2, 3, 4, 2);
    List<Integer>gradesPeter=List.of(5, 2, 3, 3);
    List<Integer>gradesKenny=List.of(5, 5, 5, 4);
    students.add(new Student("Rick Sanchez", 101, 2, gradesRick));
    students.add(new Student("Bubble Gum", 202, 3, gradesBubble));
    students.add(new Student("Peter Griffin", 101, 2, gradesPeter));
    students.add(new Student("Kenny McCormik", 303, 4, gradesKenny));
    students=getGoodStudents(students);
    for(Student s:students) {
        System.out.println(s.name);
    }
    printStudents(students, 2);
}
public static List<Student> getGoodStudents(List<Student> students) {
List<Student>goodStudents=new ArrayList();
for(Student student:students) {
    if(student.getAverageGrade()>=3.0) {
        goodStudents.add(student);
    }
}
return goodStudents;
}
public static void printStudents(List<Student>students, int course) {
    for(Student student:students) {
        if(student.course==course) {
            System.out.println(student.name);
        }
    }
}
}
