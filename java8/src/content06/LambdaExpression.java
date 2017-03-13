package content06;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExpression {

	// Lambda 을 이용하지 않고 String 을 출력하는 함수 생성
	Consumer<String> f1 = new Consumer<String>() {
		@Override
		public void accept(String p) {
			System.out.println(p);
		}
	};
	
	// Lambda 을 이용해 String 을 출력하는 함수 생성
	Consumer<String> f2 = (String p) -> {
		System.out.println(p);
	};
	
	// Lambda 을 이용해 String 을 출력하는 함수 생성 (중괄호 생략)
	Consumer<String> f3 = (String p) -> System.out.println(p);
	
	// Lambda 을 이용해 숫자가 짝수인지 확인하는 함수 생성
	Predicate<Integer> f4 = (Integer p) -> p % 2 == 0;
	
	// Lambda 을 이용해 숫자가 짝수인지 확인하는 함수 생성 (매개 변수 데이터 타입 생략)
	Predicate<Integer> f5 = (p) -> p % 2 == 0;
	
	// Lambda 을 이용해 숫자가 짝수인지 확인하는 함수 생성 (매개 변수 소괄호 생략)
	Predicate<Integer> f6 = p -> p % 2 == 0;
}