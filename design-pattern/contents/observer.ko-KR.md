# Observer Pattern

## 정의
Observer Pattern(옵저버 패턴)은 어떤 객체의 상태가 바뀌면 그 객체에 의존하고 있는 다른 객체들이
자동으로 내용이 갱신되는 방식으로 일대다(One-to-Many) 의존성을 관리하는 디자인 패턴이다.

옵저버 패턴은 대상이 되는 객체 하나와, 해당 대상 객체에 의존하고 있는 객체 여러개가 필요하다.
여기서는 대상이 되는 객체를 서버(Server)라 하고, 대상 객체에 의존하고 있는 객체를 클라이언트(Client)라 한다.

## 예제
***서버(Server)에서는 메세지(Message)를 관리하고있다. 그리고 클라이언트(Client)들은 서버의 메세지가 변경되면 모두 동시에 반영이 되어야한다.***

### 기초 클래스 설계
먼저 서버 클래스는 자신의 메세지를 클라이언트에게 전달해주어야 하기 때문에 메세지를 변수로 가지고 있다.
```java
public class Server {
	private String message;
}
```

클라이언트 또한 서버의 메세지를 전달받기 위해 동일하게 메세지를 변수로 가지고 있다.
그리고 클라이언트는 여러 개가 존재할 수 있으므로 별도의 이름을 가지고있다.
```java
public class Client {
	private String name;
	private String message;
}
```

### Server와 Client간의 통신 준비
서버 클래스는 여러개의 클라이언트를 관리할 수 있다. 따라서 서버 클래스에는 자신이 관리하고 있는 클라이언트를 리스트로 가지고있다.
```java
public class Server {
	private String message;
	private List<Client> clientList = new ArrayList<>();
}
```

클라이언트 클래스는 자신이 속한 서버를 가지고있다.
```java
public class Client {
	private String name;
	private String message;
	private Server server;
}
```

그리고 서버 클래스에는 클라이언트를 등록&해제를 할 수 있는 메소드가 필요하다.
그 이유는 서버 클래스에 클라이언트를 등록을 해야 서버 클래스에서 클라이언트와 통신이 가능하고,
불필요할때는 서버 클래스에서 제거를 해야하기 때문이다.

간단하게 clientList에 add와, remove 메소드를 이용하면 된다.
```java
public class Server {
	/**
	 * 새로운 Client를 Server에 등록
	 */
	public void register(Client client) {
		clientList.add(client);
	}

	/**
	 * Client를 Server에서 제거
	 */
	public void unregister(Client obj) {
		clientList.remove(obj);
	}
}
```

클라이언트 클래스에는 서버 클래스가 필수 요소이다. 따라서 클라이언트 클래스에는 별도 메소드말고
생성자에서 서버 객체를 받아 초기화를 하겠다.
```java
public class Client {
	public Client(Server server) {
		this.server = server;
	}
}
```

### Server와 Client간의 통신
앞서 서버와 클라이언트간의 통신 준비는 끝났다. 실제 통신을 하는 코드를 작성해보자.

먼저 클라이언트에서 서버의 메세지를 가져오는 메소드를 추가해야한다.
이 메소드는 서버의 메세지를 받아 업데이트 한다는 의미로 `update` 라고 메소드를 작성하자.
또한 받아온 메세지를 출력까지 한다.
```java
public class Client {
	public void update() {
		this.message = this.server.getMessage();
		System.out.println(name + " : " + message);
	}
}
```

이제 서버에서는 메세지가 업데이트되면, 자신이 보유하고 있는 클라이언트 리스트의 `update` 메소드를 호출하기만 하면된다.
```java
public class Server {
	public void postMessage(String msg) {
        System.out.println("Server send message : " + msg);
        this.message = msg;
        
        for (Client client : clientList) {
        	client.update();
        }
	}
}
```

이것이 옵저버 패턴의 핵심 로직이다.

### 사용 예제
이것을 사용하는 예제 소스를 만들어 확인해보자.
```java
public static void main(String[] args) {
	Server server = new Server();

	Client client1 = new Client("client1", server);
	Client client2 = new Client("client2", server);
	Client client3 = new Client("client3", server);

	server.register(client1);
	server.register(client2);
	server.register(client3);

	server.postMessage("First Message");
	
	server.postMessage("Second Message");
}
```

출력
```
Server send message : First Message
client1 : First Message
client2 : First Message
client3 : First Message
Server send message : Second Message
client1 : Second Message
client2 : Second Message
client3 : Second Message
```