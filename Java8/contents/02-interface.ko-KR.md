# Interface in java8

## 변경 된 이유
앞으로 소개 할 Java8에서의 interface는 많이 변경되었다.  
변경된 이유를 보면 기존에 사용되고 있던 interface에 대해 큰 문제가 있거나, 불편한 점이 있어서 변경된 것은 아니다.  
하지만 자바의 고질적인 문제 중 하나가 **'다중 상속'**이 안된다는 점이 예전부터 큰 문제로 여겨졌다.  
자바의 아버지라 불리는 [James Gosling](https://ko.wikipedia.org/wiki/%EC%A0%9C%EC%9E%84%EC%8A%A4_%EA%B3%A0%EC%8A%AC%EB%A7%81) 인터뷰에서도  
'자바를 다시 만들면 바꾸고 싶은 점은?' 이라는 질문에 대해 '클래스 상속을 없애버리고 싶다' 라고 답변했다.  
이는 기존 클래스 상속에 대해 많은 문제가 있으며, 불편하다는 것을 의미한다.  
그러한 점을 Java8에서는 다중 구현이 가능한 interface를 변형하여 클래스 상속의 불편했던 점을 많이 해결했다.

## Static Area
이제 인터페이스에 Static Area(정적 영역)이 추가되었다.  
따라서 인터페이스 내부에 정적 변수와, 정적 메소드를 추가할 수 있게 되었다.  
단, Static Initialize는 선언할 수 없다.
```java
public interface InterfaceTest {

	static final int STATIC_VARIABLE = 100;
	
	static void staticMethod () {
		System.out.println("InterfaceTest : Static Method");
	}
}
```
인터페이스에서의 정적 변수와, 정적 메소드는 약간의 차이점이 존재한다.  
해당 인터페이스를 구현한 클래스에서 정적 변수와, 정적 메소드를 사용하고자 할 때  
정적 변수 같은 경우 직접 접근이 가능하지만,  
정적 메소드 같은 경우 해당 인터페이스를 구현했다 하더라도, 인터페이스명을 통해서만 접근이 가능하다.  
그 이유는 [Oracle Release Note](http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.8)에 나와있다.
> A class does not inherit static methods from its superinterfaces.  
> (클래스는 상위 인터페이스의 정적 메소드를 상속받지 않습니다.)