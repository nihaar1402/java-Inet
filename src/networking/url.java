package networking;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class url {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    System.out.println("Enter URL including http :");
    Scanner in=new Scanner(System.in);
    String input=in.next();
    
    URL url=new URL(input);
    System.out.println("Authority = "+url.getAuthority());
    System.out.println("File = "+url.getFile());
    System.out.println("Host = "+url.getHost());
    System.out.println("Path = "+url.getPath());
    System.out.println("Port = "+url.getPort());
    System.out.println("Protocol = "+url.getProtocol());
    System.out.println("Query = "+url.getQuery());
    System.out.println("Ref = "+url.getRef());
    System.out.println("User Info = "+url.getUserInfo());
    System.out.println("\n");
    
    InputStream is=url.openStream();
    
    int ch;
    while((ch=is.read())!=-1)
    	System.out.println((char)ch);
        is.close();
    
		
	}

}
