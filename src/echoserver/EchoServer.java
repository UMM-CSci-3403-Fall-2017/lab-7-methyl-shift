package echoserver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {
		EchoServer server = new EchoServer();
		server.start();
	}

	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		//  Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available, and uses the provided ThreadFactory to create new threads when needed.
		ExecutorService pools = new Executors.newCachedThreadPool() ;
		
		while (true) {
			// Needs sockets from the CachedPool.
			Socket impactSocket = serverSocket.accept();
			//need to point to an Runnalbe thing...
			}
		}
	
	
	//Looks like implements Runnable is a possible route. Needs a run, and each run will
	//be its own thread. So while loop needs to changed in start, and most over into the 
	//new class.

//Socket socket = serverSocket.accept();
//InputStream inputStream = socket.getInputStream();
//OutputStream outputStream = socket.getOutputStream();
//int b;
//while ((b = inputStream.read()) != -1) {
//	outputStream.write(b);
//}
}