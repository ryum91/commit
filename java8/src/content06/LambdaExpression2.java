package content06;

import java.util.function.Consumer;

public class LambdaExpression2 {

	// 익명 클래스의 this
	Consumer<String> f1 = new Consumer<String>() {
		@Override
		public void accept(String p) {
			System.out.println(this.getClass().getName());
		}
	};
	
	// 람다식의 this
	Consumer<String> f2 = (String p) -> {
		System.out.println(this.getClass().getName());
	};
	
	// 정적 변수 람다식의 this
	static Consumer<String> f3 = (String p) -> {
		// System.out.println(this);	Compile Error
	};
	
	public static void main(String[] args) {
		LambdaExpression2 test = new LambdaExpression2();
		
		test.f1.accept(null);
		test.f2.accept(null);
	}
}
