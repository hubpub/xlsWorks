/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.cd_entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CD_PLACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdPlace.findAll", query = "SELECT c FROM CdPlace c"),
    @NamedQuery(name = "CdPlace.findByCode", query = "SELECT c FROM CdPlace c WHERE c.code = :code"),
    @NamedQuery(name = "CdPlace.findByName", query = "SELECT c FROM CdPlace c WHERE c.name = :name"),
    @NamedQuery(name = "CdPlace.findByBasePortFlag", query = "SELECT c FROM CdPlace c WHERE c.basePortFlag = :basePortFlag"),
    @NamedQuery(name = "CdPlace.findByInLccFlag", query = "SELECT c FROM CdPlace c WHERE c.inLccFlag = :inLccFlag"),
    @NamedQuery(name = "CdPlace.findByIsDeactivityPlace", query = "SELECT c FROM CdPlace c WHERE c.isDeactivityPlace = :isDeactivityPlace"),
    @NamedQuery(name = "CdPlace.findByCity", query = "SELECT c FROM CdPlace c WHERE c.city = :city"),
    @NamedQuery(name = "CdPlace.findByProvince", query = "SELECT c FROM CdPlace c WHERE c.province = :province"),
    @NamedQuery(name = "CdPlace.findByIsInlandPoint", query = "SELECT c FROM CdPlace c WHERE c.isInlandPoint = :isInlandPoint"),
    @NamedQuery(name = "CdPlace.findByTwoLetterCode", query = "SELECT c FROM CdPlace c WHERE c.twoLetterCode = :twoLetterCode"),
    @NamedQuery(name = "CdPlace.findByThreeLetterCode", query = "SELECT c FROM CdPlace c WHERE c.threeLetterCode = :threeLetterCode"),
    @NamedQuery(name = "CdPlace.findByLat", query = "SELECT c FROM CdPlace c WHERE c.lat = :lat"),
    @NamedQuery(name = "CdPlace.findByLng", query = "SELECT c FROM CdPlace c WHERE c.lng = :lng"),
    @NamedQuery(name = "CdPlace.findByIsEuPort", query = "SELECT c FROM CdPlace c WHERE c.isEuPort = :isEuPort"),
    @NamedQuery(name = "CdPlace.findByTimeZone", query = "SELECT c FROM CdPlace c WHERE c.timeZone = :timeZone")})
public class CdPlace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CODE")
    private String code;
    @Size(max = 35)
    @Column(name = "NAME")
    private String name;
    @Column(name = "BASE_PORT_FLAG")
    private Short basePortFlag;
    @Column(name = "IN_LCC_FLAG")
    private Character inLccFlag;
    @Column(name = "IS_DEACTIVITY_PLACE")
    private Character isDeactivityPlace;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "IS_INLAND_POINT")
    private Short isInlandPoint;
    @Size(max = 2)
    @Column(name = "TWO_LETTER_CODE")
    private String twoLetterCode;
    @Size(max = 3)
    @Column(name = "THREE_LETTER_CODE")
    private String threeLetterCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LAT")
    private BigDecimal lat;
    @Column(name = "LNG")
    private BigDecimal lng;
    @Column(name = "IS_EU_PORT")
    private Character isEuPort;
    @Size(max = 3)
    @Column(name = "TIME_ZONE")
    private String timeZone;
    @JoinColumn(name = "AREA_CODE", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private CdArea areaCode;
    @JoinColumn(name = "COUNTRY_CODE", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private CdCountry countryCode;
    @JoinColumn(name = "LCC_CODE", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private CdLcc lccCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeCode")
    private Collection<CdPlaceAlias> cdPlaceAliasCollection;

    public CdPlace() {
    }

    public CdPlace(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getBasePortFlag() {
        return basePortFlag;
    }

    public void setBasePortFlag(Short basePortFlag) {
        this.basePortFlag = basePortFlag;
    }

    public Character getInLccFlag() {
        return inLccFlag;
    }

    public void setInLccFlag(Character inLccFlag) {
        this.inLccFlag = inLccFlag;
    }

    public Character getIsDeactivityPlace() {
        return isDeactivityPlace;
    }

    public void setIsDeactivityPlace(Character isDeactivityPlace) {
        this.isDeactivityPlace = isDeactivityPlace;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Short getIsInlandPoint() {
        return isInlandPoint;
    }

    public void setIsInlandPoint(Short isInlandPoint) {
        this.isInlandPoint = isInlandPoint;
    }

    public String getTwoLetterCode() {
        return twoLetterCode;
    }

    public void setTwoLetterCode(String twoLetterCode) {
        this.twoLetterCode = twoLetterCode;
    }

    public String getThreeLetterCode() {
        return threeLetterCode;
    }

    public void setThreeLetterCode(String threeLetterCode) {
        this.threeLetterCode = threeLetterCode;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public Character getIsEuPort() {
        return isEuPort;
    }

    public void setIsEuPort(Character isEuPort) {
        this.isEuPort = isEuPort;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public CdArea getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(CdArea areaCode) {
        this.areaCode = areaCode;
    }

    public CdCountry getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CdCountry countryCode) {
        this.countryCode = countryCode;
    }

    public CdLcc getLccCode() {
        return lccCode;
    }

    public void setLccCode(CdLcc lccCode) {
        this.lccCode = lccCode;
    }

    @XmlTransient
    public Collection<CdPlaceAlias> getCdPlaceAliasCollection() {
        return cdPlaceAliasCollection;
    }

    public void setCdPlaceAliasCollection(Collection<CdPlaceAlias> cdPlaceAliasCollection) {
        this.cdPlaceAliasCollection = cdPlaceAliasCollection;
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
        if (!(object instanceof CdPlace)) {
            return false;
        }
        CdPlace other = (CdPlace) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CdPlace[ code=" + code + " ]";
    }
    
}
