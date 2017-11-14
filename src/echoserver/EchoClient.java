package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.DataInputStream;

public class EchoClient {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException {
		Socket socket = new Socket("localhost", PORT_NUMBER);
		InputStream socketInputStream = socket.getInputStream();
		OutputStream socketOutputStream = socket.getOutputStream();
		Thread t0 = new Thread() { //Something with a thead.
			public void run() {
				// Need a try maybe
				// also a catch
				// need to use socket.shutdownOutput(); per peters hints.
				// two threads to read up and down. fun stuff going to bed now. 
			}
		};
		System.out.flush();
	}
}