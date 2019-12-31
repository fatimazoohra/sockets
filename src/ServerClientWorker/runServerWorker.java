package ServerClientWorker;

public class runServerWorker {
	public static void main(String[] args) {
		//Runnable serverWorker = new ServerWorker();
		//new Thread(serverWorker).run();
		
		Runnable server = new ServerWorker(3000);
		new Thread(server).start();

		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
				
	}
}
