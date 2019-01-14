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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "sch_user")
@NamedQueries({
    @NamedQuery(name = "SchUser.findAll", query = "SELECT s FROM SchUser s")})
public class SchUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "uname")
    private String uname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private boolean isactive;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private SchUserRole schUserRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schUser")
    private Collection<SchStudentInfo> schStudentInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schUser")
    private Collection<SchTeacherInfo> schTeacherInfoCollection;

    public SchUser() {
    }

    public SchUser(Integer userId) {
        this.userId = userId;
    }

    public SchUser(Integer userId, String uname, String password, boolean isactive) {
        this.userId = userId;
        this.uname = uname;
        this.password = password;
        this.isactive = isactive;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public SchUserRole getSchUserRole() {
        return schUserRole;
    }

    public void setSchUserRole(SchUserRole schUserRole) {
        this.schUserRole = schUserRole;
    }

    public Collection<SchStudentInfo> getSchStudentInfoCollection() {
        return schStudentInfoCollection;
    }

    public void setSchStudentInfoCollection(Collection<SchStudentInfo> schStudentInfoCollection) {
        this.schStudentInfoCollection = schStudentInfoCollection;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchUser)) {
            return false;
        }
        SchUser other = (SchUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchUser[ userId=" + userId + " ]";
    }
    
}
