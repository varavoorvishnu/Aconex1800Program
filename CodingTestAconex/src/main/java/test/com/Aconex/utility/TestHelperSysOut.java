package main.java.test.com.Aconex.utility;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class TestHelperSysOut {

	 public static void captureOutput( CaptureTest captureTest ) throws Exception {
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	        System.setOut(new PrintStream(outContent));
	        System.setErr(new PrintStream(errContent));

	        captureTest.test( outContent, errContent );

	        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.out)));

	    }
	}

	