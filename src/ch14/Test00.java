package ch14;

public class Test00 {

	public static void main(String[] args) {
	
		int suma=0;
		int sumb=0;
		for ( int i= 0; i<101; i++) {
			if ((i%2)==0) {
				suma += i ;
			} 
			else sumb += i;
		}
		System.out.println("1부터 100까지 짝수의 합은 : " + suma);
		System.out.println("1부터 100까지 홀수의 합은 : " + sumb);
	}
}
