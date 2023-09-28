package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Initialize_Utilities {
	Properties pro;
	public Initialize_Utilities(){
		File file=new File("D:\\javanew\\Styletribute\\src\\test\\java\\Data\\EnterRequiredDetails.properties");
		try {
			FileInputStream fin = new FileInputStream(file);
			pro=new Properties();
			pro.load(fin);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	//Account details
	public String getEmail() {
		return pro.getProperty("email");
	}
	public String getPassword() {
		return pro.getProperty("password");
	}
	public String getInvalidEmailLogin() {
		return pro.getProperty("invalidemaillogin");
	}
	public String getInvalidPassword() {
		return pro.getProperty("invalidpassword");
	}
	public String getInvalidEmailSignup() {
		return pro.getProperty("invalidemailsignup");
	}
	public String getVerifyPassword() {
		return pro.getProperty("verifypassword");
	}
	public String getVerifyInvalidPassword() {
		return pro.getProperty("verifyinvalidpassword");
	}
	
	//Get shopping details
	public String getCategory() {
		return pro.getProperty("category");
	}
	public String getDiscount() {
		return pro.getProperty("discount_in_percentage");
	}
	public String getSubcatogory() {
		return pro.getProperty("sub_categories");
	}
	public String getProduct() {
		return pro.getProperty("product");
	}
}
