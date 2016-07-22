package mla.fp2bean.processor;

import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.descriptor.Fp2bReplace;
import mla.fp2bean.descriptor.Fp2bRootElement;
import mla.fp2bean.descriptor.When;
import mla.fp2bean.exception.Fp2bException;

public class Deserializer<T> extends AbstractProcessor<T>{

	@SuppressWarnings("unchecked")
	public T process(String line, Fp2bRootElement bean){

		Class<?> clazz = bean.getClazz();

		T obj;
		try {
			obj = (T) clazz.newInstance();
		} catch (Exception e) {
			
			throw new Fp2bException(e);
		}

		int index = 0;

		for (Fp2bFieldElement field : bean) {
			String token = line.substring(index, index + field.getLength())
					.trim();
			
			if(field.getReplacements().size()>0){
				for(Fp2bReplace replace : field.getReplacements()){
					if(replace.getWhen()==When.all
							||replace.getWhen()==When.deserialize)
						token = token.replace(replace.getOld(), replace.getNew());
				}
			}
			
			Object param = parseString(field, token);
			
			field.invokeSetter(obj, param);
			
			index += field.getLength();
		}

		return obj;
	}
	
	private Object parseString(Fp2bFieldElement field,String token) throws Fp2bException{
		
		Object param = null;
		
		if (!token.equals("")) {
			param = field.parseString(token);

		} else {
			if(field.isRequired())
				throw new IllegalArgumentException("Field :"+field.getName()+" is required !");
		}
		
		return param;
		
	}

}
