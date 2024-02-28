package Scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class AI {
	private Properties pro;

	public AI(){
		File file=new File("C:\\Users\\HI\\Desktop\\lrs3_v0.4\\trainval\\00j9bKdiOjk\\00001.txt");
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
		return pro.getProperty("Text");
	}
	@Test
	public void ma() {
		System.out.println(new AI().getEmail());
	}
}
