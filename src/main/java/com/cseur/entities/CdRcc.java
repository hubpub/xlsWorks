/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.entities;

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
@Table(name = "CD_RCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdRcc.findAll", query = "SELECT c FROM CdRcc c"),
    @NamedQuery(name = "CdRcc.findByCode", query = "SELECT c FROM CdRcc c WHERE c.code = :code"),
    @NamedQuery(name = "CdRcc.findByDescription", query = "SELECT c FROM CdRcc c WHERE c.description = :description")})
public class CdRcc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODE")
    private String code;
    @Size(max = 30)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rccCode")
    private Collection<CdLcc> cdLccCollection;

    public CdRcc() {
    }

    public CdRcc(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<CdLcc> getCdLccCollection() {
        return cdLccCollection;
    }

    public void setCdLccCollection(Collection<CdLcc> cdLccCollection) {
        this.cdLccCollection = cdLccCollection;
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
        if (!(object instanceof CdRcc)) {
            return false;
        }
        CdRcc other = (CdRcc) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CdRcc[ code=" + code + " ]";
    }
    
}
