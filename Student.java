import java.util.List;
public class Student {
    String name;
    int group;
    int course;
    List<Integer>grades;
    public Student(String name, int group, int course, List<Integer>grades) {
        this.name=name;
        this.group=group;
        this.course=course;
        this.grades=grades;
    }
    public double getAverageGrade() {
        int sum=0;
        for(int grade:grades) {
            sum+=grade;
        }
        return (double) sum/grades.size();
    }
    public void nextCourse() {
        if (getAverageGrade()>=3) {
            course++;
        } else {
            System.out.println("Не переведен");
        }
    }
}
