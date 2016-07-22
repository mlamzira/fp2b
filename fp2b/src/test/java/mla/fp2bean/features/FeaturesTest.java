package mla.fp2bean.features;

import static org.assertj.core.api.Assertions.assertThat;
import mla.fp2bean.configurations.BasicTestPojo;
import mla.fp2bean.configurations.MultiplePositionsPojo;
import mla.fp2bean.configurations.ReplacementPojo;
import mla.fp2bean.configurations.RequiredConfigPojo;
import mla.fp2bean.context.Fp2bAnnotationConfigLoader;
import mla.fp2bean.context.Fp2bEngine;
import mla.fp2bean.exception.Fp2bException;

import org.junit.Test;


public class FeaturesTest {
	
	
	@Test
	public void basicTest() throws Fp2bException{
		
		Fp2bEngine<BasicTestPojo> engine = Fp2bAnnotationConfigLoader.loadConfig(BasicTestPojo.class);
		
		BasicTestPojo pj = new BasicTestPojo();
		
		pj.setField1("champ");
		pj.setField2("field");

		String line = "champfield";
		
		assertThat(engine.serialize(pj)).isEqualTo(line);
		
		assertThat(pj).isEqualTo(engine.deserializeLine(line));
		
	}
	
	@Test
	public void testRequired(){
		
		Fp2bEngine<RequiredConfigPojo> engine = Fp2bAnnotationConfigLoader.loadConfig(RequiredConfigPojo.class);
		RequiredConfigPojo pj = new RequiredConfigPojo();
		
		try {
			engine.serialize(pj);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(Fp2bException.class);
		}
		
	}
	

	@Test
	public void testReplacement(){
		Fp2bEngine<ReplacementPojo> engine = Fp2bAnnotationConfigLoader
				.loadConfig(ReplacementPojo.class);
		
		ReplacementPojo pj = new ReplacementPojo();
		pj.setField("13,13");
		
		assertThat(engine.serialize(pj)).isEqualTo("13.13");
	}
	
	@Test
	public void testMultiplePositions(){
		Fp2bEngine<MultiplePositionsPojo> engine = Fp2bAnnotationConfigLoader
				.loadConfig(MultiplePositionsPojo.class);
		
		String line = "0000,11111";
		
		MultiplePositionsPojo pj = engine.deserializeLine(line);
		
		assertThat(pj.getValues().get("field1")).isEqualTo("0000,");
		assertThat(pj.getValues().get("field2")).isEqualTo("11111");
	}
	

}
