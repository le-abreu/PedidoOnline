package br.com.empresa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ControllerArquivo {

	public static void guardarArquivo(InputStream arquivoUpdate, String path,
			String nomeArquivo) {
		try {
			File file = new File(path);
			file.mkdirs();
			file = new File(path + nomeArquivo);
			file.createNewFile();
			OutputStream out = new FileOutputStream(file);
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = arquivoUpdate.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			arquivoUpdate.close();
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static InputStream getArquivo(String string) {
		File file = new File(string);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			file.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileInputStream;
	}

	public static void apagarArquivosPasta(File f) {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				file.delete();
			}
			f.delete();
		}
	}
}
