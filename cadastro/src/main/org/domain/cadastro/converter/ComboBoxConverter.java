package org.domain.cadastro.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

public class ComboBoxConverter implements Converter {
	
	public ComboBoxConverter() {}
	
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		List<SelectItem> items = retrieveSelectItems(uiComponent);
		for (SelectItem si : items) {
			if (si.getLabel().equals(value)) {
				return si.getValue();
			}
		}
		return null;
	}
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
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
		List<SelectItem> items = null;
		if (!uiComponent.getChildren().isEmpty()
				&& uiComponent.getChildren().get(0) instanceof UISelectItems) {
			items = (List<SelectItem>) ((UISelectItems) uiComponent
					.getChildren().get(0)).getValue();
		}
		return items;
	}
}
