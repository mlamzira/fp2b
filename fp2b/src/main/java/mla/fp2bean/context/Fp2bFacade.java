package mla.fp2bean.context;

public interface Fp2bFacade {
	public <T> Fp2bEngine<T> getEngine(Class<T> cls,String name);

	<T> void init() throws Throwable;
}
