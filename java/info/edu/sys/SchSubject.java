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
@Table(name = "sch_subject")
@NamedQueries({
    @NamedQuery(name = "SchSubject.findAll", query = "SELECT s FROM SchSubject s")})
public class SchSubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subject_id")
    private Integer subjectId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subject_code")
    private int subjectCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "subject_name")
    private String subjectName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schSubject")
    private Collection<SchTeacherInfo> schTeacherInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schSubject")
    private Collection<SchClassTimeTableLine> schClassTimeTableLineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schSubject")
    private Collection<SchStdMarks> schStdMarksCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schSubject")
    private Collection<SchTeacherSubAssign> schTeacherSubAssignCollection;

    public SchSubject() {
    }

    public SchSubject(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public SchSubject(Integer subjectId, int subjectCode, String subjectName) {
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Collection<SchTeacherInfo> getSchTeacherInfoCollection() {
        return schTeacherInfoCollection;
    }

    public void setSchTeacherInfoCollection(Collection<SchTeacherInfo> schTeacherInfoCollection) {
        this.schTeacherInfoCollection = schTeacherInfoCollection;
    }

    public Collection<SchClassTimeTableLine> getSchClassTimeTableLineCollection() {
        return schClassTimeTableLineCollection;
    }

    public void setSchClassTimeTableLineCollection(Collection<SchClassTimeTableLine> schClassTimeTableLineCollection) {
        this.schClassTimeTableLineCollection = schClassTimeTableLineCollection;
    }

    public Collection<SchStdMarks> getSchStdMarksCollection() {
        return schStdMarksCollection;
    }

    public void setSchStdMarksCollection(Collection<SchStdMarks> schStdMarksCollection) {
        this.schStdMarksCollection = schStdMarksCollection;
    }

    public Collection<SchTeacherSubAssign> getSchTeacherSubAssignCollection() {
        return schTeacherSubAssignCollection;
    }

    public void setSchTeacherSubAssignCollection(Collection<SchTeacherSubAssign> schTeacherSubAssignCollection) {
        this.schTeacherSubAssignCollection = schTeacherSubAssignCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectId != null ? subjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchSubject)) {
            return false;
        }
        SchSubject other = (SchSubject) object;
        if ((this.subjectId == null && other.subjectId != null) || (this.subjectId != null && !this.subjectId.equals(other.subjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchSubject[ subjectId=" + subjectId + " ]";
    }
    
}
