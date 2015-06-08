package control;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			ListaCeps lc = new ListaCeps();
			lc.calculoDistancias();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}