/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.cd_entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jinliang.xue
 */
@Entity
@Table(name = "CD_PLACE_ALIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdPlaceAlias.findAll", query = "SELECT c FROM CdPlaceAlias c"),
    @NamedQuery(name = "CdPlaceAlias.findById", query = "SELECT c FROM CdPlaceAlias c WHERE c.id = :id"),
    @NamedQuery(name = "CdPlaceAlias.findByAliasName", query = "SELECT c FROM CdPlaceAlias c WHERE c.aliasName = :aliasName")})
public class CdPlaceAlias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 35)
    @Column(name = "ALIAS_NAME")
    private String aliasName;
    @JoinColumn(name = "PLACE_CODE", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private CdPlace placeCode;

    public CdPlaceAlias() {
    }

    public CdPlaceAlias(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public CdPlace getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(CdPlace placeCode) {
        this.placeCode = placeCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdPlaceAlias)) {
            return false;
        }
        CdPlaceAlias other = (CdPlaceAlias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CdPlaceAlias[ id=" + id + " ]";
    }
    
}
