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
@Table(name = "sch_teacher_grade")
@NamedQueries({
    @NamedQuery(name = "SchTeacherGrade.findAll", query = "SELECT s FROM SchTeacherGrade s")})
public class SchTeacherGrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teacher_grade_id")
    private Integer teacherGradeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "teacher_grade")
    private String teacherGrade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schTeacherGrade")
    private Collection<SchTeacherInfo> schTeacherInfoCollection;

    public SchTeacherGrade() {
    }

    public SchTeacherGrade(Integer teacherGradeId) {
        this.teacherGradeId = teacherGradeId;
    }

    public SchTeacherGrade(Integer teacherGradeId, String teacherGrade) {
        this.teacherGradeId = teacherGradeId;
        this.teacherGrade = teacherGrade;
    }

    public Integer getTeacherGradeId() {
        return teacherGradeId;
    }

    public void setTeacherGradeId(Integer teacherGradeId) {
        this.teacherGradeId = teacherGradeId;
    }

    public String getTeacherGrade() {
        return teacherGrade;
    }

    public void setTeacherGrade(String teacherGrade) {
        this.teacherGrade = teacherGrade;
    }

    public Collection<SchTeacherInfo> getSchTeacherInfoCollection() {
        return schTeacherInfoCollection;
    }

    public void setSchTeacherInfoCollection(Collection<SchTeacherInfo> schTeacherInfoCollection) {
        this.schTeacherInfoCollection = schTeacherInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherGradeId != null ? teacherGradeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchTeacherGrade)) {
            return false;
        }
        SchTeacherGrade other = (SchTeacherGrade) object;
        if ((this.teacherGradeId == null && other.teacherGradeId != null) || (this.teacherGradeId != null && !this.teacherGradeId.equals(other.teacherGradeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchTeacherGrade[ teacherGradeId=" + teacherGradeId + " ]";
    }
    
}
