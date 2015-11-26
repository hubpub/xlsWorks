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
public interface Config {
/**
 * 
 * @param ExcelFileName excel file name, with extension, without path
 */
    void setExcelFileName(String ExcelFileName);

    void setWorksheet(String worksheet);

    void setTitleArea(Cell c1, Cell d2);
    
    void setEndWith(String endWith);

}
