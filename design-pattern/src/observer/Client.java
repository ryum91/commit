package observer;

public class Client {
	private String name;
	private String message;
	private Server server;

	public Client(String name, Server server) {
		this.name = name;
		this.server = server;
	}

	public void update() {
		this.message = server.getMessage();
		System.out.println(name + " : " + message);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
