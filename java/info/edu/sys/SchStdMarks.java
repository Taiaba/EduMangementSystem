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
@Table(name = "sch_std_marks")
@NamedQueries({
    @NamedQuery(name = "SchStdMarks.findAll", query = "SELECT s FROM SchStdMarks s")})
public class SchStdMarks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "marks_id")
    private Integer marksId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_roll_no")
    private int stdRollNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marks_obtain")
    private int marksObtain;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sub_grade")
    private String subGrade;
    @JoinColumn(name = "acyid", referencedColumnName = "acyid")
    @ManyToOne(optional = false)
    private SchAcademicYear schAcademicYear;
    @JoinColumn(name = "ex_tt_id", referencedColumnName = "ex_tt_id")
    @ManyToOne(optional = false)
    private SchExamTitle schExamTitle;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private SchStdGroup schStdGroup;
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    @ManyToOne(optional = false)
    private SchSectionName schSectionName;
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne(optional = false)
    private SchSubject schSubject;

    public SchStdMarks() {
    }

    public SchStdMarks(Integer marksId) {
        this.marksId = marksId;
    }

    public SchStdMarks(Integer marksId, int stdRollNo, int marksObtain, String subGrade) {
        this.marksId = marksId;
        this.stdRollNo = stdRollNo;
        this.marksObtain = marksObtain;
        this.subGrade = subGrade;
    }

    public Integer getMarksId() {
        return marksId;
    }

    public void setMarksId(Integer marksId) {
        this.marksId = marksId;
    }

    public int getStdRollNo() {
        return stdRollNo;
    }

    public void setStdRollNo(int stdRollNo) {
        this.stdRollNo = stdRollNo;
    }

    public int getMarksObtain() {
        return marksObtain;
    }

    public void setMarksObtain(int marksObtain) {
        this.marksObtain = marksObtain;
    }

    public String getSubGrade() {
        return subGrade;
    }

    public void setSubGrade(String subGrade) {
        this.subGrade = subGrade;
    }

    public SchAcademicYear getSchAcademicYear() {
        return schAcademicYear;
    }

    public void setSchAcademicYear(SchAcademicYear schAcademicYear) {
        this.schAcademicYear = schAcademicYear;
    }

    public SchExamTitle getSchExamTitle() {
        return schExamTitle;
    }

    public void setSchExamTitle(SchExamTitle schExamTitle) {
        this.schExamTitle = schExamTitle;
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

    public SchSubject getSchSubject() {
        return schSubject;
    }

    public void setSchSubject(SchSubject schSubject) {
        this.schSubject = schSubject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marksId != null ? marksId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchStdMarks)) {
            return false;
        }
        SchStdMarks other = (SchStdMarks) object;
        if ((this.marksId == null && other.marksId != null) || (this.marksId != null && !this.marksId.equals(other.marksId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchStdMarks[ marksId=" + marksId + " ]";
    }
    
}
