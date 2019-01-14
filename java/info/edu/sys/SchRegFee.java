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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "sch_reg_fee")
@NamedQueries({
    @NamedQuery(name = "SchRegFee.findAll", query = "SELECT s FROM SchRegFee s")})
public class SchRegFee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fee_id")
    private Integer feeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fee_amount")
    private double feeAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pay_date")
    @Temporal(TemporalType.DATE)
    private Date payDate;
    @JoinColumn(name = "reg_id", referencedColumnName = "reg_id")
    @ManyToOne(optional = false)
    private SchStdRegistration schStdRegistration;

    public SchRegFee() {
    }

    public SchRegFee(Integer feeId) {
        this.feeId = feeId;
    }

    public SchRegFee(Integer feeId, double feeAmount, Date payDate) {
        this.feeId = feeId;
        this.feeAmount = feeAmount;
        this.payDate = payDate;
    }

    public Integer getFeeId() {
        return feeId;
    }

    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public SchStdRegistration getSchStdRegistration() {
        return schStdRegistration;
    }

    public void setSchStdRegistration(SchStdRegistration schStdRegistration) {
        this.schStdRegistration = schStdRegistration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feeId != null ? feeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchRegFee)) {
            return false;
        }
        SchRegFee other = (SchRegFee) object;
        if ((this.feeId == null && other.feeId != null) || (this.feeId != null && !this.feeId.equals(other.feeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.edu.sys.SchRegFee[ feeId=" + feeId + " ]";
    }
    
}
