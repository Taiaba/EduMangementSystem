package controller;

import info.edu.sys.SchStdGroup;
import facade.SchStdGroupFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "schStdGroupController")
@ViewScoped
public class SchStdGroupController extends AbstractController<SchStdGroup> {

    @Inject
    private MobilePageController mobilePageController;

    public SchStdGroupController() {
        // Inform the Abstract parent controller of the concrete SchStdGroup Entity
        super(SchStdGroup.class);
    }

}
