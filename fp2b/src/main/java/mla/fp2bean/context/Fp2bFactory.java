package mla.fp2bean.context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import mla.fp2bean.accessor.OgnlAccessorBuilder;
import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.descriptor.Fp2bRootElement;
import mla.fp2bean.estetic.Estetic;
import mla.fp2bean.exception.Fp2bException;
import mla.fp2bean.parser.FieldParserBuilder;
import mla.fp2bean.processor.Deserializer;
import mla.fp2bean.processor.Serializer;

public class Fp2bFactory<T> {

	private Fp2bFactory() {

	}

	/**
	 * Permet de créer un engin pour la serialisation et la deserialisation des
	 * fichiers plats vers des java bean ou l'inverse
	 * 
	 * @param template
	 *            Chemin vers le fichier xml 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws Fp2bException
	 * @throws FileNotFoundException 
	 **/

	public static <T> Fp2bEngine<T> createFP2BeanEngine(String template)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, Fp2bException, FileNotFoundException {

		File file = new File(template);
		return createFP2BeanEngine(file);
	}
	
	public static <T> Fp2bEngine<T> createFP2BeanEngine(InputStream template)
			throws Fp2bException {
		Estetic.logFP2Bean();
		
		try {
			
			Fp2bRootElement root = (Fp2bRootElement) Fp2bContext.getJaxbUnmarshaller().unmarshal(template);
			root.init();
			return createFP2BeanEngine(root);
		} catch (Exception e) {
			throw new Fp2bException(e);
		}
		

		
	}
	
	public static <T> Fp2bEngine<T> createFP2BeanEngine(Fp2bRootElement root) throws Fp2bException{
		
		FieldParserBuilder parserFactory = new FieldParserBuilder();
		OgnlAccessorBuilder builder = new OgnlAccessorBuilder();
		
		try {
			Object host = root.getClazz().newInstance();
			
			for (Fp2bFieldElement field : root) {
				if(!field.isHardCoded() && !field.isBlanck()){
					parserFactory.buildParser(field);
					builder.buildAccessors(field,host);
				}
				
			}

			
			Fp2bEngineImpl<T> engine = new Fp2bEngineImpl<T>(root);
			Deserializer<T> deserilizer = new Deserializer<T>();
			Serializer<T> serializer = new Serializer<T>();
			
			engine.setSerializer(serializer);
			engine.setDeserilizer(deserilizer);
			
			return engine;
		} catch (Exception e) {
			throw new Fp2bException(e);
		}
		
	}

	public static <T> Fp2bEngine<T> createFP2BeanEngine(File template)
			throws Fp2bException, FileNotFoundException {
		Estetic.logFP2Bean();
		return createFP2BeanEngine(new FileInputStream(template));
	}

}
