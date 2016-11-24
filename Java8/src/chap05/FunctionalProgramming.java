package chap05;

public class FunctionalProgramming {

	public static void main(String[] args) {
		
		// FuncationalInterfaceTest 인터페이스를 이용하여 function 이라는 객체를 만들었다.
		// 해당 객체는 이제 '함수'로써 역할을 맡게된다.
		FuncationalInterfaceTest function = new FuncationalInterfaceTest() {
			@Override
			public void call() {
				System.out.println("function call");
			}
		};
		
		function.call();		// function call
	}
}