/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.utils;

/**
 *
 * @author jinliang.xue
 */
public class insertItems {

    public boolean insert(String POR, String POL, String POD, String DEL,
            String VIA01, String VIA02, String VIA03, String VIA04, String routeCode,
            String routeDescription, int routeTransitTime, String routeTransitTimeUnit, boolean isActive) {
        String sqlString = "INSERT INTO CD_SEA_ROUTING_TABLE "
//                + "(ROUTE_CODE, ROUTE_NAME, POL, VIA_PORT1, VIA_PORT2, VIA_PORT3, VIA_PORT4, POD, ROUTE_TRANSIT_TIME,TRANSIT_TIME_UNIT, IS_DEACTIVITY_ROUTING)"
                + "VALUES ("
                + "'" + routeCode + "',"
                + "'" + routeDescription + "',"
                + "'" + POL + "',"
                + "'" + VIA01 + "',"
                + "'" + VIA02 + "',"
                + "'" + VIA03 + "',"
                + "'" + VIA04 + "',"
                + "'" + POD + "',"
                + "'" + routeTransitTime + "',"
                + "'" + routeTransitTimeUnit + "',"
                + "'" + isActive + "')";
        System.out.println(sqlString);
        return false;
    }

}
