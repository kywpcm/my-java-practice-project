import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class DynamicDataMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, 
	InstantiationException, IllegalAccessException {

		System.out.println("download...");
		URL url = new URL("http://localhost:9090/DynamicData.class");
		InputStream is = url.openStream();
		
		FileOutputStream fos = new FileOutputStream(".//bin//DynamicData.class");
		int i;
		while( (i = is.read()) != -1 ) {
			fos.write(i);
			System.out.print("|");
		}
		
		fos.close();
		is.close();
		System.out.println("\n�ٿ�ε� ����");
		
		Class c = Class.forName("DynamicData");
		Object obj = c.newInstance();
		System.out.println(obj);
	}

}
