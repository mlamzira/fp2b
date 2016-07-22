package mla.fp2bean.configurations;

import mla.fp2bean.annotations.FieldElement;
import mla.fp2bean.annotations.Fp2bRootTemplate;

@Fp2bRootTemplate(name = "RequiredConfig")
public class RequiredConfigPojo {
	@FieldElement(index = 0, length = 5, required=true)
	private String requiredField;

	public String getRequiredField() {
		return requiredField;
	}

	public void setRequiredField(String requiredField) {
		this.requiredField = requiredField;
	}
}
