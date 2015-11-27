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
public class XlsFileConfig implements ConfigInterface {

    XlsFileConfig xlsFileConfig;

    String ExcelFileName;

    String worksheet;

    Cell[] titleArea = new Cell[2];
    String[] titlePositions = new String[2];

    String endWith;

    boolean isVertical;
    boolean isHorizontal;
    boolean is2DTitle;

    @Override
    public void setExcelFileName(String ExcelFileName) {
        this.ExcelFileName = ExcelFileName;
    }

    @Override
    public void setWorksheet(String worksheet) {
        this.worksheet = worksheet;
    }

    @Override
    public void setTitleArea(Cell[] cls) {
        this.titleArea = titleArea;
    }

    @Override
    public void setEndWith(String endWith) {
        this.endWith = endWith;
    }

    void setTitlePositions(String[] titlePositions) {
        this.titlePositions = titlePositions;
        setTitleProperties();

    }

    private boolean isVerticalTitle(String[] titleArea) {
        return isVertical;
    }

    private boolean isHorizontalTitle(String[] titleArea) {
        return isHorizontal;
    }

    private boolean is2DTitle(String[] titleArea) {
        return is2DTitle;
    }

    private void setTitleProperties() {
         if (!titlePositions[0].isEmpty() && titlePositions[1].isEmpty()) {
            isHorizontal = true;
        }
        if (titlePositions[0].isEmpty() && !titlePositions[1].isEmpty()) {
            isVertical = true;
        }
        
        if (!isVertical && !isHorizontal) {
            String _r0 = titlePositions[0].split("[0-9]+")[0];
            String _r1 = titlePositions[1].split("[0-9]+")[0];
            String _c0 = titlePositions[0].split("(?i)[a-z]+")[1];
            String _c1 = titlePositions[1].split("(?i)[a-z]+")[1];
            if ((_r0 == null ? _r1 == null : _r0.equals(_r1)) && (_c0 == null ? _c1 != null : !_c0.equals(_c1))) {
                isHorizontal = true;
            } else if ((_r0 == null ? _r1 != null : !_r0.equals(_r1)) && (_c0 == null ? _c1 == null : _c0.equals(_c1))) {
                isVertical = true;
            } else if ((_r0 == null ? _r1 != null : !_r0.equals(_r1)) && (_c0 == null ? _c1 != null : !_c0.equals(_c1))) {
                is2DTitle = true;
            } else if ((_r0 == null ? _r1 == null : _r0.equals(_r1)) && (_c0 == null ? _c1 == null : _c0.equals(_c1))) {
                //title is one cell
            }
        }
    }
}
