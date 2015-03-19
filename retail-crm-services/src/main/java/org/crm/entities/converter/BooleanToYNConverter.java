package org.crm.entities.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=false)
public class BooleanToYNConverter implements AttributeConverter<Boolean, String>{

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		
		
		if(Boolean.TRUE.equals(attribute)){
			return "Y";
		}else if(Boolean.FALSE.equals(attribute)){
			return "N";
		}
		
		return "N";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		if(dbData == null){
			return null;
		}
		
		if(dbData.equals("Y")||dbData.equals("y")){
			return true;
		}
		
		return false;		
	}

	
	
}


