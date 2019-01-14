/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.edu.sys;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "sch_std_registration")
@NamedQueries({
    @NamedQuery(name = "SchStdRegistration.findAll", query = "SELECT s FROM SchStdRegistration s")})
public class SchStdRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reg_id")
    private Integer regId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_roll_no")
    private int stdRollNo;
    @JoinColumn(name = "acyid", referencedColumnName = "acyid")
    @ManyToOne(optional = false)
    private SchAcademicYear schAcademicYear;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private SchStdGroup schStdGroup;
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    @ManyToOne(optional = false)
    private SchSectionName schSectionName;
    @JoinColumn(name = "std_id", referencedColumnName = "std_id")
    @ManyToOne(optional = false)
    private SchStudentInfo schStudentInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schStdRegistration")
    private Collection<SchRegFee> schRegFeeCollection;

    public SchStdRegistration() {
    }

    public SchStdRegistration(Integer regId) {
        this.regId = regId;
    }

    public SchStdRegistration(Integer regId, Date regDate, int stdRollNo) {
        this.regId = regId;
        this.regDate = regDate;
        this.stdRollNo = stdRollNo;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getStdRollNo() {
        return stdRollNo;
    }

    public void setStdRollNo(int stdRollNo) {
        this.stdRollNo = stdRollNo;
    }

    public SchAcademicYear getSchAcademicYear() {
        return schAcademicYear;
    }

    public void setSchAcademicYear(SchAcademicYear schAcademicYear) {
        this.schAcademicYear = schAcademicYear;
    }

    public SchStdGroup getSchStdGroup() {
        return schStdGroup;
    }

    public void setSchStdGroup(SchStdGroup schStdGroup) {
        this.schStdGroup = schStdGroup;
    }

    public SchSectionName getSchSectionName() {
        return schSectionName;
    }

    public void setSchSectionName(SchSectionName schSectionName) {
        this.schSectionName = schSectionName;
    }

    public SchStudentInfo getSchStudentInfo() {
        return schStudentInfo;
    }

    public void setSchStudentInfo(SchStudentInfo schStudentInfo) {
        this.schStudentInfo = schStudentInfo;
    }

    public Collection<SchRegFee> getSchRegFeeCollection() {
        return schRegFeeCollection;
    }

    public void setSchRegFeeCollection(Collection<SchRegFee> schRegFeeCollection) {
        this.schRegFeeCollection = schRegFeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regId != null ? regId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchStdRegistration)) {
            return false;
        }
        SchStdRegistration other = (SchStdRegistration) object;
        if ((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchStdRegistration[ regId=" + regId + " ]";
    }
    
}
