public class Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int digit = 0;
		String decimal = "";
		int num = 0;

		for (int j = 0; j < args.length; j++) {
			String arg1 = args[j];
			if (args.length > 0) {
				switch (arg1) {
				case "zero":
					digit = 0;
					break;
				case "one":
					digit = 1;
					break;
				case "two":
					digit = 2;
					break;
				case "three":
					digit = 3;
					break;
				case "four":
					digit = 4;
					break;
				case "five":
					digit = 5;
					break;
				case "six":
					digit = 6;
					break;
				case "seven":
					digit = 7;
					break;
				case "eight":
					digit = 8;
					break;
				case "nine":
					digit = 9;
					break;

				}
				decimal += "" + Integer.toString(digit);			
				num = Integer.parseInt(decimal);
				
			}
		}
		System.out.println("Number is " + num);
	}
}
