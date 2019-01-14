package controller;

import info.edu.sys.SchSectionName;
import facade.SchSectionNameFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "schSectionNameController")
@ViewScoped
public class SchSectionNameController extends AbstractController<SchSectionName> {

    @Inject
    private SchAcademicYearController schAcademicYearController;
    @Inject
    private SchClassNameController schClassNameController;
    @Inject
    private MobilePageController mobilePageController;

    public SchSectionNameController() {
        // Inform the Abstract parent controller of the concrete SchSectionName Entity
        super(SchSectionName.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        schAcademicYearController.setSelected(null);
        schClassNameController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the SchAcademicYear controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSchAcademicYear(ActionEvent event) {
        SchSectionName selected = this.getSelected();
        if (selected != null && schAcademicYearController.getSelected() == null) {
            schAcademicYearController.setSelected(selected.getSchAcademicYear());
        }
    }

    /**
     * Sets the "selected" attribute of the SchClassName controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSchClassName(ActionEvent event) {
        SchSectionName selected = this.getSelected();
        if (selected != null && schClassNameController.getSelected() == null) {
            schClassNameController.setSelected(selected.getSchClassName());
        }
    }

}
