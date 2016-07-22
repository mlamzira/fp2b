package mla.fp2bean.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.exception.Fp2bException;
import mla.fp2bean.parser.DateParser;
import mla.fp2bean.parser.StringParser;

import org.junit.Test;

public class TestParser {
	
	@Test
	public void stringParser() throws Fp2bException{
		
		StringParser parser = new StringParser();
		
		String parsedLine = (String) parser.parseString(new Fp2bFieldElement(), "test");
		assertThat(parsedLine).isEqualTo("test");
		assertThat(parser.serializeObject(new Fp2bFieldElement(), "test")).isEqualTo("test");
		
	}
	
	@Test
	public void dateParser() throws Fp2bException{
		Fp2bFieldElement field = new Fp2bFieldElement();
		field.setDatePattern("dd/MM/yyyy");
		
		DateParser parser = new DateParser();
		String stringDate = "01/01/1990";
		Date date = (Date) parser.parseString(field, stringDate);
		
		String output = parser.serializeObject(field, date);
		
		assertThat(stringDate).isEqualTo(output);
		
		
	}
	
	public void doubleParser(){
		
	}
	
	public void floatParser(){
		
	}
	
	public void integerParser(){
		
	}
	
	

}
