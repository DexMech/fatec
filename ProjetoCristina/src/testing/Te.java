package testing;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import control.Geolocalizacao;

public class Te {

	public static void main(String[] args) {
		Geolocalizacao geo = new Geolocalizacao();
		ArrayList<String > b = new ArrayList<String>();
b.add("rua serra verde vila silvia 03821-230");
b.add("avenida doutor assis ribeiro cangaiba");
b.add("avenida agaia de haia 03694-000");
		geo.pesquisa(b);
			
	}
	

}
