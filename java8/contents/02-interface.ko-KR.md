# Interface in java8

## Cause
앞으로 소개 할 Java8에서의 interface는 많이 변경되었다.  
변경된 이유를 보면 기존에 사용되고 있던 interface에 대해 큰 문제가 있거나, 불편한 점이 있어서 변경된 것은 아니다.  
하지만 자바의 고질적인 문제 중 하나가 **'다중 상속'**이 안된다는 점이 예전부터 큰 문제로 여겨졌다.  
자바의 아버지라 불리는 [James Gosling](https://ko.wikipedia.org/wiki/%EC%A0%9C%EC%9E%84%EC%8A%A4_%EA%B3%A0%EC%8A%AC%EB%A7%81) 인터뷰에서도  
'자바를 다시 만들면 바꾸고 싶은 점은?' 이라는 질문에 대해 '클래스 상속을 없애버리고 싶다' 라고 답변했다.  
이는 기존 클래스 상속에 대해 많은 문제가 있으며, 불편하다는 것을 의미한다.  
그러한 점을 Java8에서는 다중 구현이 가능한 interface를 변형하여 클래스 상속의 불편했던 점을 많이 해결했다.

## Static Area
Java8 인터페이스에는 Static Area(정적 영역)이 추가되었다.  
따라서 인터페이스 내부에 정적 변수와, 정적 메소드를 추가할 수 있게 되었다.  
단, Static Initializer는 선언할 수 없다.  
때문에 만약 인터페이스 내에 선언된 정적 변수가 final 변수라면, 선언과 동시에 초기화가 필수이다.
```java
public interface InterfaceTest {

	static final int STATIC_VARIABLE = 100;
	
	static void staticMethod () {
		System.out.println("InterfaceTest : Static Method");
	}
}
```
그러나, 인터페이스에서의 정적 변수와, 정적 메소드는 약간의 차이점이 존재한다.  
[Java SE8 Language Specification](http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.8)에 따르면,  
인터페이스에 존재하는 정적 변수는 해당 인터페이스를 구현한 하위 클래스에게 상속되지만,  
정적 메소드 같은 경우에는, 하위 클래스에게 상속되지 않는다고 나와있다.  
때문에 인터페이스의 정적 메소드를 하위 클래스에서 호출하고자할때는  
외부 클래스의 정적 메소드를 호출하는 것 처럼 인터페이스명으로 호출해야 한다.
```java
public class ChildClass implements InterfaceTest {

	public static void main(String[] args) {
		System.out.println(STATIC_VARIABLE);		// 100
		
		// staticMethod();							// Complie Error
		InterfaceTest.staticMethod();				// InterfaceTest : Static Method
	}
}
```   

## Default Method
인터페이스 내에서의 새로운 메소드 선언 방식인 Default Method가 추가되었다.  
위에서 언급된 것은 정적 영역이라면, Default는 동적 영역으로  
static과는 다르게 오직 메소드만 인터페이스에 선언이 가능하다.  
```java
public interface InterfaceTest {
	
	default void defaultMethod () {
		System.out.println("InterfaceTest : Default Method");
	}
}
```
선언된 default 메소드 같은 경우 하위 클래스에서 상속을 받게된다.  
따라서 자유롭게 호출이 가능하며, Override도 가능하다.
```java
public class ChildClass implements InterfaceTest {

	public void childMethod() {
		defaultMethod();			// InterfaceTest : Default Method
	}
}
```

그러나 만약 클래스에서 구현한 상위 인터페이스가 여러개 있으며,  
각각의 인터페이스에 동일한 메소드명에, 동일한 리턴 타입, 동일한 매개 변수를 가진 Default 메소드가 똑같이 존재하면  
그때는 해당 Default 메소드는 Override가 필수로 변환된다.  
(만약 동일한 메소드명, 동일한 리턴 타입인데 매개 변수만 다를 경우 Overloading이 된다.)

추가로 하위 클래스에서 특정 인터페이스의 Default 메소드를 그대로 호출하고자 할 땐  
**[인터페이스명.super.메소드명]** 이라는 새로운 문법을 사용한다.
```java
public class ChildClass implements InterfaceTest, InterfaceTest2 {
	
	// InterfaceTest 인터페이스와, InterfaceTest2 인터페이스에
	// 동일한 void defaultMethod() 가 존재한다.
	@Override
	public void defaultMethod() {
		InterfaceTest.super.defaultMethod();	// InterfaceTest의 defaultMethod() 호출
		InterfaceTest.super.defaultMethod();	// InterfaceTest2의 defaultMethod() 호출
	}
}
```

마지막으로 억지스러운 상황이긴 하나, 인터페이스의 선언에 따라  
하위 클래스에서 Override도 안되고, Overloading도 안되는 경우가 있을 수 있다.  
구현한 인터페이스가 여러개 있으며, 각각의 인터페이스에 존재하는 Default 메소드가  
메소드명이 동일하나, 반환 타입이 다른 경우이다.  
그런 경우 Java 문법상 올바르지 않는 문법이기 때문에  
Java8 에서 그럴경우 해당 인터페이스를 implements 하려고 할 때 Compile Error를 내뱉는다.
```java
public interface InterfaceTest3 {
	// 해당 인터페이스는 기존에 만든 ChildClass 에서 implements 를 할 수 없다.
	default String defaultMethod() {
		System.out.println("InterfaceTest3 : Default Method");
		return null;
	}
}
```