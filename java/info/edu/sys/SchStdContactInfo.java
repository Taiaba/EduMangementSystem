/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.edu.sys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "sch_std_contact_info")
@NamedQueries({
    @NamedQuery(name = "SchStdContactInfo.findAll", query = "SELECT s FROM SchStdContactInfo s")})
public class SchStdContactInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_id")
    private Integer contactId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tel_no")
    private String telNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mobile_no")
    private String mobileNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "present_addr")
    private String presentAddr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "parmanent_addr")
    private String parmanentAddr;
    @JoinColumn(name = "std_id", referencedColumnName = "std_id")
    @ManyToOne(optional = false)
    private SchStudentInfo schStudentInfo;

    public SchStdContactInfo() {
    }

    public SchStdContactInfo(Integer contactId) {
        this.contactId = contactId;
    }

    public SchStdContactInfo(Integer contactId, String telNo, String mobileNo, String presentAddr, String parmanentAddr) {
        this.contactId = contactId;
        this.telNo = telNo;
        this.mobileNo = mobileNo;
        this.presentAddr = presentAddr;
        this.parmanentAddr = parmanentAddr;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPresentAddr() {
        return presentAddr;
    }

    public void setPresentAddr(String presentAddr) {
        this.presentAddr = presentAddr;
    }

    public String getParmanentAddr() {
        return parmanentAddr;
    }

    public void setParmanentAddr(String parmanentAddr) {
        this.parmanentAddr = parmanentAddr;
    }

    public SchStudentInfo getSchStudentInfo() {
        return schStudentInfo;
    }

    public void setSchStudentInfo(SchStudentInfo schStudentInfo) {
        this.schStudentInfo = schStudentInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchStdContactInfo)) {
            return false;
        }
        SchStdContactInfo other = (SchStdContactInfo) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchStdContactInfo[ contactId=" + contactId + " ]";
    }
    
}
