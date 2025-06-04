package 자료구조3장;

import java.util.Arrays;

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
		return sid + ", "+sname + ","+ dept;
	}
	
	
	
	
}

public class Train_실습3_10_객체comparator구현 {
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
		
		Arrays.sort(students[], comparator);
		
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
	private static void show(Student[]arr) {
		for (Student ss : arr) {
			System.out.println(ss);
		}
	}
	

/*
 * Comparator를 사용한 학생 정보 배열 정렬 및 이진 탐색 구현
 * 
 * 고정된 학생 배열을 Comparator를 사용해 학번(sid) 기준으로 정렬한 뒤,
 * 탐색 대상 학생 객체 배열에 대해 Arrays.binarySearch()를 사용하여 
 * 해당 학번을 가진 학생이 존재하는지 판단하는 프로그램을 작성하시오.
 * 
 * 구현 조건


정렬과 이진 탐색에 사용할 Comparator<Student> 객체를 람다식 또는 

기준: sid 오름차순


위 배열을 Arrays.sort(배열, comparator)로 정렬한다.

다음 탐색 대상 배열을 정의하고, 확장형 for문으로 각 항목에 대해 Arrays.binarySearch(배열, key, comparator)로 탐색한다.


탐색 결과는 다음과 같이 출력한다:

"찾은 학생: S002, 철수, Physics"

"학번 S006인 학생은 존재하지 않습니다."

=== 정렬 전 학생 목록 ===
S001, 영희, Math
S003, 민수, Computer
S002, 철수, Physics
S005, 지영, Biology
S004, 준호, Chemistry

=== 이진 탐색 결과 ===
찾은 학생: S002, 철수, Physics
학번 S006인 학생은 존재하지 않습니다.
찾은 학생: S004, 준호, Chemistry

 * 
 */
}
