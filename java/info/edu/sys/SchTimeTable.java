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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "sch_time_table")
@NamedQueries({
    @NamedQuery(name = "SchTimeTable.findAll", query = "SELECT s FROM SchTimeTable s")})
public class SchTimeTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ttid")
    private Integer ttid;
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @ManyToOne(optional = false)
    private SchClassName schClassName;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private SchStdGroup schStdGroup;
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    @ManyToOne(optional = false)
    private SchSectionName schSectionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schTimeTable")
    private Collection<SchClassTimeTableLine> schClassTimeTableLineCollection;

    public SchTimeTable() {
    }

    public SchTimeTable(Integer ttid) {
        this.ttid = ttid;
    }

    public Integer getTtid() {
        return ttid;
    }

    public void setTtid(Integer ttid) {
        this.ttid = ttid;
    }

    public SchClassName getSchClassName() {
        return schClassName;
    }

    public void setSchClassName(SchClassName schClassName) {
        this.schClassName = schClassName;
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

    public Collection<SchClassTimeTableLine> getSchClassTimeTableLineCollection() {
        return schClassTimeTableLineCollection;
    }

    public void setSchClassTimeTableLineCollection(Collection<SchClassTimeTableLine> schClassTimeTableLineCollection) {
        this.schClassTimeTableLineCollection = schClassTimeTableLineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttid != null ? ttid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchTimeTable)) {
            return false;
        }
        SchTimeTable other = (SchTimeTable) object;
        if ((this.ttid == null && other.ttid != null) || (this.ttid != null && !this.ttid.equals(other.ttid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchTimeTable[ ttid=" + ttid + " ]";
    }
    
}
