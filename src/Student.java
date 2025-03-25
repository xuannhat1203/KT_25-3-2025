import java.util.Scanner;

public class Student {
    String studentId;
    String studentName;
    int age;
    float average;

    public Student(String studentId, String studentName, int age, float average) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.average = average;
    }

    public Student() {

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        studentId = sc.nextLine();
        System.out.print("Student Name: ");
        studentName = sc.nextLine();
        System.out.print("Student Age: ");
        age = sc.nextInt();
        System.out.print("Student Average: ");
        average = sc.nextFloat();
    }
    @Override
    public String toString() {
        return studentId + " - " + studentName + " - " + age + " - " + average;
    }
}
