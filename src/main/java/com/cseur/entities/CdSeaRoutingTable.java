/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CD_SEA_ROUTING_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdSeaRoutingTable.findAll", query = "SELECT c FROM CdSeaRoutingTable c"),
    @NamedQuery(name = "CdSeaRoutingTable.findByRouteCode", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.routeCode = :routeCode"),
    @NamedQuery(name = "CdSeaRoutingTable.findByRouteName", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.routeName = :routeName"),
    @NamedQuery(name = "CdSeaRoutingTable.findByPol", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.pol = :pol"),
    @NamedQuery(name = "CdSeaRoutingTable.findByViaPort1", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.viaPort1 = :viaPort1"),
    @NamedQuery(name = "CdSeaRoutingTable.findByViaPort2", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.viaPort2 = :viaPort2"),
    @NamedQuery(name = "CdSeaRoutingTable.findByViaPort3", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.viaPort3 = :viaPort3"),
    @NamedQuery(name = "CdSeaRoutingTable.findByViaPort4", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.viaPort4 = :viaPort4"),
    @NamedQuery(name = "CdSeaRoutingTable.findByPod", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.pod = :pod"),
    @NamedQuery(name = "CdSeaRoutingTable.findByRouteTransitTime", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.routeTransitTime = :routeTransitTime"),
    @NamedQuery(name = "CdSeaRoutingTable.findByTransitTimeUnit", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.transitTimeUnit = :transitTimeUnit"),
    @NamedQuery(name = "CdSeaRoutingTable.findByIsDeactivityRouting", query = "SELECT c FROM CdSeaRoutingTable c WHERE c.isDeactivityRouting = :isDeactivityRouting")})
public class CdSeaRoutingTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ROUTE_CODE")
    private String routeCode;
    @Size(max = 30)
    @Column(name = "ROUTE_NAME")
    private String routeName;
    @Size(max = 5)
    @Column(name = "POL")
    private String pol;
    @Size(max = 5)
    @Column(name = "VIA_PORT1")
    private String viaPort1;
    @Size(max = 5)
    @Column(name = "VIA_PORT2")
    private String viaPort2;
    @Size(max = 5)
    @Column(name = "VIA_PORT3")
    private String viaPort3;
    @Size(max = 5)
    @Column(name = "VIA_PORT4")
    private String viaPort4;
    @Size(max = 5)
    @Column(name = "POD")
    private String pod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ROUTE_TRANSIT_TIME")
    private BigDecimal routeTransitTime;
    @Size(max = 2)
    @Column(name = "TRANSIT_TIME_UNIT")
    private String transitTimeUnit;
    @Column(name = "IS_DEACTIVITY_ROUTING")
    private Character isDeactivityRouting;

    public CdSeaRoutingTable() {
    }

    public CdSeaRoutingTable(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getViaPort1() {
        return viaPort1;
    }

    public void setViaPort1(String viaPort1) {
        this.viaPort1 = viaPort1;
    }

    public String getViaPort2() {
        return viaPort2;
    }

    public void setViaPort2(String viaPort2) {
        this.viaPort2 = viaPort2;
    }

    public String getViaPort3() {
        return viaPort3;
    }

    public void setViaPort3(String viaPort3) {
        this.viaPort3 = viaPort3;
    }

    public String getViaPort4() {
        return viaPort4;
    }

    public void setViaPort4(String viaPort4) {
        this.viaPort4 = viaPort4;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public BigDecimal getRouteTransitTime() {
        return routeTransitTime;
    }

    public void setRouteTransitTime(BigDecimal routeTransitTime) {
        this.routeTransitTime = routeTransitTime;
    }

    public String getTransitTimeUnit() {
        return transitTimeUnit;
    }

    public void setTransitTimeUnit(String transitTimeUnit) {
        this.transitTimeUnit = transitTimeUnit;
    }

    public Character getIsDeactivityRouting() {
        return isDeactivityRouting;
    }

    public void setIsDeactivityRouting(Character isDeactivityRouting) {
        this.isDeactivityRouting = isDeactivityRouting;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeCode != null ? routeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdSeaRoutingTable)) {
            return false;
        }
        CdSeaRoutingTable other = (CdSeaRoutingTable) object;
        if ((this.routeCode == null && other.routeCode != null) || (this.routeCode != null && !this.routeCode.equals(other.routeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CdSeaRoutingTable[ routeCode=" + routeCode + " ]";
    }
    
}
