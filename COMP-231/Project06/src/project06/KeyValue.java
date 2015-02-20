package project06;

public class KeyValue {
	
	/**
	 * @author Semih Onay
	 */
	
	public int key;
	public String value = "";
	
	public KeyValue(int key, String value){
		this.key = key;
		this.value = value;
	}
	
	public void changeValue(String value){
		this.value = value;
	}
}