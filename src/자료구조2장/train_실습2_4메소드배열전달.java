package 자료구조2장;
/*
 * 2장: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

import java.util.Arrays;

import java.util.Random;
public class train_실습2_4메소드배열전달 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData("소스데이터",data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		int [] newdata = reverse(data);// 역순으로 출력 
		showData("역순 데이터", newdata);
		Arrays.toString(newdata);
		
	}
	
	static void showData(String msg, int [] data) {
		System.out.print(msg+" = [");
		for (int i = 0 ; i < data.length ; i++) {
			if (i == data.length-1) System.out.print(data[i]);
			else System.out.print(data[i]+", ");
		}
		System.out.print("]");
		//top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
	}
	
	static void inputData(int[]arr) {//교재 63 - 난수의 생성, top이 배열에 저장된 갯수를 저장
		Random rnd = new Random();
		for ( int i = 0; i < arr.length ; i ++) {
			arr[i] = rnd.nextInt(20);
		}
	}
	
	static int findMax(int [] rnd) {
		int max = rnd[0];
		for ( int i = 1 ; i < rnd.length ; i++ ) {
			if ((rnd[i])>max) {
				max = rnd[i];
			}
		}
		return max;
	}
	
	//찾는 수가 존재하면 true, 없으면 false
	static boolean findValue(int [] rnd, int value) {
		for ( int i = 0 ; i < rnd.length ; i++ ) {
            if (rnd[i] == value) {
            	return true;
            } 
		}return false;
	}
	
	// newdata라는 새배열을 만들어서 거꾸로 입력함
	static int [] reverse(int[] rnd) {
		int [] newdata = new int [rnd.length]; 
		 for (int i=rnd.length-1 ; i >= 0 ; i-- ) {
			 newdata[rnd.length-1-i]=rnd[i];
		 } 
		 return newdata;
	}
}
