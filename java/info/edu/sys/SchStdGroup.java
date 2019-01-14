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
@Table(name = "sch_std_group")
@NamedQueries({
    @NamedQuery(name = "SchStdGroup.findAll", query = "SELECT s FROM SchStdGroup s")})
public class SchStdGroup implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schStdGroup")
    private Collection<SchStdRegistration> schStdRegistrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schStdGroup")
    private Collection<SchStdAttendance> schStdAttendanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schStdGroup")
    private Collection<SchTimeTable> schTimeTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schStdGroup")
    private Collection<SchStdMarks> schStdMarksCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id")
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "group_name")
    private String groupName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_status")
    private boolean groupStatus;

    public SchStdGroup() {
    }

    public SchStdGroup(Integer groupId) {
        this.groupId = groupId;
    }

    public SchStdGroup(Integer groupId, String groupName, boolean groupStatus) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupStatus = groupStatus;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(boolean groupStatus) {
        this.groupStatus = groupStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchStdGroup)) {
            return false;
        }
        SchStdGroup other = (SchStdGroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchStdGroup[ groupId=" + groupId + " ]";
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

    public Collection<SchTimeTable> getSchTimeTableCollection() {
        return schTimeTableCollection;
    }

    public void setSchTimeTableCollection(Collection<SchTimeTable> schTimeTableCollection) {
        this.schTimeTableCollection = schTimeTableCollection;
    }

    public Collection<SchStdMarks> getSchStdMarksCollection() {
        return schStdMarksCollection;
    }

    public void setSchStdMarksCollection(Collection<SchStdMarks> schStdMarksCollection) {
        this.schStdMarksCollection = schStdMarksCollection;
    }
    
}
