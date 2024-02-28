package Scripts;

import java.io.File;
import java.io.PrintWriter;
import java.net.URL;

import com.github.axet.vget.VGet;

public class VideoDownload {
	public static void main(String[] args) {
		String download_path="D:\\javanew\\Styletribute\\youtube-dl";
		String url="https://www.youtube.com/watch?v=s34CqtrUS0A";
		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command); 
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("cd \""+download_path+"\"");
	                stdin.println(download_path+"\\youtube-dl "+url);
	                stdin.close();
	                p.waitFor();
	    	} catch (Exception e) {
	 		e.printStackTrace();
		}
		
	}	
}
