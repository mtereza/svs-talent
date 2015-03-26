import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Stopwatch {

	private boolean running = false;
	private boolean paused = false;
	private int counter;

	private Thread sw = new Thread(){
		
		@Override
		public void run(){				
			while (running == true) {

				if (paused) {
					try {
						synchronized (this) {
							wait();
						}
					} catch (InterruptedException ex) {
					}
				}
				
				System.out.println(counter++);

				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException ex) {
				}
			}		
		}		
	};
	
	public void start() {
		if (running == false) {
			running = true;
			sw.start();
		}
	}

	public void stop() {
		running = false;
	}

	public void pause() {
		paused = true;
	}

	public void resume() {
		paused = false;
		synchronized (sw) {
			sw.notifyAll();
		}
	}

	public static void main(String[] args) throws Exception {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		final Stopwatch stopwatch = new Stopwatch();

		while (true) {
			String str = in.next();
			switch (str) {
			case "start":
				stopwatch.start();
				break;
			case "pause":
				stopwatch.pause();
				break;
			case "resume":
				stopwatch.resume();
				break;
			case "stop":
				stopwatch.stop();
				break;
			}
		}		
	}
}
