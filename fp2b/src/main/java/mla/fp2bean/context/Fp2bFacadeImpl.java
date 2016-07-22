package mla.fp2bean.context;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mla.fp2bean.estetic.Estetic;
import mla.fp2bean.exception.Fp2bException;

import org.apache.log4j.Logger;

public class Fp2bFacadeImpl implements Fp2bFacade {
	

	
	private List<String> templates = new ArrayList<String>();
	private Map<String, Fp2bEngine<?>> engines = new HashMap<String, Fp2bEngine<?>>();
	private boolean initiated = false;
	private static Logger logger = Logger.getLogger(Fp2bContext.class);
	
	public Fp2bFacadeImpl() {

	}
	
	@SuppressWarnings({ "rawtypes" })
	public void init() throws Throwable{
		Estetic.logFP2Bean();
		logger.info("Init");
		if (!initiated) {

			try {
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

				for (String filePath : templates) {
					
					logger.info("loading xml file [" + filePath + "]");
					
					InputStream template = classLoader.getResourceAsStream(filePath);
					
					Fp2bEngine engine = Fp2bFactory.createFP2BeanEngine(template);


					if (!engines.containsKey(engine.getTemplateName()))
						engines.put(engine.getTemplateName(), engine);
					else
						throw new IllegalStateException(
								"Multiple templates have the same bean name, stick to the rules !");

					

					logger.info("fp2Beanengine for :[" + engine.getTemplateName()
							+ "] created");
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
		return templates;
	}

	public void setTemplates(List<String> templates) {
		this.templates = templates;
	}

	
	
	

}
