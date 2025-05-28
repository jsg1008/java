package 자료구조2장;

public class 최대공약수 {

	public static void main(String[] args) {
		int a=100;
		int b=50 ;
		int gcd= gcd(a, b);
		
		System.out.println("숫자 a="+ a + ", 숫자 b=" + b + ", 최대공약수="+gcd);
	}
		public static int gcd ( int a, int b) {
			
			while ( b!=0) {
				int temp = b;
				b = a % b;
				a = temp ;
			}
			return a;
		}
}
