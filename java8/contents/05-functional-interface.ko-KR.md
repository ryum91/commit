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

## Java8 Functional Interface
Functional Programming 에서 함수는 각양각색으로 다양하게 존재한다.  
반환 타입이 없는 그냥 단순히 어떤 동작을 수행하는 함수,  
특정 매개 변수를 전달받고, 동작을 수행 후 값을 반환하는 함수...등등  
이렇게 무수히 다양한 함수들이 존재할 수 있다.

그렇다면 Java에서의 Functional Programming은 Functional Interface 라는 Annotation이 붙은  
특수한 인터페이스를 이용해 해당 객체를 '함수'로 사용한다고 했었다.  
그럼 원하는 함수를 만들고자 할 땐 무조건 Functional Interface 가 붙은 인터페이스를 매번 만들어야 하는걸까??

답은 꼭 그렇지만은 않다.  
Java8에 새롭게 추가 된 것은 Annotation 뿐만 아니라,  
각종 함수들을 정의할 수 있는 다양한 Functional Interface가  
java.util.function 패키지 하위에 많이 추가되었다. [(API)](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)

이는 앞서말한 함수를 정의할 때 사용할 수 있는 유틸성 인터페이스이며,  
거의 모든 인터페이스가 Generic으로 설계되어 개발자 마음대로 얼마든지 커스터 마이징이 가능하다. 

간단하게 몇 가지만 살펴보고 넘어가자.  
(자세한 내용은 API나, 다른 사이트 참조)

**Function**  
```java
@FunctionalInterface
public interface Function<T,R> {
	R apply(T t);
}
```
Function 인터페이스는 한 개의 매개 변수를 전달받고, 특정 값을 반환하는 형태이다.  
딱 기초적인 함수의 형태이다.

**Predicate**  
```java
@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}
```
Predicate 인터페이스는 한 개의 매개 변수를 전달받고, boolean 값을 반환하는 형태이다.  
매개 변수에 대해 단순히 참/거짓 을 판별할 때 사용된다. 

**Supplier**  
```java
@FunctionalInterface
public interface Supplier<T> {
	T get();
}
```
Supplier 인터페이스는 매개 변수를 전달받지 않고, 하나의 값을 반환 하는 형태이다.  
특정 외부의 조건에 의해 하나의 값을 반환할 때 사용된다.

**Consumer**
```java
@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}
```
Consumer 인터페이스는 한 개의 매개 변수를 전달받고, 반환 형식이 없는 형태이다.  
함수 내에서 반환 값 없이 동작만 할 때 사용된다.