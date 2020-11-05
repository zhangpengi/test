import java.util.*;

class student {
    private String name;
    private String classes;
    private double grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public student(String name, String classes, double grade) {
        this.name = name;
        this.classes = classes;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", grade=" + grade +
                '}';
    }
}
//11:30
public class Test1 {
    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";

    }
}



