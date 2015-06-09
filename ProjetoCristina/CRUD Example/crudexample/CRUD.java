package crudexample;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CRUD {
	
	private final String fileName = "src/files/ArquivoTeste1.txt";
	private final String fileTest = "src/files/ArquivoTeste2.txt";

	public void create(String name, String add, String tel) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
		
		bw.write(name);
		bw.newLine();
		bw.write(tel);
		bw.newLine();
		bw.write(add);
		bw.newLine();
		
		bw.close();
	}
	
	public void read() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		int cta = numberOfLines(fileName);
		
		for (int i = 0; i < cta; i ++)
			System.out.println(br.readLine());
		
		br.close();
	}
	
	public void update(String oldContent, String newContent) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileTest));
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		int cta = numberOfLines(fileName);
		String temporary = null;
		
		for (int i = 0; i < cta; i ++){
			temporary = br.readLine();
			
			if (temporary.equals(oldContent)){
				bw.write(newContent);
				bw.newLine();
			} else {
				bw.write(temporary);
				bw.newLine();
			}
			
			temporary = null;
		}

		br.close();
		bw.close();
		
		merging();
	}
	
	public void delete(String deletedContent) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileTest));
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		int cta = numberOfLines(fileName);
		String temporary = null;
		
		for (int i = 0; i < cta; i ++){
			temporary = br.readLine();
			
			if (!temporary.equals(deletedContent)){
				bw.write(temporary);
				bw.newLine();
			}
			
			temporary = null;
		}

		br.close();
		bw.close();
		
		merging();
	}
	
	public void merging() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		BufferedReader br = new BufferedReader(new FileReader(fileTest));
		int cta = numberOfLines(fileTest);
		String temporary = null;
		
		for (int i = 0; i < cta; i ++){
			temporary = br.readLine();
			bw.write(temporary);
			bw.newLine();
			temporary = null;
		}
		
		bw.close();
		br.close();
		
		deleteTestFile();
	}
	
	public void deleteTestFile(){
		File f = new File(fileTest);
		
		f.delete();
	}
	
	public int numberOfLines(String file) throws IOException{
		BufferedReader lineReader = new BufferedReader(new FileReader(file));
		int lines = 0;
		
		while (lineReader.ready()){
			lineReader.readLine();
			lines ++;
		}
		
		lineReader.close();
		
		return lines;
	}
}
