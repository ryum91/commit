package observer;

import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<Client> clientList = new ArrayList<>();
	private String message;

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

	public String getMessage() {
		return this.message;
	}

	public void postMessage(String msg) {
        System.out.println("Server send message : " + msg);
        this.message = msg;
        
        for (Client client : clientList) {
        	client.update();
        }
	}
}