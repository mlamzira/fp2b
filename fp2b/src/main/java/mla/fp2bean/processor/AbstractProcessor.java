package mla.fp2bean.processor;

import mla.fp2bean.descriptor.Fp2bRootElement;
import mla.fp2bean.exception.Fp2bException;

class AbstractProcessor<T> implements Processor<T> {

	
	public T process(String line, Fp2bRootElement bean) throws Fp2bException {
		return null;
	}

	
	public String process(T t, Fp2bRootElement bean) throws Fp2bException {
		return null;
	}

}
