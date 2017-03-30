package observer;

public class Main {
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
}
