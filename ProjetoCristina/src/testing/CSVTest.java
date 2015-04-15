package testing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVTest {

	public static void main(String[] args) throws IOException {
		String file = "Documento de teste.csv";
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		bw.write("Esse");
		bw.write("; ");
		bw.write("é");
		bw.write("; ");
		bw.write("um");
		bw.write("; ");
		bw.write("documento");
		bw.write("; ");
		bw.write("de");
		bw.write("; ");
		bw.write("teste");
		bw.newLine();
		bw.write("Espero");
		bw.write("; ");
		bw.write("que");
		bw.write("; ");
		bw.write("funcione");
		bw.write("; ");
		bw.close();
	}
}
