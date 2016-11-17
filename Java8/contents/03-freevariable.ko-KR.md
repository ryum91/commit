# Free Variable

## Free Variable?
먼저 Free Variable(프리 변수)란  
메소드 내부에서 선언된 내부 클래스(Inner Class)나, 익명 클래스(Anonymous Class)에서  
메소드 내부의 선언된 지역 변수를 사용하고자 할 때  
해당 지역 변수는 무조건 Final 변수라는 규칙을 말한다.
```java
public class FreeVariable {

	public void threadRun() {
		int temporary = 11;
		final int finalTemporary = 22;
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// System.out.println(temporary);		// Compile Error
				System.out.println(finalTemporary);		// 22
			}
		});
		thread.run();
	}
}
```

## Free Variable in Java8
하지만 Java8에서의 이 규칙은 제거되었다.  
메소드 내부에서 선언된 클래스에서도 메소드의 지역 변수를 자유롭게 사용할 수 있게 되었다.  
그러나 기존과 동일한 점은  
해당 클래스에서 프리 변수를 변경하려고 하면 컴파일 에러가 발생한다.  
>Link all references for a local rename (does not change references in other files)

즉, 메소드 내부 클래스에서의 프리 변수는 Final 변수와 동일하다는 점이다.
```java
public class FreeVariable {

	public void threadRun() {
		int temporary = 11;
		final int finalTemporary = 22;
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(temporary);			// Java7 에서는 Compile Error, Java8에서는 가능
				// temporary = 33;						// Compile Error
				System.out.println(finalTemporary);
			}
		});
		thread.run();
	}
}
```