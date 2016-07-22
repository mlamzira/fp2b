package mla.fp2bean.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mla.fp2bean.estetic.Estetic;
import mla.fp2bean.exception.Fp2bException;

import org.apache.log4j.Logger;

public class Fp2bAnnotationFacadeImpl implements Fp2bFacade{
	
	private List<String> annotatedClasses = new ArrayList<String>();
	private Map<String, Fp2bEngine<?>> engines = new HashMap<String, Fp2bEngine<?>>();
	private boolean initiated = false;
	private static Logger logger = Logger.getLogger(Fp2bContext.class);
	
	@SuppressWarnings("unchecked")
	public <T> void init() throws Throwable{
		Estetic.logFP2Bean();
		logger.info("Init");
		if (!initiated) {

			try {
				for(String type : annotatedClasses){
					Class<T> clazz = (Class<T>) Class.forName(type);
					Fp2bEngine<T> engine = Fp2bAnnotationConfigLoader.loadConfig(clazz);
					
					if (!engines.containsKey(engine.getTemplateName()))
						engines.put(engine.getTemplateName(), engine);
					else
						throw new IllegalStateException(
								"Multiple templates have the same bean name, stick to the rules !");
				}
				
				initiated = true;
				Fp2bContext.setFacade(this);

				logger.info("Context loaded successfully ! ");
				
			} catch (Exception ex) {
				throw new Fp2bException(ex);
			}

		} else {
			throw new Fp2bException(
					new IllegalStateException(
							"init method has been already called once, stick to the rules !"));
		}
	}

	@SuppressWarnings("unchecked")
	public <T> Fp2bEngine<T> getEngine(Class<T> cls, String name) {
		return (Fp2bEngine<T>) engines.get(name);
	}

	public List<String> getTemplates() {
		return annotatedClasses;
	}

	public void setAnnotatedClasses(List<String> templates) {
		this.annotatedClasses = templates;
	}

}
