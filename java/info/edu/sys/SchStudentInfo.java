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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "sch_student_info")
@NamedQueries({
    @NamedQuery(name = "SchStudentInfo.findAll", query = "SELECT s FROM SchStudentInfo s")})
public class SchStudentInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "std_id")
    private Integer stdId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "std_name")
    private String stdName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "std_father_name")
    private String stdFatherName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "std_mother_name")
    private String stdMotherName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_age")
    private int stdAge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "std_gender")
    private String stdGender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_dob")
    @Temporal(TemporalType.DATE)
    private Date stdDob;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "std_photo")
    private byte[] stdPhoto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_status")
    private boolean stdStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schStudentInfo")
    private Collection<SchStdRegistration> schStdRegistrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schStudentInfo")
    private Collection<SchStdAttendance> schStdAttendanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schStudentInfo")
    private Collection<SchStdContactInfo> schStdContactInfoCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private SchUser schUser;

    public SchStudentInfo() {
    }

    public SchStudentInfo(Integer stdId) {
        this.stdId = stdId;
    }

    public SchStudentInfo(Integer stdId, String stdName, String stdFatherName, String stdMotherName, int stdAge, String stdGender, Date stdDob, byte[] stdPhoto, boolean stdStatus) {
        this.stdId = stdId;
        this.stdName = stdName;
        this.stdFatherName = stdFatherName;
        this.stdMotherName = stdMotherName;
        this.stdAge = stdAge;
        this.stdGender = stdGender;
        this.stdDob = stdDob;
        this.stdPhoto = stdPhoto;
        this.stdStatus = stdStatus;
    }

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdFatherName() {
        return stdFatherName;
    }

    public void setStdFatherName(String stdFatherName) {
        this.stdFatherName = stdFatherName;
    }

    public String getStdMotherName() {
        return stdMotherName;
    }

    public void setStdMotherName(String stdMotherName) {
        this.stdMotherName = stdMotherName;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }

    public String getStdGender() {
        return stdGender;
    }

    public void setStdGender(String stdGender) {
        this.stdGender = stdGender;
    }

    public Date getStdDob() {
        return stdDob;
    }

    public void setStdDob(Date stdDob) {
        this.stdDob = stdDob;
    }

    public byte[] getStdPhoto() {
        return stdPhoto;
    }

    public void setStdPhoto(byte[] stdPhoto) {
        this.stdPhoto = stdPhoto;
    }

    public boolean getStdStatus() {
        return stdStatus;
    }

    public void setStdStatus(boolean stdStatus) {
        this.stdStatus = stdStatus;
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

    public Collection<SchStdContactInfo> getSchStdContactInfoCollection() {
        return schStdContactInfoCollection;
    }

    public void setSchStdContactInfoCollection(Collection<SchStdContactInfo> schStdContactInfoCollection) {
        this.schStdContactInfoCollection = schStdContactInfoCollection;
    }

    public SchUser getSchUser() {
        return schUser;
    }

    public void setSchUser(SchUser schUser) {
        this.schUser = schUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdId != null ? stdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchStudentInfo)) {
            return false;
        }
        SchStudentInfo other = (SchStudentInfo) object;
        if ((this.stdId == null && other.stdId != null) || (this.stdId != null && !this.stdId.equals(other.stdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchStudentInfo[ stdId=" + stdId + " ]";
    }
    
}
