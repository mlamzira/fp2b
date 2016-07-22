package mla.fp2bean.context;

import javax.xml.bind.Unmarshaller;

import mla.fp2bean.descriptor.Fp2bRootElement;
import mla.fp2bean.processor.Processor;

class Fp2bEngineImpl<T> implements Fp2bEngine<T> {

	private Fp2bRootElement bean;
	private Processor<T> deserilizer;
	private Processor<T> serializer;
	private Unmarshaller jaxbUnmarshaller;

	public Fp2bEngineImpl(Fp2bRootElement bean) {
		this.bean = bean;
	}

	public T deserializeLine(String line) {

		try {
			return deserilizer.process(line, bean);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String serialize(T t) {

		return serializer.process(t, bean);

	}

	public Class<?> getTemplateClass() {
		return bean.getClazz();
	}

	public String getTemplateName() {
		return bean.getName();
	}

	public Processor<T> getDeserilizer() {
		return deserilizer;
	}

	public void setDeserilizer(Processor<T> deserilizer) {
		this.deserilizer = deserilizer;
	}

	public Processor<T> getSerializer() {
		return serializer;
	}

	public void setSerializer(Processor<T> serializer) {
		this.serializer = serializer;
	}

	Fp2bRootElement getBean() {
		return bean;
	}

	public Unmarshaller getJaxbUnmarshaller() {
		return jaxbUnmarshaller;
	}

	public void setJaxbUnmarshaller(Unmarshaller jaxbUnmarshaller) {
		this.jaxbUnmarshaller = jaxbUnmarshaller;
	}

}
