package mla.fp2bean.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import mla.fp2bean.parser.Parser;

@Retention(RetentionPolicy.RUNTIME)
public @interface FieldElement {
	
	public int index();
	public String name() default "";
	public int length();
	public String datePattern() default "";
	public String prefix() default "";
	public String suffix() default "";
	public boolean required() default false;
	public Class<? extends Parser> parser() default Parser.class;
	public Replace[] replacements() default {};
	
}
