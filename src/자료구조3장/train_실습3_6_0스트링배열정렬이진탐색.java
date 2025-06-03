package 자료구조3장;

/*
 * 3장 2번 실습과제 - 스트링 배열의 정렬과 이진검색 
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
public class train_실습3_6_0스트링배열정렬이진탐색 {
	
	static void showData(String msg, String []arr) {
		System.out.println(msg + " : ");
		for (String ss : arr) {
			System.out.print(ss+" ");
		}
		System.out.println();
	}
	
	static void sortData(String [] arr) {
		for (int i=0; i<arr.length-1; i++) {
			int min = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j].compareTo(arr[min])<0) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
	}
	static void swap(String[]arr, int i, int j){
		String ttt = arr[i];
		arr[i]=arr[j];
		arr[j]=ttt;
	}
	
	static int linearSearch(String [] arr, String key) {
		for (int i=0; i<arr.length; i++) {
			if (arr[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	static int binarySearch(String [] arr, String key) {
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			int mid = (low + high)/2;
			int cmp = key.compareTo(arr[mid]);
			
			if (cmp==0) {
				return mid;
			} else if (cmp<0) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return -1;
	}
	

	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};
		showData("정렬전", data);
		sortData(data);//올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
		showData("정렬후", data);

		String key = "포도";
		key.compareTo(key);
		int resultIndex = linearSearch(data, key);//교재 100 페이지 seqSearch() 함수로 구현
		System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);

		key = "배";
		resultIndex = binarySearch(data, key);//교재 109 페이지 binSearch() 함수로 구현
		System.out.println("\nbinarySearch(배):key = " + key + ",  result = " + resultIndex);
		key = "산딸기";
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 * public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
		 *     @Override
		 *     public int compareTo(String anotherString) {
		 *             return this.compareTo(anotherString);
		 *     }
		 *	}
		 *
		 *  binarySearch(String[], String key)를 호출하면, 
		 *  내부적으로 String 배열이 자동으로 Comparable<String>[]로 해석.
		 */
		resultIndex = Arrays.binarySearch(data, key);//교재 120 페이지 API 참조
		//교재 116 표 3-3: static int binarySearch(Object[] a, Object key)가 사용됨 - 단 배열 a는 Comparable을 구현한 객체들로 정렬되어 있어야 함
		
		System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
	}
}
