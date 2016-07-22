package mla.fp2bean.parser;

import mla.fp2bean.descriptor.Fp2bFieldElement;

class FloatParser extends AtomicParser{

	
	public Object parseString(Fp2bFieldElement field, String token) {
		return Float.parseFloat(token);
	}


	
	public Class<?> getTargetClass() {
		return Float.class;
	}

}
