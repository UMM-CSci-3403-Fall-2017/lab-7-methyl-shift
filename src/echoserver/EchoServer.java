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
		ExecutorService pools = Executors.newCachedThreadPool();
		
		while (true) {
			// Needs sockets from the CachedPool.
			Socket impactSocket = serverSocket.accept();
			ThreadRipper thread = new ThreadRipper(impactSocket);
			pools.submit(thread);
			}
		}
	private class ThreadRipper implements Runnable{
		private Socket socket;
		public ThreadRipper(Socket socket) {
			this.socket = socket;
		}
		@Override
		//Eclipse added after Runnable was added into class.
		public void run() {
			try {
				InputStream inStream = socket.getInputStream();
				OutputStream outStream = socket.getOutputStream();
				int holder;
				while((holder = inStream.read()) != -1) {
					outStream.write(holder);
				}
				outStream.flush();
				socket.close();
			}
			catch(IOException noGo) {
				noGo.printStackTrace();
			}
		}
	}

}