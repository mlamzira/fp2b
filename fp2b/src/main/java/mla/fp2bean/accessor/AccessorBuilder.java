package mla.fp2bean.accessor;

import mla.fp2bean.descriptor.Fp2bFieldElement;

public interface AccessorBuilder {

	void buildAccessors(Fp2bFieldElement field, Object host) throws Exception;

}
