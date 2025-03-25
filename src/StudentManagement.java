import java.util.*;

public class StudentManagement {
    public static Map<String, Student> students = new HashMap<String, Student>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("********** MENU **********");
            System.out.println("1. Danh sach sinh vien");
            System.out.println("2. Them moi cac sinh vien");
            System.out.println("3. Xoa sinh vien theo ma sinh vien");
            System.out.println("4. Tinh diem trung binh cua tat ca sinh vien");
            System.out.println("5. In thong tin sinh vien co diem trung binh lon nhat");
            System.out.println("6. In thong tin sinh vien co tuoi nho nhat");
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Danh sach sinh vien");
                    displayStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    averagePoint();
                    break;
                case 5:
                    printAvgMax();
                    break;
                case 6:
                    printAgeMin();
                    break;
                case 7:
                    System.out.println("Thoat chuong trinh");
                    System.exit(0);
                    break;
                default:
                    System.out.println("lua chon khong hop le");
                    break;
            }
        } while (true);
    }

    public static void displayStudent() {
        if (students.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            for (Map.Entry<String, Student> entry : students.entrySet()) {
                System.out.println(entry.getValue().toString());
            }
        }
    }

    public static void addStudent() {
        System.out.println("Nhap thong tin sinh vien moi");
        Student newStudent = new Student();
        newStudent.inputData();
        students.put(String.valueOf(students.size() + 1), newStudent);
        System.out.println("Them sinh vien thanh cong");
    }

    public static void removeStudent() {
        System.out.println("Nhap ma sinh vien muon xoa: ");
        String id = sc.nextLine();
        boolean flag = false;
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            if (entry.getValue().getStudentId().equals(id)) {
                flag = true;
                students.remove(entry.getKey());
                break;
            }
        }
        if (flag) {
            System.out.println("Sinh vien khong ton tai");
        }
    }

    public static void averagePoint() {
        float average = 0;
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            average += entry.getValue().getAverage();
        }
        average /= students.size();
        System.out.println("Diem trung binh: " + average);
    }

    public static void printAvgMax() {
        List<Student> listStudent = new ArrayList<>(students.values());
        listStudent.sort(Comparator.comparing(Student::getAverage).reversed());
        System.out.println(listStudent.getFirst().getStudentName());
    }

    public static void printAgeMin() {
        List<Student> listStudent = new ArrayList<>(students.values());
        listStudent.sort(Comparator.comparing(Student::getAge));
        System.out.println(listStudent.getFirst().getStudentName());
    }
}
