package mla.fp2bean.context;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import mla.fp2bean.descriptor.Fp2bRootElement;
import mla.fp2bean.exception.Fp2bException;


public class Fp2bContext {
	
	private static Fp2bFacade facade;
	private static boolean loaded = false;
	private static Unmarshaller jaxbUnmarshaller;
	
	private static final String W3C_XMLSCHEMA= "http://www.w3.org/2001/XMLSchema";
	private static final String XSD_SCHEMA = "fp2bean-schema.xsd";
	
	static {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(W3C_XMLSCHEMA);
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		Schema schema;
		try {
			schema = schemaFactory.newSchema(classLoader.getResource(XSD_SCHEMA));
			JAXBContext jaxbContext = JAXBContext.newInstance(Fp2bRootElement.class);
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.setSchema(schema);
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		
	}

	/**
	 * Should be called only once when the context is being loaded
	 * @param facade
	 * @throws Fp2bException 
	 */
	static void setFacade(Fp2bFacade facade) throws Fp2bException {
		if(!loaded){
			Fp2bContext.facade = facade;
			loaded = true;
		} else {
			throw new Fp2bException("Context has already bean loaded, this method should be called only once");
		}
		
	}
	
	public static <T> Fp2bEngine<T> getEngine(Class<T> cls,String name) throws Fp2bException {
		if(loaded)
			return facade.getEngine(cls, name);
		else
			throw new Fp2bException("Context is null");
	}
	
	static Unmarshaller getJaxbUnmarshaller(){
		return jaxbUnmarshaller;
	}
	

}
