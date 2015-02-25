package org.crm.entities.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=false)
public class BooleanToYNConverter implements AttributeConverter<Boolean, String>{

	public String convertToDatabaseColumn(Boolean attribute) {
		
		if(attribute == null){
			return null;
		}
		
		if(Boolean.TRUE.equals(attribute)){
			return "Y";
		}
		
		return "N";
	}

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


