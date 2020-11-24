package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOperator {

	public static void copy(File src, File dest) throws IOException { 
		InputStream is = null; 
		OutputStream os = null; 
		try { 
			is = new FileInputStream(src); 
			os = new FileOutputStream(dest); 
			// buffer size 1K 
			byte[] buf = new byte[1024]; 
			int bytesRead; 
			while ((bytesRead = is.read(buf)) > 0) { 
				os.write(buf, 0, bytesRead); 
			} 
		} finally { 
				is.close(); os.close(); 
		} 
	}
	
}
