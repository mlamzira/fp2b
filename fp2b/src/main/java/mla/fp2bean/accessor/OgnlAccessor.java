package mla.fp2bean.accessor;

import java.lang.reflect.InvocationTargetException;

import ognl.Node;
import ognl.OgnlContext;

public abstract class OgnlAccessor implements SetterAccessor,GetterAccessor{
	
	protected final OgnlContext context;
	protected final Node node;
	
	
	
	public OgnlAccessor(Node node,OgnlContext context) {
		this.context = context;
		this.node = node;
	}

	
	public Object invoke(Object host) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, Exception {
		return null;
	}
	
	
	public void invoke(Object host, Object value)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, Exception {
		
	}
	
	public void build() throws Exception{
//		Object obj = field.getParent().getClazz().newInstance();
//		node =  (Node) Ognl.compileExpression(context, field.getParent().getClazz(), field.getName());
	}


	
	

}
