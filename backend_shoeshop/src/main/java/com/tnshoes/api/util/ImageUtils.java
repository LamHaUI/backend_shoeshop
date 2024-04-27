package com.tnshoes.api.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.http.converter.ByteArrayHttpMessageConverter;

public class ImageUtils {
	
	public static byte[] compressImage(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		deflater.setInput(data);
		deflater.finish();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] tmp = new byte[4*1024];
		while (!deflater.finished()) {
			int size = deflater.deflate(tmp);
			outputStream.write(tmp, 0, size);
		}
		try {
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return outputStream.toByteArray();
	}
	
	public static byte[] decompressImage(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] tmp = new byte[4*1024];
		while (!inflater.finished()) {
			//int count = inflater.inflate(tmp);
			//outputStream.write(tmp, 0, count);
		}
		try {
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return outputStream.toByteArray();
	}
}
