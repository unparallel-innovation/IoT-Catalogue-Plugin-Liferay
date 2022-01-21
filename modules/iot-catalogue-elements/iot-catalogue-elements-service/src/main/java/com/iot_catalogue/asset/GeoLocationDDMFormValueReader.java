package com.iot_catalogue.asset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.iot_catalogue.model.ElementCoordinate;
import com.liferay.asset.kernel.model.BaseDDMFormValuesReader;
import com.liferay.dynamic.data.mapping.kernel.DDMForm;
import com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.dynamic.data.mapping.kernel.LocalizedValue;
import com.liferay.dynamic.data.mapping.kernel.Value;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.LocaleUtil;

public class GeoLocationDDMFormValueReader extends BaseDDMFormValuesReader{

	GeoLocationDDMFormValueReader(List<ElementCoordinate> elementCoordinates){

		
		_ddmFormFieldValues = new ArrayList<DDMFormFieldValue>();
		for(ElementCoordinate elementCoordinate: elementCoordinates) {
			DDMFormFieldValue ddmFormFieldValue = new DDMFormFieldValue();
			Value value = new LocalizedValue();
			String str = "{\"latitude\":" + elementCoordinate.getLatitude() + ",\"longitude\": " + elementCoordinate.getLongitude() +"}";
			value.addString(LocaleUtil.getDefault(), str);
			ddmFormFieldValue.setValue(value);
			_ddmFormFieldValues.add(ddmFormFieldValue);
		}
	}
	
	
	@Override
	public List<DDMFormFieldValue> getDDMFormFieldValues(String ddmFormFieldType){
		if(ddmFormFieldType.equals("ddm-geolocation")) {

			return _ddmFormFieldValues;
		}
		return Collections.emptyList();
		
	}
	
	@Override
	public DDMFormValues getDDMFormValues() throws PortalException {
		// TODO Auto-generated method stub
		return new DDMFormValues(new DDMForm());
	}
	
	
	private final List<DDMFormFieldValue> _ddmFormFieldValues;

}
