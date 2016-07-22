package mla.fp2bean.accessor;

import ognl.Node;
import ognl.OgnlContext;


public class OgnlSetterAccessor extends OgnlAccessor {
	

	
	public OgnlSetterAccessor(Node node, OgnlContext context) {
		super(node, context);
	}

	@Override
	public void invoke(Object host, Object value)
			throws Exception {
		node.setValue(context, host, value);
	}



	

}
