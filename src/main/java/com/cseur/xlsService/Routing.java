/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.xlsService;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author jinliang.xue
 */
public class Routing implements Serializable, Cloneable {

    private Long id;
    private String POR;
    private String POL;
    private String POD;
    private String DEL;
    private String VIA01;
    private String VIA02;
    private String VIA03;
    private String VIA04;
    private String VIA05;
    private String VIA06;
    private String VIA07;
    private String VIA08;
    private String VIA09;
    //un-expected via port
    private String VIA00;

    private String routeCode;
    private String routeDescription;
    private int routeTransitTime;
    private String routeTransitTimeUnit;
    private boolean isActive;
    private Date lastUpdateDate;

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public Routing clone() throws CloneNotSupportedException {
        try {
            return (Routing) BeanUtils.cloneBean(this);
        } catch (Exception ex) {
            throw new CloneNotSupportedException();
        }
    }

    @Override
    public String toString() {
        return routeCode + POL + POD;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //email for feedback
    private String applierMail;

    public String getApplierMail() {
        return applierMail;
    }

    public void setApplierMail(String applierMail) {
        this.applierMail = applierMail;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteDescription() {
        return routeDescription;
    }

    public void setRouteDescription(String routeDescription) {
        this.routeDescription = routeDescription;
    }

    public int getRouteTransitTime() {
        return routeTransitTime;
    }

    public void setRouteTransitTime(int routeTransitTime) {
        this.routeTransitTime = routeTransitTime;
    }

    public String getRouteTransitTimeUnit() {
        return routeTransitTimeUnit;
    }

    public void setRouteTransitTimeUnit(String routeTransitTimeUnit) {
        this.routeTransitTimeUnit = routeTransitTimeUnit;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getPOR() {
        return POR;
    }

    public void setPOR(String POR) {
        this.POR = POR;
    }

    public String getPOL() {
        return POL;
    }

    public void setPOL(String POL) {
        this.POL = POL;
    }

    public String getPOD() {
        return POD;
    }

    public void setPOD(String POD) {
        this.POD = POD;
    }

    public String getDEL() {
        return DEL;
    }

    public void setDEL(String DEL) {
        this.DEL = DEL;
    }

    public String getVIA01() {
        return VIA01;
    }

    public void setVIA01(String VIA01) {
        this.VIA01 = VIA01;
    }

    public String getVIA02() {
        return VIA02;
    }

    public void setVIA02(String VIA02) {
        this.VIA02 = VIA02;
    }

    public String getVIA03() {
        return VIA03;
    }

    public void setVIA03(String VIA03) {
        this.VIA03 = VIA03;
    }

    public String getVIA04() {
        return VIA04;
    }

    public void setVIA04(String VIA04) {
        this.VIA04 = VIA04;
    }

    public String getVIA05() {
        return VIA05;
    }

    public void setVIA05(String VIA05) {
        this.VIA05 = VIA05;
    }

    public String getVIA06() {
        return VIA06;
    }

    public void setVIA06(String VIA06) {
        this.VIA06 = VIA06;
    }

    public String getVIA07() {
        return VIA07;
    }

    public void setVIA07(String VIA07) {
        this.VIA07 = VIA07;
    }

    public String getVIA08() {
        return VIA08;
    }

    public void setVIA08(String VIA08) {
        this.VIA08 = VIA08;
    }

    public String getVIA09() {
        return VIA09;
    }

    public void setVIA09(String VIA09) {
        this.VIA09 = VIA09;
    }

    public String getVIA10() {
        return VIA00;
    }

    public void setVIA10(String VIA10) {
        this.VIA00 = VIA10;
    }

}
