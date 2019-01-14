/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import info.edu.sys.SchSectionName;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import info.edu.sys.SchSectionName_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import info.edu.sys.SchAcademicYear;
import info.edu.sys.SchClassName;

/**
 *
 * @author RT
 */
@Stateless
public class SchSectionNameFacade extends AbstractFacade<SchSectionName> {

    @PersistenceContext(unitName = "EduMangementSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SchSectionNameFacade() {
        super(SchSectionName.class);
    }

    public boolean isSchAcademicYearEmpty(SchSectionName entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SchSectionName> schSectionName = cq.from(SchSectionName.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(schSectionName, entity), cb.isNotNull(schSectionName.get(SchSectionName_.schAcademicYear)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public SchAcademicYear findSchAcademicYear(SchSectionName entity) {
        return this.getMergedEntity(entity).getSchAcademicYear();
    }

    public boolean isSchClassNameEmpty(SchSectionName entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SchSectionName> schSectionName = cq.from(SchSectionName.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(schSectionName, entity), cb.isNotNull(schSectionName.get(SchSectionName_.schClassName)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public SchClassName findSchClassName(SchSectionName entity) {
        return this.getMergedEntity(entity).getSchClassName();
    }
    
}
