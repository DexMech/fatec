package testing;

import control.ValidarData;

public class ValidarDataTest {

	public static void main(String[] args) {
		ValidarData vd = new ValidarData();
		
		System.out.println(vd.isDataInsertedValid("10/08/2020", "31/12/2030"));
		System.out.println(vd.isDataInsertedValid("01/11/2012", "21/12/2012"));
		System.out.println(vd.isDataInsertedValid("03/01/2010", "25/01/2010"));
		System.out.println(vd.isDataInsertedValid("31/12/2030", "10/08/2020"));
		System.out.println(vd.isDataInsertedValid("21/12/2012", "01/11/2012"));
		System.out.println(vd.isDataInsertedValid("25/01/2010", "03/01/2010"));
	}
}
