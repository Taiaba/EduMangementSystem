/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.edu.sys;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "sch_std_attendance")
@NamedQueries({
    @NamedQuery(name = "SchStdAttendance.findAll", query = "SELECT s FROM SchStdAttendance s")})
public class SchStdAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attend_id")
    private Integer attendId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_roll_no")
    private int stdRollNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attend_date")
    @Temporal(TemporalType.DATE)
    private Date attendDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attend_status")
    private boolean attendStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "reason")
    private String reason;
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

    public SchStdAttendance() {
    }

    public SchStdAttendance(Integer attendId) {
        this.attendId = attendId;
    }

    public SchStdAttendance(Integer attendId, int stdRollNo, Date attendDate, boolean attendStatus, String reason) {
        this.attendId = attendId;
        this.stdRollNo = stdRollNo;
        this.attendDate = attendDate;
        this.attendStatus = attendStatus;
        this.reason = reason;
    }

    public Integer getAttendId() {
        return attendId;
    }

    public void setAttendId(Integer attendId) {
        this.attendId = attendId;
    }

    public int getStdRollNo() {
        return stdRollNo;
    }

    public void setStdRollNo(int stdRollNo) {
        this.stdRollNo = stdRollNo;
    }

    public Date getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(Date attendDate) {
        this.attendDate = attendDate;
    }

    public boolean getAttendStatus() {
        return attendStatus;
    }

    public void setAttendStatus(boolean attendStatus) {
        this.attendStatus = attendStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendId != null ? attendId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchStdAttendance)) {
            return false;
        }
        SchStdAttendance other = (SchStdAttendance) object;
        if ((this.attendId == null && other.attendId != null) || (this.attendId != null && !this.attendId.equals(other.attendId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchStdAttendance[ attendId=" + attendId + " ]";
    }
    
}
