package mla.fp2bean.accessor;

import mla.fp2bean.context.Fp2bContext;
import mla.fp2bean.descriptor.Fp2bFieldElement;

import org.apache.log4j.Logger;

import ognl.Node;
import ognl.Ognl;
import ognl.OgnlContext;

public class OgnlAccessorBuilder implements AccessorBuilder {

	private OgnlContext context;
	private static Logger logger = Logger.getLogger(Fp2bContext.class);
	
	public OgnlAccessorBuilder() {
		context = (OgnlContext) Ognl.createDefaultContext(null);
	}

	
	public void buildAccessors(Fp2bFieldElement field, Object host) throws Exception {
		
		logger.info("compiling OGNL Expression : "+field.getName());
		Node node = (Node) Ognl.compileExpression(context, host,
				field.getName());

		OgnlGetterAccessor ognlGetterAccessor = new OgnlGetterAccessor(node,
				context);
		OgnlSetterAccessor ognlSetterAccessor = new OgnlSetterAccessor(node,
				context);

		field.setGetter(ognlGetterAccessor);
		field.setSetter(ognlSetterAccessor);

	}

}
