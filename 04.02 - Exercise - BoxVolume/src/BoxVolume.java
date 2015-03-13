
public class BoxVolume {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box1 = new Box();
		box1.height = 10;
		box1.weight = 10;
		box1.depth = 10;
		
		Box box2 = new Box();
		box2.height = 5;
		box2.weight = 6;
		box2.depth = 7;
		
		if (box1.calculateVolume() > box2.calculateVolume()) {
			System.out.println("Greater volume: " + box1.calculateVolume());
		} else {
			System.out.println("Greater volume: " +box2.calculateVolume());
		}

	}

}
