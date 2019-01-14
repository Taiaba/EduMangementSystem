/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.edu.sys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "sch_class_name")
@NamedQueries({
    @NamedQuery(name = "SchClassName.findAll", query = "SELECT s FROM SchClassName s")})
public class SchClassName implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schClassName")
    private Collection<SchTimeTable> schTimeTableCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "class_id")
    private Integer classId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "class_name")
    private String className;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schClassName")
    private Collection<SchSectionName> schSectionNameCollection;

    public SchClassName() {
    }

    public SchClassName(Integer classId) {
        this.classId = classId;
    }

    public SchClassName(Integer classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Collection<SchSectionName> getSchSectionNameCollection() {
        return schSectionNameCollection;
    }

    public void setSchSectionNameCollection(Collection<SchSectionName> schSectionNameCollection) {
        this.schSectionNameCollection = schSectionNameCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classId != null ? classId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchClassName)) {
            return false;
        }
        SchClassName other = (SchClassName) object;
        if ((this.classId == null && other.classId != null) || (this.classId != null && !this.classId.equals(other.classId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchClassName[ classId=" + classId + " ]";
    }

    public Collection<SchTimeTable> getSchTimeTableCollection() {
        return schTimeTableCollection;
    }

    public void setSchTimeTableCollection(Collection<SchTimeTable> schTimeTableCollection) {
        this.schTimeTableCollection = schTimeTableCollection;
    }
    
}
