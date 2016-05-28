package org.domain.cadastro.converter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

public class SelectManyListBoxConverter implements Converter {
	
	private Map<String, Object> items;
	public SelectManyListBoxConverter(){}
	
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		List<SelectItem> items = retrieveSelectItems(uiComponent);
		for (SelectItem si : items) {
			if (si.getLabel().equals(value)) {
				return si.getValue();
			}
		}
		return null;
	}
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		List<SelectItem> items = retrieveSelectItems(uiComponent);
		for (SelectItem si : items) {
			if (si.getValue().equals(value)) {
				return si.getLabel();
			}
		}
		return "";
	}
	@SuppressWarnings("unchecked")
	private List<SelectItem> retrieveSelectItems(UIComponent uiComponent) {
		items = new LinkedHashMap<String, Object>();
		if (!uiComponent.getChildren().isEmpty() && uiComponent.getChildren().get(0) instanceof UISelectItems) {
			items.putAll((Map<? extends String, ? extends Object>) ((UISelectItems) uiComponent.getChildren().get(0)).getValue());
		}
		
		List<SelectItem> result = new ArrayList<SelectItem>();
		for(Object o: items.entrySet()){
			SelectItem si = new SelectItem();
			si.setLabel(o.toString());
			si.setValue(o);
			result.add(si);
		}
		
		return result;
	}

}
