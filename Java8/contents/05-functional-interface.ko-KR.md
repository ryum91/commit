# Functional Interface

## Functional Interface?
Functional Interface라고 새로운 Interface가 추가된 것은 아니다.  
새롭게 추가된 것은 @FunctionalInterface 라는 [Annotation](https://en.wikipedia.org/wiki/Java_annotation)이 java.lang 패키지에 추가되었다. [(API)](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html)  
API에 따르면 FunctionalInterface는 하나의 추상 메소드를 가질 수 있다고 나와있다.
>Conceptually, a functional interface has exactly one abstract method  
> functional interface는 정확히 단 하나의 추상 메소드를 가질 수 있다.

즉, @FunctionalInterface Annotation을 붙일 수 있는 인터페이스는 구현해야 할 추상 메소드가 하나 일 때 붙일 수 있다.  
만약 추상 메소드가 아예 없거나, 두 개 이상이면 FunctionalInterface Annotation을 붙일 수 없다.  
단, default 메소드와 static 메소드는 별개로 얼마든지 선언해도 상관없다.
```java
@FunctionalInterface
public interface FunctionalInterfaceTest {

	void call();
}
```
그렇다면 이 Functional Interface는 무슨 용도로 추가된 것일까?  
그 이유는 앞서말한 Functional Programming을 지원하기 위해 추가된 것이다.  
알다시피 기존 Java에서는 '함수' 라는 개념이 없었다.  
그러나 Functional Programming을 지원하기 위해선 '함수'라는 개념이 존재해야만 했고,  
이것을 Functional Interface 라는 특수한 인터페이스 방식을 만들어, 해당 인터페이스를 구현한 객체로 대체한 것이다.  
```java
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
```

## 기존의 인터페이스
Java8 이전에도 인터페이스인데 구현해야 할 추상 메소드가 하나인 인터페이스가 여럿 있었다.  
대표적으로 Thread 사용시 필수인 [Runnable](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html) 인터페이스가 있다.  
이렇게 기존에 추상 메소드가 하나인 인터페이스에도 Java8 부터는 FunctionalInterface Annotation이 붙었다.  
그러나 추상 메소드가 하나인 인터페이스 모두가 변경된 것은 아니다.  
해당 인터페이스를 함수로써 사용이 가능한 인터페이스만 변경되었다.  
관련해서는 다음장에서 다시 언급하겠다.

## Java8 Functional Interface
Java8에 새롭게 추가 된 것은 Annotation 뿐만 아니다.  
java.util 패키지에 function 패키지가 새롭게 추가되었으며  
해당 패키지 밑에 다양한 Functional Interface가 추가되었다. [(API)](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)

이는 Java가 본격적인 함수형 프로그래밍을 지원한다는 의미로  
사용자가 함수형 프로그래밍에 있어서 사용할 만한 유틸성 인터페이스를 제공하는 것이다. 