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

/**
 *
 * @author RT
 */
@Entity
@Table(name = "sch_teacher_sub_assign")
@NamedQueries({
    @NamedQuery(name = "SchTeacherSubAssign.findAll", query = "SELECT s FROM SchTeacherSubAssign s")})
public class SchTeacherSubAssign implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teach_sub_assign_id")
    private Integer teachSubAssignId;
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    @ManyToOne(optional = false)
    private SchSectionName schSectionName;
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne(optional = false)
    private SchSubject schSubject;
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    @ManyToOne(optional = false)
    private SchTeacherInfo schTeacherInfo;

    public SchTeacherSubAssign() {
    }

    public SchTeacherSubAssign(Integer teachSubAssignId) {
        this.teachSubAssignId = teachSubAssignId;
    }

    public Integer getTeachSubAssignId() {
        return teachSubAssignId;
    }

    public void setTeachSubAssignId(Integer teachSubAssignId) {
        this.teachSubAssignId = teachSubAssignId;
    }

    public SchSectionName getSchSectionName() {
        return schSectionName;
    }

    public void setSchSectionName(SchSectionName schSectionName) {
        this.schSectionName = schSectionName;
    }

    public SchSubject getSchSubject() {
        return schSubject;
    }

    public void setSchSubject(SchSubject schSubject) {
        this.schSubject = schSubject;
    }

    public SchTeacherInfo getSchTeacherInfo() {
        return schTeacherInfo;
    }

    public void setSchTeacherInfo(SchTeacherInfo schTeacherInfo) {
        this.schTeacherInfo = schTeacherInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teachSubAssignId != null ? teachSubAssignId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchTeacherSubAssign)) {
            return false;
        }
        SchTeacherSubAssign other = (SchTeacherSubAssign) object;
        if ((this.teachSubAssignId == null && other.teachSubAssignId != null) || (this.teachSubAssignId != null && !this.teachSubAssignId.equals(other.teachSubAssignId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchTeacherSubAssign[ teachSubAssignId=" + teachSubAssignId + " ]";
    }
    
}
