package com.example.kyo;

import java.util.Date;

import org.mockito.Mockito;

import com.example.kyo.message.definition.MessageModel;

public class Tests {

	public static void main(String[] args) {
		MessageModel model = Mockito.mock(MessageModel.class);
		model.setCreatedAt(new Date());

		Mockito.when(model.getCreatedAt()).thenReturn(new Date());
	}

//	private void printBytes() {
//		
//		String imagePath = "C:\\Users\\vvpro\\Documents\\test.jpeg";
//
//		try {
//			byte[] imageBytes = readImageBytes(imagePath);
//			System.out.println(imageBytes);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static byte[] readImageBytes(String imagePath) throws IOException {
//		File file = new File(imagePath);
//		FileInputStream fis = new FileInputStream(file);
//
//		byte[] imageBytes = new byte[(int) file.length()];
//		fis.read(imageBytes);
//		fis.close();
//
//		return imageBytes;
//	}
}
