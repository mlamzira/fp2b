package mla.fp2bean.configurations;

import java.util.HashMap;
import java.util.Map;

import mla.fp2bean.annotations.FieldElement;
import mla.fp2bean.annotations.FieldRoot;
import mla.fp2bean.annotations.Fp2bRootTemplate;

@Fp2bRootTemplate(name = "MultiplePositionsPojo")
public class MultiplePositionsPojo {
	
	@FieldRoot(multiplePositions = { 
			@FieldElement(index = 0, length = 5, name="values['field1']"),
			@FieldElement(index = 1, length = 5, name="values['field2']")})
	private Map<String, String> values = new HashMap<String, String>();

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}
	
	

}
