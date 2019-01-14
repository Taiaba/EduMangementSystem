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
@Table(name = "sch_exam_title")
@NamedQueries({
    @NamedQuery(name = "SchExamTitle.findAll", query = "SELECT s FROM SchExamTitle s")})
public class SchExamTitle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ex_tt_id")
    private Integer exTtId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "exam_title")
    private String examTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schExamTitle")
    private Collection<SchStdMarks> schStdMarksCollection;

    public SchExamTitle() {
    }

    public SchExamTitle(Integer exTtId) {
        this.exTtId = exTtId;
    }

    public SchExamTitle(Integer exTtId, String examTitle, String description) {
        this.exTtId = exTtId;
        this.examTitle = examTitle;
        this.description = description;
    }

    public Integer getExTtId() {
        return exTtId;
    }

    public void setExTtId(Integer exTtId) {
        this.exTtId = exTtId;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<SchStdMarks> getSchStdMarksCollection() {
        return schStdMarksCollection;
    }

    public void setSchStdMarksCollection(Collection<SchStdMarks> schStdMarksCollection) {
        this.schStdMarksCollection = schStdMarksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exTtId != null ? exTtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchExamTitle)) {
            return false;
        }
        SchExamTitle other = (SchExamTitle) object;
        if ((this.exTtId == null && other.exTtId != null) || (this.exTtId != null && !this.exTtId.equals(other.exTtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchExamTitle[ exTtId=" + exTtId + " ]";
    }
    
}
