# Decorator Pattern

## 정의
Decorator 이름 그대로 객체를 장식하는 디자인 패턴이다.
**원래 클래스의 코드는 전혀 바꾸지 않고도 객체에 새로운 기능을 부여**한다는 점이 큰 특징이다.

## 예제 #1

`Cookie` 라는 인터페이스를 사용하여 쿠키를 만들고자 한다.

[![Cookie.java](../../image/source-icon.png) Cookie.java](../src/decorator/Cookie.java)
```java
public interface Cookie {
	String getName();
}
```

[![Main.java](../../image/source-icon.png) Main.java](../src/decorator/Main.java)
```java
Cookie cookie = new Cookie() {
	@Override
	public String getName() {
		return "쿠키";
	}
};
```

여기서 만약 해당 쿠키에 특정 토핑을 추가하고자한다.
하지만 기존에 만들었던 쿠키 객체는 그대로 사용하되, 토핑만을 추가하고자 한다면,

그럴때 별도의 Decorator Class 를 선언하여 이용하는 것이다.

여기서 사용되는 Decorator Class 는 `Topping` 이라는 추상 클래스이며,
해당 Decorator Class 을 구현하여 여러가지 Decorator 를 만들 수 있다.

또한 Decorator Class 는 그 자체가 꾸미고자 하는 객체와 동일한 타입이여야 한다.
즉, 여기서 Topping 이라는 Decorator Class 는 곧 Cookie 와 동일한 타입이어야 하고,
아까 선언한 `Cookie` 라는 인터페이스를 구현하여 선언한다.

[![Topping.java](../../image/source-icon.png) Topping.java](../src/decorator/Topping.java)
```java
public abstract class Topping implements Cookie {
	protected Cookie cookie;
	
	public Topping(Cookie cookie) {
		this.cookie = cookie;
	}
}
```

토핑은 우유 토핑과, 초콜렛 토핑 두가지가 존재한다고 할 때 생성한 Decorator Class 이다.

[![MilkTopping.java](../../image/source-icon.png) MilkTopping.java](../src/decorator/MilkTopping.java)
```java
public class MilkTopping extends Topping {

	public MilkTopping(Cookie cookie) {
		super(cookie);
	}

	@Override
	public String getName() {
		return "우유 + " + cookie.getName();
	}

}
```

[![ChocolateTopping.java](../../image/source-icon.png) ChocolateTopping.java](../src/decorator/ChocolateTopping.java)
```java
public class ChocolateTopping extends Topping {

	public ChocolateTopping(Cookie cookie) {
		super(cookie);
	}

	@Override
	public String getName() {
		return "초콜렛 + " + cookie.getName();
	}

}
```

이렇게 생성한 두 개의 Decorator Class 을 아까 만든 쿠키 객체를 이용해 토핑을 추가해보자.

[![Main.java](../../image/source-icon.png) Main.java](../src/decorator/Main.java)
```java
cookie = new MilkTopping(cookie);
System.out.println(cookie.getName());	// 우유 + 쿠키

cookie = new ChocolateTopping(cookie);
System.out.println(cookie.getName());	// 초콜렛 + 우유 + 쿠키
```

이런식으로 Decorator Class 을 선언하여 기존의 객체는 유지하되, 새로운 기능들과 새로운 무언가를 추가하는 것이 Decorator Pattern 이다.

## 예제 #2
이러한 Decorator Pattern 은 기본 Java API 에서도 사용된다.

대표적으로 I/O 클래스에서 사용되어진다.

```java
BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")));
```

이런식으로 제일 안쪽에 File 객체를 하나 생성 후, 해당 File 객체 그대로 사용하면서 FileReader 클래스를 사용하고,
BufferedReader 클래스를 이용해 한번 더 Decorator 를 수행하는 것이다.

이렇게 처음 생성한 객체 그대로 유지하면서, Decorator 를 수행하면서 점점 기능을 확장하고자 할 때 사용하면 된다.

## 장점
* 일반 Class 와 Decorator Class 는 서로 연관이 없으므로 서로간의 결합도가 낮아지게 된다.  
따라서 유지보수에도 편하다.
* 변경을 하면 안되거나, 못하는 Class 에도 본인이 원하는 기능을 추가할 수 있다.

## 단점
* Decorator Pattern 을 사용하게되면 자잘한 클래스들이 생성되게 된다.  
따라서 코드가 필요 이상으로 복잡해 질 수 있다.