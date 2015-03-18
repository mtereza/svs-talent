public class NumberPrinter {
	
	
	public static void main(String[] args) throws Exception {
		
		int num = Integer.parseInt(args[0]);
		long interval = Long.parseLong(args[1]);
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				for (int i = 1; i < num; i++) {
					
					if (Thread.interrupted()) {
						System.out.println("I've been interrupted.");
						return;
					}
					
					System.out.println(i);
				}
				
			}
			
		});//.start();
		
		t.start();
		System.out.println("Waithing on task to finish...");
		t.join(interval);
		System.out.println("Task finished or timeout exeeded.");
		if(t.isAlive()){
			t.interrupt();
		}
		
	}
}