/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.cd_entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jinliang.xue
 */
@Entity
@Table(name = "CD_COUNTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdCountry.findAll", query = "SELECT c FROM CdCountry c"),
    @NamedQuery(name = "CdCountry.findByCode", query = "SELECT c FROM CdCountry c WHERE c.code = :code"),
    @NamedQuery(name = "CdCountry.findByBaseCurrencyCode", query = "SELECT c FROM CdCountry c WHERE c.baseCurrencyCode = :baseCurrencyCode"),
    @NamedQuery(name = "CdCountry.findByDescription", query = "SELECT c FROM CdCountry c WHERE c.description = :description")})
public class CdCountry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODE")
    private String code;
    @Size(max = 3)
    @Column(name = "BASE_CURRENCY_CODE")
    private String baseCurrencyCode;
    @Size(max = 30)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryCode")
    private Collection<CdPlace> cdPlaceCollection;

    public CdCountry() {
    }

    public CdCountry(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<CdPlace> getCdPlaceCollection() {
        return cdPlaceCollection;
    }

    public void setCdPlaceCollection(Collection<CdPlace> cdPlaceCollection) {
        this.cdPlaceCollection = cdPlaceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdCountry)) {
            return false;
        }
        CdCountry other = (CdCountry) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CdCountry[ code=" + code + " ]";
    }
    
}
