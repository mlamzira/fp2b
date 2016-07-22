package mla.fp2bean.descriptor;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

import mla.fp2bean.accessor.GetterAccessor;
import mla.fp2bean.accessor.SetterAccessor;
import mla.fp2bean.exception.Fp2bException;
import mla.fp2bean.parser.Parser;

public class Fp2bFieldElement{
	
	private Fp2bRootElement parent;
	private String type;
	private String name;
	private int length;
	private String datePattern;

	private Class<?> clazz;
	private String defaultValue;
	private boolean hardCoded;
	private String prefix;
	private String suffix;
	private boolean blanck;
	private boolean required = false;
	
	private Parser fieldParser;
	private String parser;
	
	private GetterAccessor getter;
	private SetterAccessor setter;

	private List<Fp2bReplace> replacements = new ArrayList<Fp2bReplace>();

	public void init() throws SecurityException, ClassNotFoundException {

		if (type.equals("int")) {
			clazz = int.class;
		} else if (type.equals("float")) {
			clazz = float.class;
		} else if (type.equals("double")) {
			clazz = double.class;
		} else {
			clazz = Class.forName(type);
		}
	}

	@XmlElementWrapper(name = "replacements")
	@XmlElement(name = "replace")
	public List<Fp2bReplace> getReplacements() {
		return replacements;
	}

	public void setReplacements(List<Fp2bReplace> replacements) {
		this.replacements = replacements;
	}

	@XmlAttribute(required = true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlAttribute(required = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(required = true)
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Class<?> getClazz() {
		return clazz;
	}
	
	

	@XmlAttribute(required = false)
	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	@XmlAttribute
	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@XmlAttribute
	public boolean isHardCoded() {
		return hardCoded;
	}

	public void setHardCoded(boolean hardCoded) {
		this.hardCoded = hardCoded;
	}

	@XmlAttribute
	public String getPrefix() {
		return prefix == null ? "" : prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@XmlAttribute
	public String getSuffix() {
		return suffix == null ? "" : suffix;
	}

	public void setSuffix(String sufix) {
		this.suffix = sufix;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	@XmlAttribute
	public boolean isBlanck() {
		return blanck;
	}

	public void setBlanck(boolean blanck) {
		this.blanck = blanck;
	}

	@XmlAttribute
	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public void setFieldParser(Parser fieldParser) {
		this.fieldParser = fieldParser;
	}
	

	@XmlAttribute
	public String getParser() {
		return parser;
	}

	public void setParser(String parser) {
		this.parser = parser;
	}



	public void setGetter(GetterAccessor getter) {
		this.getter = getter;
	}


	public void setSetter(SetterAccessor setter) {
		this.setter = setter;
	}

	@XmlTransient
	public Fp2bRootElement getParent() {
		return parent;
	}


	public void setParent(Fp2bRootElement parent) {
		this.parent = parent;
	}
	
	public Object invokeGetter(Object host) throws Fp2bException{
		
		try {
			return getter.invoke(host);
		} catch (Exception e) {
			
			throw new Fp2bException(e);
		}
	}
	
	public void invokeSetter(Object host,Object value) throws Fp2bException {
		
		try {
			setter.invoke(host, value);
		}  catch (Exception e) {
			
			throw new Fp2bException(e);
		}
	}

	public String serializeObject(Object obj) throws Fp2bException {
		
		return fieldParser.serializeObject(this, obj);
	}

	public Object parseString(String token) throws Fp2bException {
		
		return fieldParser.parseString(this, token);
	}

}
