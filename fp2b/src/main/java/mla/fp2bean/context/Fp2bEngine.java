package mla.fp2bean.context;


public interface Fp2bEngine<T> {
	
	/**
	 * Deserilize un String en entrée en un Bean
	 * @param line
	 * Ligne en entrée
	 * @return
	 * Objet de type <T>
	 */
	T deserializeLine(String line);
	
	/**
	 * Serialize un Objet de type <T> en ligne String
	 * @param t
	 * L'objet en entrée
	 * @return
	 * la ligne serialisé
	 */
	String serialize(T t);

	String getTemplateName();

	Class<?> getTemplateClass();
	
}
