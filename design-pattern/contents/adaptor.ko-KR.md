# Adaptor Pattern

어댑터 패턴이란, 특정 인터페이스를 다른 인터페이스로 변환할 때 사용된다.
다시말해, 어댑터 패턴을 이용하면 인터페이스들 간의 호환성 문제 때문에 같이 쓸 수 없는 인터페이스(클래스)들을 연결해서 쓸 수 있게 해준다.

## 예제
어떤 기계가 있다. 이 기계를 사용하고자 하려면 250볼트 소켓이 필요하다.
```java
public class Machine {

	// Constructor
	public Machine(Socket250 socket) {
		
	}
}
```

그러나 내가 가지고 있는 객체는 300볼트 소켓밖에 없다.
```java
Socket300 socket300 = new Socket300();
// Machine machine = new Machine(); 250볼트 소켓이 없기 때문에 생성할 수 없다.
```

이런 경우, 어댑터 패턴을 이용해 250볼트 소켓과, 300볼트 소켓을 연결해서 쓸 수 있게 만드는 것이다.
여기서는 300볼트 소켓을 250볼트 소켓으로 변경하기 때문에 250볼트 소켓이 **타겟 인터페이스** 이고,
300볼트 소켓이 **어댑티(Adaptee)** 라고 한다.

어댑터 패턴을 이용해 어댑터 클래스를 만드는 방법은 먼저 타겟 인터페이스를 상속 받거나, 구현을 한다.
다음으로 내부 인스턴스를 이용해 어댑티 객체를 가지고 있는 것이다.
그리고 마지막으로 타겟 인터페이스를 사용하기 위한 필수 구현을 어댑티 객체를 이용해 작성하는 것이다.
```java
public class Socket300To250 implements Socket250 {
	private Socket300 socket300;
	
	public Socket300To250(Socket300 socket300) {
		this.socket300 = socket300;
	}
}
```

그리고 원래 어댑터 클래스를 만든 목적으로 사용하는 것이다.
```java
Socket300 socket300 = new Socket300();

Socket300To250 socketAdaptor = new Socket300To250(socket300);

Machine machine = new Machine(socketAdaptor);	// 어댑터를 이용해 300볼트 소켓을 250볼트로 변환함
```

이러한 어댑터 클래스에서 하나의 어댑티만 선언될 수 있는 것은 아니다,
프로그램이 복잡해지고, 어려워지면 하나의 어댑터 클래스 안에 여러개의 어댑티가 동시에 선언될 수 도 있다.
그렇게 되면 해당 어댑터 클래스는 다양한 어댑티들을 변환시키는 만능 어댑터가 되는 것이다.