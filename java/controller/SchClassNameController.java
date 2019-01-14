package controller;

import info.edu.sys.SchClassName;
import info.edu.sys.SchSectionName;
import java.util.Collection;
import facade.SchClassNameFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "schClassNameController")
@ViewScoped
public class SchClassNameController extends AbstractController<SchClassName> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSchSectionNameCollectionEmpty;

    public SchClassNameController() {
        // Inform the Abstract parent controller of the concrete SchClassName Entity
        super(SchClassName.class);
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
        SchClassName selected = this.getSelected();
        if (selected != null) {
            SchClassNameFacade ejbFacade = (SchClassNameFacade) this.getFacade();
            this.isSchSectionNameCollectionEmpty = ejbFacade.isSchSectionNameCollectionEmpty(selected);
        } else {
            this.isSchSectionNameCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SchSectionName entities
     * that are retrieved from SchClassName and returns the navigation outcome.
     *
     * @return navigation outcome for SchSectionName page
     */
    public String navigateSchSectionNameCollection() {
        SchClassName selected = this.getSelected();
        if (selected != null) {
            SchClassNameFacade ejbFacade = (SchClassNameFacade) this.getFacade();
            Collection<SchSectionName> selectedSchSectionNameCollection = ejbFacade.findSchSectionNameCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SchSectionName_items", selectedSchSectionNameCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/schSectionName/index";
    }

}
