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
@Table(name = "sch_class_time_table_line")
@NamedQueries({
    @NamedQuery(name = "SchClassTimeTableLine.findAll", query = "SELECT s FROM SchClassTimeTableLine s")})
public class SchClassTimeTableLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tt_line_id")
    private Integer ttLineId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ttday")
    private String ttday;
    @JoinColumn(name = "dpid", referencedColumnName = "dpid")
    @ManyToOne(optional = false)
    private SchDayPeriod schDayPeriod;
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne(optional = false)
    private SchSubject schSubject;
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    @ManyToOne(optional = false)
    private SchTeacherInfo schTeacherInfo;
    @JoinColumn(name = "ttid", referencedColumnName = "ttid")
    @ManyToOne(optional = false)
    private SchTimeTable schTimeTable;

    public SchClassTimeTableLine() {
    }

    public SchClassTimeTableLine(Integer ttLineId) {
        this.ttLineId = ttLineId;
    }

    public SchClassTimeTableLine(Integer ttLineId, String ttday) {
        this.ttLineId = ttLineId;
        this.ttday = ttday;
    }

    public Integer getTtLineId() {
        return ttLineId;
    }

    public void setTtLineId(Integer ttLineId) {
        this.ttLineId = ttLineId;
    }

    public String getTtday() {
        return ttday;
    }

    public void setTtday(String ttday) {
        this.ttday = ttday;
    }

    public SchDayPeriod getSchDayPeriod() {
        return schDayPeriod;
    }

    public void setSchDayPeriod(SchDayPeriod schDayPeriod) {
        this.schDayPeriod = schDayPeriod;
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

    public SchTimeTable getSchTimeTable() {
        return schTimeTable;
    }

    public void setSchTimeTable(SchTimeTable schTimeTable) {
        this.schTimeTable = schTimeTable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttLineId != null ? ttLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchClassTimeTableLine)) {
            return false;
        }
        SchClassTimeTableLine other = (SchClassTimeTableLine) object;
        if ((this.ttLineId == null && other.ttLineId != null) || (this.ttLineId != null && !this.ttLineId.equals(other.ttLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchClassTimeTableLine[ ttLineId=" + ttLineId + " ]";
    }
    
}
