/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import info.edu.sys.SchStdGroup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RT
 */
@Stateless
public class SchStdGroupFacade extends AbstractFacade<SchStdGroup> {

    @PersistenceContext(unitName = "EduMangementSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SchStdGroupFacade() {
        super(SchStdGroup.class);
    }
    
}
