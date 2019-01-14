package converter;

import info.edu.sys.SchAcademicYear;
import facade.SchAcademicYearFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "schAcademicYearConverter")
public class SchAcademicYearConverter implements Converter {

    private SchAcademicYearFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof SchAcademicYear) {
            SchAcademicYear o = (SchAcademicYear) object;
            return getStringKey(o.getAcyid());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SchAcademicYear.class.getName()});
            return null;
        }
    }

    private SchAcademicYearFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(SchAcademicYearFacade.class).get();
        return this.ejbFacade;
    }
}
