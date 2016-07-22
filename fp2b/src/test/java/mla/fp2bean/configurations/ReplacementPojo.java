package mla.fp2bean.configurations;

import mla.fp2bean.annotations.FieldElement;
import mla.fp2bean.annotations.Fp2bRootTemplate;
import mla.fp2bean.annotations.Replace;

@Fp2bRootTemplate(name = "ReplacementPojo")
public class ReplacementPojo {
	
	@FieldElement(index = 0, length = 5,
			replacements=@Replace(newChar = '.', oldChar = ','))
	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	

}
