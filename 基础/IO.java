package date0710;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class IO {

	@Test
	public void FileInputStreamTest() throws IOException {
		File file=new File("D:\\io.txt");
		FileInputStream fileInputStream=new FileInputStream(file);
		byte[] b=new byte[1024];
		fileInputStream.read(b, 0, b.length);
		System.out.print(new String(b));
		fileInputStream.close();
	}
	
	@Test
	public void FileOutputStreamTest() throws IOException {
		File file=new File("D:\\io.txt");
		FileOutputStream fileOutputStream=new FileOutputStream(file,true);
		String string="込込";
		byte[] b=string.getBytes();
		fileOutputStream.write(b, 0, b.length);
		System.out.print(new String(b));
		fileOutputStream.flush();
		fileOutputStream.close();
	}
	
	@Test
	public void FileReaderTest() throws IOException {
		File file=new File("D:\\io.txt");
		FileReader fileReader=new FileReader(file);
		char[] b=new char[100];
		fileReader.read(b, 0, b.length);
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]);
		}
		fileReader.close();
	}
	
	@Test
	public void FileWriterTest() throws IOException {
		File file=new File("D:\\io.txt");
		FileWriter fileWriter=new FileWriter(file,true);
		String string="細細";
		char[] b=string.toCharArray();
		fileWriter.write(b, 0, b.length);
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]);
		}
		fileWriter.flush();
		fileWriter.close();
	}
	
	@Test
	public void BufferedReaderTest() throws IOException {
		File file=new File("D:\\io.txt");
		FileReader fileReader=new FileReader(file);
		BufferedReader bufferedReader=new BufferedReader(fileReader, 1024);
		char[] b=new char[1024];
		bufferedReader.read(b, 0, b.length);
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]);
		}
		bufferedReader.close();
		fileReader.close();
	}
	
	@Test
	public void BufferedWriterTest() throws IOException {
		File file=new File("D:\\io.txt");
		FileWriter fileWriter=new FileWriter(file,true);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter, 1024);
		String string="最最";
		char[] b=string.toCharArray();
		bufferedWriter.write(b, 0, b.length);
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]);
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		fileWriter.close();
	}

}
