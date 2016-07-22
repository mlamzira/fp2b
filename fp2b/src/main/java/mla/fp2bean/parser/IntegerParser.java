package mla.fp2bean.parser;

import mla.fp2bean.descriptor.Fp2bFieldElement;

class IntegerParser extends AtomicParser{

	
	public Object parseString(Fp2bFieldElement field, String token) {
		return Integer.parseInt(token);
	}


	
	public Class<?> getTargetClass() {
		return Integer.class;
	}

}
