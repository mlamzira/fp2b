package mla.fp2bean.descriptor;

import javax.xml.bind.annotation.XmlAttribute;


public class Fp2bReplace {
	private String oldChar;
	private String newChar;
	private When when=When.all;
	
	@XmlAttribute(required=true)
	public String getOldChar() {
		return oldChar;
	}
	public void setOldChar(String oldChar) {
		this.oldChar = oldChar;
	}
	
	@XmlAttribute(required=true)
	public String getNewChar() {
		return newChar;
	}
	public void setNewChar(String newChar) {
		this.newChar = newChar;
	}
	
	@XmlAttribute()
	public When getWhen() {
		return when;
	}
	public void setWhen(When when) {
		this.when = when;
	}
	public char getOld(){
		return oldChar.charAt(0);
	}
	
	public char getNew(){
		return newChar.charAt(0);
	}

}
