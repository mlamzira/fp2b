package mla.fp2bean.accessor;

import java.lang.reflect.InvocationTargetException;

public interface SetterAccessor {

	void invoke(Object host, Object value) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, Exception;

}
