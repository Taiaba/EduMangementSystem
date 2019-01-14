/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import info.edu.sys.SchAcademicYear;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import info.edu.sys.SchAcademicYear_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import info.edu.sys.SchSectionName;
import java.util.Collection;

/**
 *
 * @author RT
 */
@Stateless
public class SchAcademicYearFacade extends AbstractFacade<SchAcademicYear> {

    @PersistenceContext(unitName = "EduMangementSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SchAcademicYearFacade() {
        super(SchAcademicYear.class);
    }

    public boolean isSchSectionNameCollectionEmpty(SchAcademicYear entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SchAcademicYear> schAcademicYear = cq.from(SchAcademicYear.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(schAcademicYear, entity), cb.isNotEmpty(schAcademicYear.get(SchAcademicYear_.schSectionNameCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SchSectionName> findSchSectionNameCollection(SchAcademicYear entity) {
        SchAcademicYear mergedEntity = this.getMergedEntity(entity);
        Collection<SchSectionName> schSectionNameCollection = mergedEntity.getSchSectionNameCollection();
        schSectionNameCollection.size();
        return schSectionNameCollection;
    }
    
}
