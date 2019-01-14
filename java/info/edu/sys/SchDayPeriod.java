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
@Table(name = "sch_day_period")
@NamedQueries({
    @NamedQuery(name = "SchDayPeriod.findAll", query = "SELECT s FROM SchDayPeriod s")})
public class SchDayPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dpid")
    private Integer dpid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dptime")
    private String dptime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schDayPeriod")
    private Collection<SchClassTimeTableLine> schClassTimeTableLineCollection;

    public SchDayPeriod() {
    }

    public SchDayPeriod(Integer dpid) {
        this.dpid = dpid;
    }

    public SchDayPeriod(Integer dpid, String dptime) {
        this.dpid = dpid;
        this.dptime = dptime;
    }

    public Integer getDpid() {
        return dpid;
    }

    public void setDpid(Integer dpid) {
        this.dpid = dpid;
    }

    public String getDptime() {
        return dptime;
    }

    public void setDptime(String dptime) {
        this.dptime = dptime;
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
        hash += (dpid != null ? dpid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchDayPeriod)) {
            return false;
        }
        SchDayPeriod other = (SchDayPeriod) object;
        if ((this.dpid == null && other.dpid != null) || (this.dpid != null && !this.dpid.equals(other.dpid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchDayPeriod[ dpid=" + dpid + " ]";
    }
    
}
