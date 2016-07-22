package mla.fp2bean.configurations;

import mla.fp2bean.annotations.FieldElement;
import mla.fp2bean.annotations.Fp2bRootTemplate;

@Fp2bRootTemplate(name = "TwoFieldsOfSameIndexPojo")
public class TwoFieldsOfSameIndexPojo {
	
	@FieldElement(index = 0, length = 2)
	private String field1;
	
	@FieldElement(index = 0, length = 2)
	private String field2;
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	
	

}
