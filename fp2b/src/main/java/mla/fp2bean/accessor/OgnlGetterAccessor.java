package mla.fp2bean.accessor;

import ognl.Node;
import ognl.OgnlContext;


public class OgnlGetterAccessor extends OgnlAccessor {
	

	

	public OgnlGetterAccessor(Node node, OgnlContext context) {
		super(node, context);
	}

	@Override
	public Object invoke(Object host) throws Exception {		
		return node.getAccessor().get(context, host);

	}

	

}
