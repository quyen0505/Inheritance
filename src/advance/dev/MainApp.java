
package advance.dev;

import java.util.Scanner;

class Person {
	protected String name;
	protected int age;
	protected String phoneNumber;

	public Person(String name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
}

class Student extends Person {
	private double mathScore;
	private double physicsScore;
	private double chemistryScore;
	private String studentID;
	private String className;

	public Student(String name, int age, String phoneNumber, double mathScore, double physicsScore,
			double chemistryScore, String studentID, String className) {
		super(name, age, phoneNumber);
		this.mathScore = mathScore;
		this.physicsScore = physicsScore;
		this.chemistryScore = chemistryScore;
		this.studentID = studentID;
		this.className = className;
	}

	public double calculateAverageScore() {
		return (mathScore + physicsScore + chemistryScore) / 3.0;
	}
}

class Teacher extends Person {
	private String teacherID;
	private double salaryCoefficient;

	public Teacher(String name, int age, String phoneNumber, String teacherID, double salaryCoefficient) {
		super(name, age, phoneNumber);
		this.teacherID = teacherID;
		this.salaryCoefficient = salaryCoefficient;
	}

	public double calculateSalary() {
		// Giả sử lương cơ bản là 1000
		return 1000 * salaryCoefficient;
	}
}

public class MainApp {

	public static void main(String[] args) {
		Person[] persons = new Person[10];
		input(persons);
		print(persons);
		findTeacher(persons);
	}

	public static void input(Person[] persons) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			System.out.println("Nhập thông tin giáo viên:");
			System.out.print("Tên: ");
			String name = scanner.nextLine();
			System.out.print("Tuổi: ");
			int age = scanner.nextInt();
			scanner.nextLine(); // Loại bỏ ký tự thừa xuống dòng
			System.out.print("Số điện thoại: ");
			String phoneNumber = scanner.nextLine();
			System.out.print("Mã giáo viên: ");
			String teacherID = scanner.nextLine();
			System.out.print("Hệ số lương: ");
			double salaryCoefficient = scanner.nextDouble();
			scanner.nextLine(); // Loại bỏ ký tự thừa xuống dòng

			persons[i] = new Teacher(name, age, phoneNumber, teacherID, salaryCoefficient);
		}

		for (int i = 4; i < 10; i++) {
			System.out.println("Nhập thông tin sinh viên:");
			System.out.print("Tên: ");
			String name = scanner.nextLine();
			System.out.print("Tuổi: ");
			int age = scanner.nextInt();
			scanner.nextLine(); // Loại bỏ ký tự thừa xuống dòng
			System.out.print("Số điện thoại: ");
			String phoneNumber = scanner.nextLine();
			System.out.print("Điểm Toán: ");
			double mathScore = scanner.nextDouble();
			System.out.print("Điểm Lý: ");
			double physicsScore = scanner.nextDouble();
			System.out.print("Điểm Hóa: ");
			double chemistryScore = scanner.nextDouble();
			scanner.nextLine(); // Loại bỏ ký tự thừa xuống dòng
			System.out.print("Mã sinh viên: ");
			String studentID = scanner.nextLine();
			System.out.print("Lớp: ");
			String className = scanner.nextLine();

			persons[i] = new Student(name, age, phoneNumber, mathScore, physicsScore, chemistryScore, studentID,
					className);
		}
	}

	public static void print(Person[] persons) {
		for (Person person : persons) {
			if (person instanceof Teacher) {
				Teacher teacher = (Teacher) person;
				System.out.println("Giáo viên: " + teacher.name);
			} else if (person instanceof Student) {
				Student student = (Student) person;
				System.out.println("Sinh viên: " + student.name);
			}
		}
	}

	public static void findTeacher(Person[] persons) {
		Teacher highestPaidTeacher = null;
		double maxSalary = Double.MIN_VALUE;

		for (Person person : persons) {
			if (person instanceof Teacher) {
				Teacher teacher = (Teacher) person;
				double salary = teacher.calculateSalary();
				if (salary > maxSalary) {
					maxSalary = salary;
					highestPaidTeacher = teacher;
				}
			}
		}

		if (highestPaidTeacher != null) {
			System.out.println("Giáo viên có lương cao nhất: " + highestPaidTeacher.name);
			System.out.println("Lương: " + highestPaidTeacher.calculateSalary());
		} else {
			System.out.println("Không tìm thấy giáo viên nào.");
		}
	}

	// Có thể thêm hàm tìm sinh viên có điểm trung bình cao nhất tương tự
}
