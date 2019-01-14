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
@Table(name = "sch_teacher_info")
@NamedQueries({
    @NamedQuery(name = "SchTeacherInfo.findAll", query = "SELECT s FROM SchTeacherInfo s")})
public class SchTeacherInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "teacher_name")
    private String teacherName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "teacher_mobile")
    private String teacherMobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "teacher_addr")
    private String teacherAddr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teacher_join_date")
    @Temporal(TemporalType.DATE)
    private Date teacherJoinDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "teacher_email")
    private String teacherEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispresent")
    private boolean ispresent;
    @Size(max = 45)
    @Column(name = "depart_date")
    private String departDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "teacher_photo")
    private byte[] teacherPhoto;
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne(optional = false)
    private SchSubject schSubject;
    @JoinColumn(name = "teacher_grade_id", referencedColumnName = "teacher_grade_id")
    @ManyToOne(optional = false)
    private SchTeacherGrade schTeacherGrade;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private SchUser schUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schTeacherInfo")
    private Collection<SchClassTimeTableLine> schClassTimeTableLineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schTeacherInfo")
    private Collection<SchTeacherSubAssign> schTeacherSubAssignCollection;

    public SchTeacherInfo() {
    }

    public SchTeacherInfo(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public SchTeacherInfo(Integer teacherId, String teacherName, String teacherMobile, String teacherAddr, Date teacherJoinDate, String teacherEmail, boolean ispresent, byte[] teacherPhoto) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherMobile = teacherMobile;
        this.teacherAddr = teacherAddr;
        this.teacherJoinDate = teacherJoinDate;
        this.teacherEmail = teacherEmail;
        this.ispresent = ispresent;
        this.teacherPhoto = teacherPhoto;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherMobile() {
        return teacherMobile;
    }

    public void setTeacherMobile(String teacherMobile) {
        this.teacherMobile = teacherMobile;
    }

    public String getTeacherAddr() {
        return teacherAddr;
    }

    public void setTeacherAddr(String teacherAddr) {
        this.teacherAddr = teacherAddr;
    }

    public Date getTeacherJoinDate() {
        return teacherJoinDate;
    }

    public void setTeacherJoinDate(Date teacherJoinDate) {
        this.teacherJoinDate = teacherJoinDate;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public boolean getIspresent() {
        return ispresent;
    }

    public void setIspresent(boolean ispresent) {
        this.ispresent = ispresent;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public byte[] getTeacherPhoto() {
        return teacherPhoto;
    }

    public void setTeacherPhoto(byte[] teacherPhoto) {
        this.teacherPhoto = teacherPhoto;
    }

    public SchSubject getSchSubject() {
        return schSubject;
    }

    public void setSchSubject(SchSubject schSubject) {
        this.schSubject = schSubject;
    }

    public SchTeacherGrade getSchTeacherGrade() {
        return schTeacherGrade;
    }

    public void setSchTeacherGrade(SchTeacherGrade schTeacherGrade) {
        this.schTeacherGrade = schTeacherGrade;
    }

    public SchUser getSchUser() {
        return schUser;
    }

    public void setSchUser(SchUser schUser) {
        this.schUser = schUser;
    }

    public Collection<SchClassTimeTableLine> getSchClassTimeTableLineCollection() {
        return schClassTimeTableLineCollection;
    }

    public void setSchClassTimeTableLineCollection(Collection<SchClassTimeTableLine> schClassTimeTableLineCollection) {
        this.schClassTimeTableLineCollection = schClassTimeTableLineCollection;
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
        hash += (teacherId != null ? teacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchTeacherInfo)) {
            return false;
        }
        SchTeacherInfo other = (SchTeacherInfo) object;
        if ((this.teacherId == null && other.teacherId != null) || (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchTeacherInfo[ teacherId=" + teacherId + " ]";
    }
    
}
