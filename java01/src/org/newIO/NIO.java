package org.newIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO {
		
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel fic = null;
		FileChannel foc = null;
		try {
			fis = new FileInputStream("C:/movie.txt");
			fos = new FileOutputStream("c:/demo/movie.txt");
			
			//得到文件输入输出通道
			fic = fis.getChannel();
			foc = fos.getChannel();
			//缓冲区
			ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
			
			int len = -1;
			while((len = fic.read(byteBuffer))!=-1){
				//从写模式切换到读模式
				byteBuffer.flip();
				//从缓冲区中度数据
				foc.write(byteBuffer);
				//清空缓冲区
				byteBuffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
				try {
					if (foc != null) {
					foc.close();
					}
					if (fic != null) {
						fic.close();
					}if (fos != null) {
						fos.close();
					}if (fis != null) {
						fis.close();
					}
					} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
}
