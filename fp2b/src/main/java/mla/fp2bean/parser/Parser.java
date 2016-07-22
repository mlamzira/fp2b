package mla.fp2bean.parser;

import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.exception.Fp2bException;

public interface Parser {
	
	Object parseString(Fp2bFieldElement field,String token) throws Fp2bException;
	String serializeObject(Fp2bFieldElement field,Object object)throws Fp2bException;
	Class<?> getTargetClass();
}
