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
@Table(name = "sch_academic_year")
@NamedQueries({
    @NamedQuery(name = "SchAcademicYear.findAll", query = "SELECT s FROM SchAcademicYear s")})
public class SchAcademicYear implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schAcademicYear")
    private Collection<SchStdRegistration> schStdRegistrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schAcademicYear")
    private Collection<SchStdAttendance> schStdAttendanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schAcademicYear")
    private Collection<SchStdMarks> schStdMarksCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acyid")
    private Integer acyid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "acyear")
    private String acyear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_of_exam")
    private int noOfExam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isclosed")
    private boolean isclosed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schAcademicYear")
    private Collection<SchSectionName> schSectionNameCollection;

    public SchAcademicYear() {
    }

    public SchAcademicYear(Integer acyid) {
        this.acyid = acyid;
    }

    public SchAcademicYear(Integer acyid, String acyear, int noOfExam, boolean isclosed) {
        this.acyid = acyid;
        this.acyear = acyear;
        this.noOfExam = noOfExam;
        this.isclosed = isclosed;
    }

    public Integer getAcyid() {
        return acyid;
    }

    public void setAcyid(Integer acyid) {
        this.acyid = acyid;
    }

    public String getAcyear() {
        return acyear;
    }

    public void setAcyear(String acyear) {
        this.acyear = acyear;
    }

    public int getNoOfExam() {
        return noOfExam;
    }

    public void setNoOfExam(int noOfExam) {
        this.noOfExam = noOfExam;
    }

    public boolean getIsclosed() {
        return isclosed;
    }

    public void setIsclosed(boolean isclosed) {
        this.isclosed = isclosed;
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
        hash += (acyid != null ? acyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchAcademicYear)) {
            return false;
        }
        SchAcademicYear other = (SchAcademicYear) object;
        if ((this.acyid == null && other.acyid != null) || (this.acyid != null && !this.acyid.equals(other.acyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchAcademicYear[ acyid=" + acyid + " ]";
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

    public Collection<SchStdMarks> getSchStdMarksCollection() {
        return schStdMarksCollection;
    }

    public void setSchStdMarksCollection(Collection<SchStdMarks> schStdMarksCollection) {
        this.schStdMarksCollection = schStdMarksCollection;
    }
    
}
