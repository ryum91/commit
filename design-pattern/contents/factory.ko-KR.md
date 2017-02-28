# Factory

## Factory Pattern

## Factory Method Pattern

## Abstract Factory Pattern

여러 종류의 객체를 생성할 때 객체들 사이의 관련성이 있는 경우라면
각 종류별로 별도의 팩토리 클래스를 사용하는 대신,
관련 객체들을 일관성 있게 생성하는 팩토리 클래스를 사용하는 것이 편리하다.

간단히 말하자면 객체를 생성할 때 구현 내용은 다르지만, 구성 요소가 같다면 
그 부분을 추상화해서 각각 필요한 것을 정의하여 사용하는 것이다.

Java 에서는 이러한 추상 팩토리 클래스를 `abstract class` 로 구현할 수 있다.

다음 예제는 자동차를 만드는 추상 팩토리 클래스를 정의 후 
현대차 클래스와, 기아차 클래스를 각각 추상 팩토리 클래스를 이용해 구현 한 것이다.

* *Car.java*
```java
public abstract class Car {
	abstract void go();
	abstract void stop();
}
```

* *HyundaiCar*
```java
public class HyundaiCar extends Car {
	void go() {
		System.out.println("Hyundai Car Go");
	}
	
	void stop() {
		System.out.println("Hyundai Car Stop");
	}
}
```

* *KiaCar*
```java
public class KiaCar extends Car {
	void go() {
		System.out.println("Kia Car Go");
	}
	
	void stop() {
		System.out.println("Kia Car Stop");
	}
}
```