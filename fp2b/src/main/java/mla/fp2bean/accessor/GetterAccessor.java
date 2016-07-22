package mla.fp2bean.accessor;

import java.lang.reflect.InvocationTargetException;

public interface GetterAccessor {

	Object invoke(Object host) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, Exception;

}
