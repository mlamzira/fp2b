package mla.fp2bean.processor;

import mla.fp2bean.descriptor.Fp2bRootElement;

public interface  Processor<T> {
	
	public T process(String line, Fp2bRootElement bean);
	public String process(T t, Fp2bRootElement bean);

}
