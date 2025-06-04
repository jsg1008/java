package 자료구조3장;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {
	private String sid;
	private String sname;
	private String dept;

	public Student(String sid, String sname, String dept) {
		this.sid = sid;//여기서만 존재할 수 있는 sid 값을 class Student 안에서 존재 가능한 this.sid로 초기화해준다. 
		this.sname = sname;
		this.dept = dept;
	}

	public String getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public String getDept() {
		return dept;
	}

	public int compareTo(Student other) {
		return this.sid.compareTo(other.sid);
	}

	@Override
	public String toString() {
		return sid + ", "+sname+", "+dept;
	}
}

public class Train_실습3_9객체comparable구현{
	public static void main(String[] args) {
		Student[] students = {
			    new Student("S001", "영희", "Math"),
			    new Student("S003", "민수", "Computer"),
			    new Student("S002", "철수", "Physics"),
			    new Student("S005", "지영", "Biology"),
			    new Student("S004", "준호", "Chemistry")
			};
		System.out.println("=== 정렬 전 학생 목록 ===");
		show(students);
		
		Arrays.sort(students);
		
		Student[] targets = {
			    new Student("S002", "철수", "Physics"),
			    new Student("S006", "홍길동", "Law"),
			    new Student("S004", "준호", "Chemistry")
			};
		
		System.out.println("=== 이진 탐색 결과 ===");
		
		for (Student target : targets) {
			int index = Arrays.binarySearch(students, target);
			if (index >=0) {
				System.out.println("찾은 학생 : "+students[index]);
			} else {
				System.out.println("학번 "+ target.getSid() + "인 학생은 존재하지 않습니다.");
			}
		}
	}
	
	private static void show(Student[] arr) {
		for (Student ss : arr) {
			System.out.println(ss);
		}
	}
}
