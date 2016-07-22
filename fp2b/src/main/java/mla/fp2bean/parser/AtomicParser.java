package mla.fp2bean.parser;

import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.exception.Fp2bException;

public abstract class AtomicParser implements Parser{

	
	
	public String serializeObject(Fp2bFieldElement field, Object object)
			throws Fp2bException {
		String objString = "";
		
		if(object!=null)
			objString = object.toString();
		return field.getPrefix()+objString+field.getSuffix();
	}
	
	
	public Object parseString(Fp2bFieldElement field, String token)
			throws Fp2bException {
		return token;
	}
}
