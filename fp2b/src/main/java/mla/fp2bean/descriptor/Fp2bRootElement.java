package mla.fp2bean.descriptor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import mla.fp2bean.exception.Fp2bException;

@XmlRootElement(name="bean")
public class Fp2bRootElement implements Iterable<Fp2bFieldElement>{

	private String type;
	private String name;

	private List<Fp2bFieldElement> fields = new ArrayList<Fp2bFieldElement>();

	private Class<?> clazz;

	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElementWrapper(name = "fields")
	@XmlElement(name = "field")
	public List<Fp2bFieldElement> getFields() {
		return fields;
	}

	public void setFields(List<Fp2bFieldElement> fields) {
		this.fields = fields;
	}
	
	

	public void init() throws Fp2bException {
		try {
			clazz = Class.forName(type);
			for(Fp2bFieldElement field : fields)
				field.init();
		} catch (ClassNotFoundException e) {
			
			throw new Fp2bException(e);
		}
		
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public Iterator<Fp2bFieldElement> iterator() {
		
		return fields.iterator();
	}

	public void add(Fp2bFieldElement element) {
		fields.add(element);
		
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	

}
