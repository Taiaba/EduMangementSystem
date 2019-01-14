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
import javax.persistence.Lob;
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
@Table(name = "sch_school_notice")
@NamedQueries({
    @NamedQuery(name = "SchSchoolNotice.findAll", query = "SELECT s FROM SchSchoolNotice s")})
public class SchSchoolNotice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notice_id")
    private Integer noticeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "notice_title")
    private String noticeTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "notice")
    private String notice;
    @Lob
    @Column(name = "notice_img")
    private byte[] noticeImg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expire_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;

    public SchSchoolNotice() {
    }

    public SchSchoolNotice(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public SchSchoolNotice(Integer noticeId, String noticeTitle, String notice, Date publishDate, Date expireDate) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.notice = notice;
        this.publishDate = publishDate;
        this.expireDate = expireDate;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public byte[] getNoticeImg() {
        return noticeImg;
    }

    public void setNoticeImg(byte[] noticeImg) {
        this.noticeImg = noticeImg;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noticeId != null ? noticeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchSchoolNotice)) {
            return false;
        }
        SchSchoolNotice other = (SchSchoolNotice) object;
        if ((this.noticeId == null && other.noticeId != null) || (this.noticeId != null && !this.noticeId.equals(other.noticeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchSchoolNotice[ noticeId=" + noticeId + " ]";
    }
    
}
