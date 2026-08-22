package nikhil.customize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;

public class CustomizedWriter extends PrintWriter {
	
	PrintWriter out;
	public CustomizedWriter(PrintWriter out) {
		super(out);
		this.out=out;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void println(String data) {
		System.out.println("CustomizedWriter.println()");
		if (!data.startsWith("<")) {
			//reverse and print
			
			StringBuffer sb=new StringBuffer(data);
			out.println(sb.reverse());
			
		} else {
			//print the data
			out.println(data);
		}
	}
	
	
}
