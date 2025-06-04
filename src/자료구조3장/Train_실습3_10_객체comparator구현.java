package 자료구조3장;

import java.util.Arrays;
import java.util.Comparator;

class Student1{
	private String sid;
	private String sname;
	private String dept;
	
	public Student1(String sid, String sname, String dept) {
		this.sid = sid;
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

	@Override
	public String toString() {
		return sid + ", "+sname + ", "+ dept;
	}
}

public class Train_실습3_10_객체comparator구현 {
	public static void main(String[] args) {
		Student1[] students = {
			    new Student1("S001", "영희", "Math"),
			    new Student1("S003", "민수", "Computer"),
			    new Student1("S002", "철수", "Physics"),
			    new Student1("S005", "지영", "Biology"),
			    new Student1("S004", "준호", "Chemistry")
			};
		
		System.out.println("=== 정렬 전 학생 목록 ===");
		
		show(students);
		//정렬과 이진 탐색에 사용할 Comparator<Student> 객체를 람다식으로 구현. sid를 오름차순 비교. 
		Comparator<Student1> comparator = (s1, s2) -> s1.getSid().compareTo(s2.getSid());
		
		Arrays.sort(students, comparator);
		
		Student1[] targets = {
			    new Student1("S002", "철수", "Physics"),
			    new Student1("S006", "홍길동", "Law"),
			    new Student1("S004", "준호", "Chemistry")
			};
		
		System.out.println("=== 이진 탐색 결과 ===");
		
		for (Student1 target : targets) {
			int index = Arrays.binarySearch(students, target, comparator);//기준이 학번인 이유
			if (index >=0) {
				System.out.println("찾은 학생 : "+students[index]);
			} else {
				System.out.println("학번 "+ target.getSid() + "인 학생은 존재하지 않습니다.");
			}
		}
	}
	
	private static void show(Student1[]arr) {
		for (Student1 ss : arr) {
			System.out.println(ss);
		}
	}
}