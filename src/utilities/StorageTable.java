package utilities;

import java.util.HashMap;

	
class DataNode{
	String value;
	DataType type;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public DataType getType() {
		return type;
	}
	public void setType(DataType type) {
		this.type = type;
	}	
}

public class StorageTable {
	
	private HashMap<String, DataNode> storageMap = null;
	
	public StorageTable() {
		storageMap = new HashMap<>();
	}
	
	public void storeSystemValues(String identifier, String value, DataType type){
		DataNode storageNode = new DataNode();
		String modifiedValue = value;
		
		storageNode.setType(type);
		storageNode.setValue(modifiedValue);
		storageMap.put(identifier, storageNode);
	}
	
	
	public DataType getValueType(String identifier){
		if(storageMap.containsKey(identifier)){
			return storageMap.get(identifier).type;
		}
		throw new IllegalArgumentException("No Key stored");
		
	}
	
	private DataNode getdataValue(String identifier){
		if(storageMap.containsKey(identifier)){
			return storageMap.get(identifier);
		}
		throw new IllegalArgumentException("No Key stored");
		
	}
	public String getBoolValue(String identifier){
		if(isIdentifierBoolean(identifier)){
			return identifier;
		}
		DataNode storageNode = getIdentifierValue(identifier);
		if(storageNode != null && storageNode.getType() != null && storageNode.getType() == DataType.BOOLEAN && storageNode.getValue() != null){
			return storageNode.value;
		}
		throw new IllegalArgumentException("Element is declared as integer");
	}
	
	public int getIntValue(String identifier){
		//Send identifier or only integer
		if(isOnlyDigitsPresent(identifier)){
			return Integer.parseInt(identifier);
		}
		
		DataNode storageNode = getIdentifierValue(identifier);
		if(storageNode != null && storageNode.getType() != null && storageNode.getType() == DataType.INT){
			return Integer.parseInt(storageNode.getValue());
		}
		throw new IllegalArgumentException("Element is declared as boolean");
	}
	/*
	 * This method will return String if the identifier is present in storage table 
	 * or data is only digit or T or F
	 */
	public String getValue(String identifier){
		if(isOnlyDigitsPresent(identifier))
			return identifier;
		if(isIdentifierBoolean(identifier))
			return identifier;
		
		DataNode dataNode = getdataValue(identifier);
		if(dataNode.type != null)
			return dataNode.getValue();
		
		throw new IllegalArgumentException("Element not instantiated");
			
	}
	
	private boolean isIdentifierBoolean(String input){
		if(input.equals("T") || input.equals("F")){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isOnlyDigitsPresent(String input){
		if (input.matches("[0-9]+") && input.length() >= 1) {
			return true;
		}else{
			return false;	
		}
	}

	private DataNode getIdentifierValue(String identifier){
		if(storageMap.containsKey(identifier)){
			return storageMap.get(identifier) ;
		}
		throw new IllegalArgumentException("Element Not declared before");
	}
}
