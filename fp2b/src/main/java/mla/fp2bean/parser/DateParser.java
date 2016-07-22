package mla.fp2bean.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.exception.Fp2bException;

class DateParser implements Parser{

	
	public Object parseString(Fp2bFieldElement field, String token) throws Fp2bException {
		SimpleDateFormat sdf = new SimpleDateFormat(
				field.getDatePattern());
		try {
			return sdf.parseObject(token);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Fp2bException(e);
		}
	}

	
	public String serializeObject(Fp2bFieldElement field, Object object) {
		SimpleDateFormat sdf = new SimpleDateFormat(field.getDatePattern());
		return field.getPrefix()+sdf.format(object)+field.getSuffix();
	}

	
	public Class<?> getTargetClass() {
		return Date.class;
	}

}
