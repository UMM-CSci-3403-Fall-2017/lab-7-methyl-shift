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
		// auto changed to final because eclipse said
		final Socket getsocket = new Socket("localhost", PORT_NUMBER);
		InputStream socketInData = getsocket.getInputStream();
		// auto changed to final because eclipse said
		final OutputStream socketOutData = getsocket.getOutputStream();
		Thread upThread = new Thread() { //Something with a thead.
			public void run() {
				int input;
				try {
					while ((input = System.in.read()) !=-1) {
						socketOutData.write(input);
					}
					socketOutData.flush();
					//Based on Peters hits.
					getsocket.shutdownOutput();
				}
				catch(IOException noGo) {
					noGo.printStackTrace();
				}
			}
		};
		upThread.start();
		Thread downThread = new Thread() {
			public void run() {
				int input;
				try {
					while((input = ))
					
				}
			}
		}
		System.out.flush();
	}
}