package mla.fp2bean.parser;

import java.util.Map;

import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.exception.Fp2bException;

public class MapStringParser extends AtomicParser{

	public Class<?> getTargetClass() {
		
		return Map.class;
	}
	
	@Override
	public String serializeObject(Fp2bFieldElement field, Object object)
			throws Fp2bException {
		
		Parser subParser = FieldParserBuilder.getParser(object.getClass());
		
		return subParser.serializeObject(field, object);
	}
	
	@Override
	public Object parseString(Fp2bFieldElement field, String token)
			throws Fp2bException {
		
		return super.parseString(field, token);
	}

}
