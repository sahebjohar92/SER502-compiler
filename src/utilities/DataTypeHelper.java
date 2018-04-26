package utilities;

public class DataTypeHelper {

	public static String convertBooleanToString(boolean bool)
	{
		if(bool){
			return "T";
		}else{
			return "F";
		}
	}

	public static boolean convertStringToBoolean(String input){
		if(input.equals("T")){
			return true;
		}
		return false;	
	}
}

