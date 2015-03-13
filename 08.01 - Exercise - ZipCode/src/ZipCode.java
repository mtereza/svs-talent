
public class ZipCode {
	
	private String zipCode = " ";
	
	 public ZipCode(String zip) {
	        setZipCode(zip);
	    }

	
	public void setZipCode(String zip) {
        if ((zip.length() == 5) | (zip.length() == 9)) {
            zipCode = zip;
        } else {
        	zipCode = "Error in zipCode";
        }
    }

    public String getZipCode() {
        return zipCode;
    }

    public static void main(String[] arguments) {
        ZipCode zip1 = new ZipCode("");
        ZipCode zip2 = new ZipCode("987654321");
        ZipCode zip3 = new ZipCode("12345");
        System.out.println("Zip Code 1: " + zip1.getZipCode());
        System.out.println("Zip Code 2: " + zip2.getZipCode());
        System.out.println("Zip Code 3: " + zip3.getZipCode());
    }

}
