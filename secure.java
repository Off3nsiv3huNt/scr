	import java.net.URL;
	import java.io.InputStream;
	import java.io.DataInputStream;
	import java.io.Reader;
	 
	import java.util.HashMap;
	 
	public class Proxy {
	 
	  public static String get(String uri) {
	    String data="";
	    InputStream stream = null ;
	    int length;
	    byte[] buf = new byte[1024];
	    try {
	      URL url = new URL(uri); 
	      stream = new DataInputStream(url.openStream());
	      while ((length = stream.read(buf)) != -1) {
	        data += new String(buf);
	        buf = new byte[1024];
	      }
	      data= data.trim();
	    }catch (Exception e) {
	      e.printStackTrace();
	    }finally {
	      try { 
	        if (stream != null) {
	          stream.close();
	       }
	      }catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	    return data;
	  }
	}
