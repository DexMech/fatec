package control;

public class ValidarData {

	public boolean isDataInsertedValid(String data_1, String data_2){
		char[] firstData = data_1.toCharArray();
		char[] secondData = data_2.toCharArray();
		boolean validation = false;
		int[] valueOne = new int [3];
		int[] valueTwo = new int [3];
		
		data_1 = data_2 = "";
		
		for (int i = 0; i < 2; i ++){
			data_1 += firstData[i];
			data_2 += secondData[i];
		}
		
		valueOne[0] = Integer.parseInt(data_1);
		valueTwo[0] = Integer.parseInt(data_2);
		
		data_1 = data_2 = "";
		
		for (int i = 3; i < 5; i ++){
			data_1 += firstData[i];
			data_2 += secondData[i];
		}
		
		valueOne[1] = Integer.parseInt(data_1);
		valueTwo[1] = Integer.parseInt(data_2);
		
		data_1 = data_2 = "";
		
		for (int i = 6; i < 10; i ++){
			data_1 += firstData[i];
			data_2 += secondData[i];
		}
		
		valueOne[2] = Integer.parseInt(data_1);
		valueTwo[2] = Integer.parseInt(data_2);
		
		if ((valueOne[2] > valueTwo[2]) || 
			(valueOne[2] == valueTwo[2] && valueOne[1] > valueTwo[1]) || 
			(valueOne[2] == valueTwo[2] && valueOne[1] == valueTwo[1] && valueOne[0] > valueTwo[0]))
			validation = true;
		else
			validation = false;
		
		return validation;
	}
}