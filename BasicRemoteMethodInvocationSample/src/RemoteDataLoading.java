import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;


public class RemoteDataLoading {

	public static void main(String[] args) 
			throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, 
			SecurityException, IllegalArgumentException, InvocationTargetException {
	
		String url = "http://localhost:9090/";
		Class c = DynamicLoader.loadClass(url, "RemoteData");
//		Object obj = c.newInstance();
//		System.out.println(obj);
		
		Class[] parameterType = new Class[]{String.class, String.class};
		Constructor cons = c.getConstructor(parameterType);
		
		Object[] initArgs = new Object[]{"ÀÌ½Â±â", "¼­¿ï"};
		Object obj = cons.newInstance(initArgs);
		
		System.out.println(obj);
		
		Method m = c.getMethod("sayHello", null);
		m.invoke(obj, null);
		
		String[] str = new String[] {"1", "2", "3", "4", "5"};
		
		Method m2 = c.getMethod("goodBye", null);
		m2.invoke(obj, null);
		
		Class[] parameter = new Class[]{String.class};
		Method m3 = c.getMethod("sayHello", parameter);
		m3.invoke(obj, "kywpcm");
	}

}
