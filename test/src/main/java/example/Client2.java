package example;

public class Client2 {					
	private String host;
	
	public void setHost(String host) {
		this.host = host;		
	}
	
	public void send() {
		System.out.println("Client.send() called ..." + this.host);
	}
	
	public void connect() throws Exception {			
		System.out.println("Client.connect() called");
	}

	public void close() throws Exception {
		System.out.println("Client.close() called");
	}
}

