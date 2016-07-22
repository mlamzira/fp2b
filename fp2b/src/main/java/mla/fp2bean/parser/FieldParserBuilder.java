package mla.fp2bean.parser;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import mla.fp2bean.context.Fp2bFacade;
import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.exception.Fp2bException;

import org.apache.log4j.Logger;


public class FieldParserBuilder {
	
	private static Map<Class<?>, Parser> parsers = new HashMap<Class<?>, Parser>();
	private static Logger logger = Logger.getLogger(Fp2bFacade.class);
	
	public FieldParserBuilder() {
		IntegerParser integerParser = new IntegerParser();
		FloatParser floatParser = new FloatParser();
		DoubleParser doubleParser = new DoubleParser();
		DateParser dateParser = new DateParser();
		StringParser stringParser = new StringParser();
		
		parsers.put(int.class, integerParser);
		parsers.put(Integer.class, integerParser);
		parsers.put(float.class, floatParser);
		parsers.put(Float.class, floatParser);
		parsers.put(double.class, doubleParser);
		parsers.put(Double.class, doubleParser);
		parsers.put(Date.class, dateParser);
		parsers.put(String.class, stringParser);
		parsers.put(Map.class, new MapStringParser());
	}

	public static Parser getParser(Class<?> clazz) {
		return parsers.get(clazz);
	}

	
	public void buildParser(Fp2bFieldElement field) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Fp2bException{
		if(field.getParser()!=null && !field.getParser().equals("")){
			Class<?> parserClass = Class.forName(field.getParser());
			Parser fieldParser = (Parser) parserClass.newInstance();
			field.setFieldParser(fieldParser);
			logger.info("Explicit Parser ["+field.getParser()+"] loaded succesfully !");
		}
		 else {
			 if(parsers.containsKey(field.getClazz())){
					field.setFieldParser(parsers.get(field.getClazz()));
				}else {
					throw new Fp2bException("no parser defined for type :"+field.getType());
				}
		}
	}
	

}
