package mla.fp2bean.exception;


public class Fp2bException extends RuntimeException{
	
	private static final long serialVersionUID = -7905796336556571726L;


	public Fp2bException(Throwable e) {
		super(e);
	}
	
	public Fp2bException(String message){
		super(message);
	}
}
