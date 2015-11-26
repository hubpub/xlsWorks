/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.profile;

import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author jinliang.xue
 */
public class XlsFileConfig implements Config {

    XlsFileConfig xlsFileConfig;

    String ExcelFileName;

    String worksheet;

    Cell[][] titleArea;

    String endWith;

    @Override
    public void setExcelFileName(String ExcelFileName) {
        this.ExcelFileName=ExcelFileName;
    }

    @Override
    public void setWorksheet(String worksheet) {
        this.worksheet=worksheet;
    }

    @Override
    public void setTitleArea(Cell c1, Cell d2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEndWith(String endWith) {
        this.endWith=endWith;
    }

}
