package ch15;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5};
		int sum = Arrays.stream(num).filter((n) -> n%2 ==1).sum();
		System.out.println(sum);
	}
}
