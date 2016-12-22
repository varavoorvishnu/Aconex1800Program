package main.java.test.com.Aconex.utility;

import java.io.ByteArrayOutputStream;

public abstract class CaptureTest {
    public  abstract void test( ByteArrayOutputStream outContent, ByteArrayOutputStream errContent ) throws Exception;
}