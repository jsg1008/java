package ch15;



public class Test02 {
	public String makeStringGugudan(int dan) {
		StringBuffer sb = new StringBuffer();
		for (int j=1; j<10; j++) {
			sb.append(String.format("%d * %d = %d\n", dan, j, (dan*j)));
		}
		System.out.println();
		return sb.toString();
	}

	
	public static void main(String[] args) {
		
		Test02 test = new Test02();
		
		for (int i=2; i<10; i++) {
		System.out.print(test.makeStringGugudan(i));
		}
	}
}
