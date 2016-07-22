package mla.fp2bean.features;

import static org.assertj.core.api.Assertions.assertThat;
import mla.fp2bean.configurations.TwoFieldsOfSameIndexPojo;
import mla.fp2bean.context.Fp2bAnnotationConfigLoader;
import mla.fp2bean.exception.Fp2bException;

import org.junit.Test;

public class ConfigTest {
	
	@Test
	public void indexesShouldAllBeDifferent(){
		
		try {
			Fp2bAnnotationConfigLoader
					.loadConfig(TwoFieldsOfSameIndexPojo.class);
		} catch (Exception e) {
			assertThat(e.getMessage()).isEqualTo("two fields have the same index");
		}
	}
	
	@Test(expected=Fp2bException.class)
	public void providedClassShouldBeAnnotated(){

			Fp2bAnnotationConfigLoader
					.loadConfig(String.class);
		 
	}

}
