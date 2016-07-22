package mla.fp2bean.annotations;

import mla.fp2bean.descriptor.When;

public @interface Replace {
	
	public char oldChar();
	public char newChar();
	public When when() default When.all;

}
