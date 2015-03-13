import java.util.StringTokenizer;


public class DateParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String birthday = "12/04/2007";
		
		StringTokenizer str = new StringTokenizer(birthday, "/");
		String day = str.nextToken();
		String month = str.nextToken();
		String year = str.nextToken();
		System.out.println("Day: " + day);
		System.out.println("Month: " + month);
		System.out.println("Year: " + year);
		
	}

}
