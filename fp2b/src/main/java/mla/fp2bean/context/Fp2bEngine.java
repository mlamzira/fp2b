package mla.fp2bean.context;


public interface Fp2bEngine<T> {
	
	/**
	 * Deserilize un String en entr�e en un Bean
	 * @param line
	 * Ligne en entr�e
	 * @return
	 * Objet de type <T>
	 */
	T deserializeLine(String line);
	
	/**
	 * Serialize un Objet de type <T> en ligne String
	 * @param t
	 * L'objet en entr�e
	 * @return
	 * la ligne serialis�
	 */
	String serialize(T t);

	String getTemplateName();

	Class<?> getTemplateClass();
	
}
