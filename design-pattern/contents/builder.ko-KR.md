# Builder Pattern

Java 에서 객체를 만드는 방법은 `new` 키워드를 이용해서 만든다. 이때 사용되는 문법은 생성자(Constructor)를 호출하여 생성하는 것이다.
그러나 하나의 클래스에 멤버 변수가 엄청나게 많을 경우, 그만큼 여러개의 생성자가 존재할 수 있으며 또한 객체를 생성할 때 코드가 더러워 질 수 밖에 없다.

```java
public class Person {
	private String name;
	private int age;
	private String favoriteColor;
	private String favoriteAnimal;
	private int favoriteNumber;
	
	public Person(String name, int age){
		...
	}

	public Person(String name, int age, String favoriteColor, String favoriteAnimal, int favoriteNumber){
		...
	}

	// getter, setter ...
}
```

이런 경우 사용할 수 있는 디자인 패턴이 바로 Builder Pattern 이다. Builder Pattern 은 객체의 생성을 전담하고, 불필요한 생성자의 선언을 막아준다.

Builder Pattern 의 사용 방법은 Builder Pattern을 적용할 대상 클래스 내에 내장 클래스를 하나 선언해 준다. 그 클래스가 바로 `Builder 클래스` 이다.
또한 대상 클래스의 생성자는 `private` 으로 선언하며, 생성자 매개변수에는 오로지 `Builder 클래스` 하나만 입력받게 선언한다.

```java
public class Person {
	private Person(PersonBuilder builder) {
	
	}

	...
	
	public static class PersonBuilder {
	
	}
}

```

Builder 클래스 내에서는 대상 클래스의 매개변수와 동일하게 선언 후 Setter 메소드만 선언한다.
그러나 일반적인 Setter 메소드가 아닌, 반환 타입이 Builder 클래스 자기 자신인 Setter 메소드를 선언하는 것이다.

```java
public static class PersonBuilder {
	private String name;
	private int age;
	private String favoriteColor;
	private String favoriteAnimal;
	private int favoriteNumber;
	
	public PersonBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public PersonBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	
	...
}
```

이렇게 Builder 클래스의 선언을 모두 하였으면 대상 클래스의 생성자를 수정해야 한다.
대상 클래스의 생성자는 Builder 클래스에 존재하는 매개 변수를 그대로 자기 자신에게 매핑 하는 작업을 한다.

```java
public class Person {
	public Person(PersonBuilder builder) {
		this.name = builder.name;
		this.age = builder.age;
		...
	}
}
```

마지막으로 Builder 클래스에 build 라는 메소드를 선언한다. 이 메소드는 Builder 클래스를 이용해 대상 클래스를 최종적으로 생성하는 메소드이다.
따라서 메소드의 반환 타입은 대상 클래스가 된다.

```java
public static class PersonBuilder {
	...
	public Person build() {
		return new Person(this);
	}
}
```