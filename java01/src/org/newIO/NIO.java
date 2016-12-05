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
			
			//�õ��ļ��������ͨ��
			fic = fis.getChannel();
			foc = fos.getChannel();
			//������
			ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
			
			int len = -1;
			while((len = fic.read(byteBuffer))!=-1){
				//��дģʽ�л�����ģʽ
				byteBuffer.flip();
				//�ӻ������ж�����
				foc.write(byteBuffer);
				//��ջ�����
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
