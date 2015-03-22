
public class ZipCodeWithExceptions {
	
	private String zipCode = " ";
	
	 public ZipCodeWithExceptions(String zip) throws ZipCodeException {
	        setZipCode(zip);
	    }

	
	public void setZipCode(String zip) throws ZipCodeException{
       if ((zip.length() == 5) | (zip.length() == 9)) {
           zipCode = zip;
       } else {
       	throw new ZipCodeException();
       }
   }

   public String getZipCode() {
       return zipCode;
   }

   public static void main(String[] arguments) {
		try {
			ZipCodeWithExceptions zip1 = new ZipCodeWithExceptions("");
			System.out.println("Zip Code 1: " + zip1.getZipCode());
		} catch (ZipCodeException ex) {
			// System.out.println("Error");
		}

		try {
			ZipCodeWithExceptions zip2 = new ZipCodeWithExceptions("987654321");
			System.out.println("Zip Code 2: " + zip2.getZipCode());
		} catch (ZipCodeException ex) {
			// System.out.println("Error");
		}

		try {
			ZipCodeWithExceptions zip3 = new ZipCodeWithExceptions("12345");
			System.out.println("Zip Code 3: " + zip3.getZipCode());
		} catch (ZipCodeException ex) {
			// System.out.println("Error");
		}
	   
	   
   }

}


