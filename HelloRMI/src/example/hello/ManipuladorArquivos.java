package example.hello;

import java.io.*;
import java.util.*;

public class ManipuladorArquivos {
	
	
	
	public  boolean leitor(String path) throws IOException {
		int flag=0;
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				System.out.println(linha);
				flag++;
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
		if(flag!=1) {
			return true;
		}
		return false;
	}	
}
