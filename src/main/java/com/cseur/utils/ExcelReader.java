/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author jinliang.xue
 */
public class ExcelReader {

    /**
     * read xls file and return a list of obj values
     *
     * @param rrf
     */
    static ArrayList<String> tableHeader;
    ArrayList<ArrayList<String>> valueArrayList_X = new ArrayList<>();
    File xlsFile;

    public static void setTableHeader(String... headers) {
        for (String _header : headers) {
            tableHeader.add(_header);
        }
    }

    public static ArrayList<String> getTableHeader() {
        return tableHeader;
    }

    public void clearValueArrayList_X() {
        valueArrayList_X.clear();
    }

    public ArrayList<ArrayList<String>> getValueArrayList_X() {
        return valueArrayList_X;
    }

    public ArrayList<ArrayList<String>> readToMap() throws IOException {

        FileInputStream file = new FileInputStream(xlsFile);
        //Get the workbook instance for XLS file 
        HSSFWorkbook workbook = new HSSFWorkbook(file);

        //Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);

        //get pol pod via1 via2 via3 via4 index in column and saved to array
        ArrayList<Integer> portIndexs = new ArrayList(Arrays.asList(null, null, null, null, null, null, null));
        boolean isTableHeader = true;
        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            //read file, find the columnindex for required order, and then insert the value to valueArray.
            Row row = rowIterator.next();
//            //escape empty lines
            Iterator<Cell> cellIterator = row.cellIterator();
            if (isTableHeader) {
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //set absolute columnIndex in the order of POL, POD, VIA1.2.l.3.4
                    switch (cell.getStringCellValue().trim().toUpperCase()) {
                        case "POL":
                            portIndexs.set(0, cell.getColumnIndex());
                            break;
                        case "POD":
                            portIndexs.set(1, cell.getColumnIndex());
                            break;
                        case "VIA1":
                            portIndexs.set(2, cell.getColumnIndex());
                            break;
                        case "VIA2":
                            portIndexs.set(3, cell.getColumnIndex());
                            break;
                        case "VIA3":
                            portIndexs.set(4, cell.getColumnIndex());
                            break;
                        case "VIA4":
                            portIndexs.set(5, cell.getColumnIndex());
                            break;
//                    case "VIA5":
//                            portIndexs.add(cell.getColumnIndex());
//                        break;
//                    case "VIA6":
//                            portIndexs.add(cell.getColumnIndex());
//                        break;
//                    case "VIA7":
//                            portIndexs.add(cell.getColumnIndex());
//                        break;
//                    case "VIA8":
//                            portIndexs.add(cell.getColumnIndex());
//                        break;
//                    case "VIA9":
//                            portIndexs.add(cell.getColumnIndex());
//                        break;
//                    case "VIA0":
//                            portIndexs.add(cell.getColumnIndex());
//                        break;
                        }
//                    portIndexs.trimToSize();
                }
            }
            if (!isTableHeader) {
                ArrayList<String> valueArrayList = new ArrayList<>();
                for (int i = 0; portIndexs.get(i) != null; i++) {
                    if (row.getCell(portIndexs.get(i)) != null && !row.getCell(portIndexs.get(i)).getStringCellValue().isEmpty()) {
                        valueArrayList.add(row.getCell(portIndexs.get(i)).getStringCellValue().trim().toUpperCase());
                    }
                }
                System.out.println(valueArrayList.size());
                valueArrayList_X.add(valueArrayList);
                //reference added to arraylist. clear the valueArrayList remove the values in valueArrayList_X Too!!
                //valueArrayList.clear();
            }
            isTableHeader = false;//add contents to vector.
        }
        file.close();
        return valueArrayList_X;
    }

    public ExcelReader(File xlsFil) {
        this.xlsFile = xlsFil;
    }
}
