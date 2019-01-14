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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sch_section_name")
@NamedQueries({
    @NamedQuery(name = "SchSectionName.findAll", query = "SELECT s FROM SchSectionName s")})
public class SchSectionName implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schSectionName")
    private Collection<SchStdRegistration> schStdRegistrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schSectionName")
    private Collection<SchStdAttendance> schStdAttendanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schSectionName")
    private Collection<SchTimeTable> schTimeTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schSectionName")
    private Collection<SchStdMarks> schStdMarksCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schSectionName")
    private Collection<SchTeacherSubAssign> schTeacherSubAssignCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "section_id")
    private Integer sectionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "section_name")
    private String sectionName;
    @JoinColumn(name = "acyid", referencedColumnName = "acyid")
    @ManyToOne(optional = false)
    private SchAcademicYear schAcademicYear;
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @ManyToOne(optional = false)
    private SchClassName schClassName;

    public SchSectionName() {
    }

    public SchSectionName(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public SchSectionName(Integer sectionId, String sectionName) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public SchAcademicYear getSchAcademicYear() {
        return schAcademicYear;
    }

    public void setSchAcademicYear(SchAcademicYear schAcademicYear) {
        this.schAcademicYear = schAcademicYear;
    }

    public SchClassName getSchClassName() {
        return schClassName;
    }

    public void setSchClassName(SchClassName schClassName) {
        this.schClassName = schClassName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectionId != null ? sectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchSectionName)) {
            return false;
        }
        SchSectionName other = (SchSectionName) object;
        if ((this.sectionId == null && other.sectionId != null) || (this.sectionId != null && !this.sectionId.equals(other.sectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchSectionName[ sectionId=" + sectionId + " ]";
    }

    public Collection<SchStdRegistration> getSchStdRegistrationCollection() {
        return schStdRegistrationCollection;
    }

    public void setSchStdRegistrationCollection(Collection<SchStdRegistration> schStdRegistrationCollection) {
        this.schStdRegistrationCollection = schStdRegistrationCollection;
    }

    public Collection<SchStdAttendance> getSchStdAttendanceCollection() {
        return schStdAttendanceCollection;
    }

    public void setSchStdAttendanceCollection(Collection<SchStdAttendance> schStdAttendanceCollection) {
        this.schStdAttendanceCollection = schStdAttendanceCollection;
    }

    public Collection<SchTimeTable> getSchTimeTableCollection() {
        return schTimeTableCollection;
    }

    public void setSchTimeTableCollection(Collection<SchTimeTable> schTimeTableCollection) {
        this.schTimeTableCollection = schTimeTableCollection;
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
    
}
