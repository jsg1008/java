package 자료구조2장;

import java.util.Arrays;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */

public class train_실습2_14_1객체배열정렬 {
	
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("삽입후 크기가 증가된 정렬 배열", newData);
		Arrays.sort(data);
		Arrays.sort(data, (a, b)->a.compareTo(b)); // 람다식 으로 이해하는 것도 최종 목표
		
	}
	static void showData(String msg, String []arr) {
//		System.out.print(msg + " : ");
//		for (String ss : arr) {
//			System.out.print(ss+" ");
//		}
//		System.out.println();
		System.out.println(msg + " : " + Arrays.toString(arr));
	}

	static void swap(String[]arr, int i, int j){
		String ttt = arr[i];
		arr[i]=arr[j];
		arr[j]=ttt;
	}
	
	static void sortData(String [] arr) {
		for (int i=0; i<arr.length-1; i++) {
			int min = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j].compareTo(arr[min])<0) {
					min = j;
				}
			}
			if (i != min) {
				swap(arr, i, min);
			}
		}
	}
			
	static String[] insertString(String [] arr, String newArr){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		String[] newA = new String [arr.length+1];
		int i=0;
		while (i < arr.length && arr[i].compareTo(newArr)<0) {
			newA[i] = arr[i];
			i++;
		}
		newA[i] = newArr;
		
		for (int j=i; j<arr.length; j++) {
			newA[j+1]=arr[j];
		}
		return newA;
	} 
}
