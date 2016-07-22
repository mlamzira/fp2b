package mla.fp2bean.parser;

import mla.fp2bean.descriptor.Fp2bFieldElement;

class DoubleParser extends AtomicParser{

	
	public Object parseString(Fp2bFieldElement field, String token) {
		return Double.parseDouble(token);
	}

	
	public Class<?> getTargetClass() {
		return Double.class;
	}

}
