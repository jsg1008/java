//스트링 부트에서 사용
package ch14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test14 {
	public static void main(String[] args) {
		//Function
		Function<String, Integer> func = (s) -> {
			int cnt = 0;
			String[] word = s.split(" ");
			cnt = word.length;
			return cnt;
		};
		
		//Function
		int wordCnt = func.apply("고개를 들어 별들을 보라 당신 발만 내다 보지말고"); //Function은 String타입 인자를 받아 처리한 후 Integer 타입의 값으로 반환한다
		System.out.println("단어 수 : " + wordCnt); // 여기서는 문장을 받아서 공백을 기준으로 쪼개고 word 배열에 저장한 다음, 배열의 길이를 cnt(값은 8)에 반환한다 
		
		
		//Predicate
		Predicate<Integer> func2 = (n) -> n % 2 == 0;
		if (func2.test(123)) // 123은 홀수 이므로 predicate의 결과값인 boolean값이 거짓으로 나오고 홀수입니다가 출력된다
			System.out.println("짝수입니다.");
		else
			System.out.println("홀수입니다.");
		
		//Consumer. 자바의 함수형 인터페이스
		//d라는 매겨변수를 받아서 {} 안을 실행한다 d는 date의 객체를 의미
		//SimpleDateFormat.format 함수는 d를 받아서 특정한 형식의 문자열로 반환시켜준다
		//이것을 수행하면 현재 날짜를 특정한 형식으로 반환하여 준다 
		Consumer<Date> date = (d) -> {
			String s = new SimpleDateFormat("YY-MM-dd").format(d);
			System.out.println(s);
		};

		date.accept(new Date());
		
		//Supplier
		Supplier<String> day = () -> new SimpleDateFormat("E요일").format(new Date());
		String result = day.get();
		System.out.println(result);
	}
}