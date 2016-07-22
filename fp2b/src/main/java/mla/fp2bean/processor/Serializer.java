package mla.fp2bean.processor;

import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.descriptor.Fp2bReplace;
import mla.fp2bean.descriptor.Fp2bRootElement;
import mla.fp2bean.descriptor.When;
import mla.fp2bean.exception.Fp2bException;

public class Serializer<T> extends AbstractProcessor<T>{

	public String process(T t, Fp2bRootElement bean){

		StringBuilder sb = new StringBuilder();

		for (Fp2bFieldElement field : bean) {
			
			Object obj = null;
			
			if(field.isBlanck() || field.isHardCoded()){
				obj = field.getDefaultValue();
			}
			else{ 
				obj = field.invokeGetter(t);
			}
			
			if(field.isRequired())
				if(obj==null)
					throw new Fp2bException("Field :"+field.getName()+" is required !");
			
			String token = marshallObject(field, obj);
			
			if(field.getReplacements().size()>0){
				for(Fp2bReplace replace : field.getReplacements()){
					if(replace.getWhen()==When.all
						||replace.getWhen()==When.serialize)
						token = token.replace(replace.getOld(), replace.getNew());
				}
			}
			
			sb.append(token);
			
		}

		return sb.toString();
	}
	
	private String marshallObject(Fp2bFieldElement field, Object obj) throws Fp2bException{
		
		String output = "";
		String input="";
		
		if(field.isHardCoded())
			input = field.getDefaultValue();
		else if(field.isBlanck() || obj==null)
			input = "";
		else
			input = field.serializeObject(obj);
		
		output = makeStringWithinLength(input,field.getLength());
		
		return output;
	}
	
	private String makeStringWithinLength(String input, int length) {
		if (input == null)
			input = " ";
		if (input.length() > length)
			return input.substring(0, length);

		String t = "";
		for (int i = input.length(); i < length; i++) {
			t += " ";
		}
		return input.concat(t);
	}
}
