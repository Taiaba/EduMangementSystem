package controller;

import info.edu.sys.SchAcademicYear;
import info.edu.sys.SchSectionName;
import java.util.Collection;
import facade.SchAcademicYearFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "schAcademicYearController")
@ViewScoped
public class SchAcademicYearController extends AbstractController<SchAcademicYear> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSchSectionNameCollectionEmpty;

    public SchAcademicYearController() {
        // Inform the Abstract parent controller of the concrete SchAcademicYear Entity
        super(SchAcademicYear.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsSchSectionNameCollectionEmpty();
    }

    public boolean getIsSchSectionNameCollectionEmpty() {
        return this.isSchSectionNameCollectionEmpty;
    }

    private void setIsSchSectionNameCollectionEmpty() {
        SchAcademicYear selected = this.getSelected();
        if (selected != null) {
            SchAcademicYearFacade ejbFacade = (SchAcademicYearFacade) this.getFacade();
            this.isSchSectionNameCollectionEmpty = ejbFacade.isSchSectionNameCollectionEmpty(selected);
        } else {
            this.isSchSectionNameCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SchSectionName entities
     * that are retrieved from SchAcademicYear and returns the navigation
     * outcome.
     *
     * @return navigation outcome for SchSectionName page
     */
    public String navigateSchSectionNameCollection() {
        SchAcademicYear selected = this.getSelected();
        if (selected != null) {
            SchAcademicYearFacade ejbFacade = (SchAcademicYearFacade) this.getFacade();
            Collection<SchSectionName> selectedSchSectionNameCollection = ejbFacade.findSchSectionNameCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SchSectionName_items", selectedSchSectionNameCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/schSectionName/index";
    }

}
