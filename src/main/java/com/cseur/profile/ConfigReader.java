/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cseur.profile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jinliang.xue
 *
 */
public class ConfigReader {

    File configFile;
    List<XlsFileConfig> sftpconfig = new ArrayList<>();

    public List<XlsFileConfig> getProfile(File configFile) {

        try {
            for (String line : Files.readAllLines(configFile.toPath(), (Charset.forName("utf-8")))) {
                //split for content by "'"
                if (!line.startsWith("#") && !line.isEmpty()) {
                    String[] fields = line.split(";");
                    if (fields.length > 2) {
                        XlsFileConfig _xlsFileConfig = new XlsFileConfig();
                        String value = fields[1];
                        _xlsFileConfig.setExcelFileName(fields[0]);
                        _xlsFileConfig.setWorksheet(fields[1]);

                        String[] titleArea = fields[2].split(":");
                        if (titleArea.length > 2 && (titleArea[0].isEmpty() && titleArea[1].isEmpty() && titleArea[2].isEmpty())) {
                            if (isVerticalTitle(titleArea)) {
                                _xlsFileConfig.setWorksheet(fields[2]);
                            } else if (isHorizontalTitle(titleArea)) {

                            } else if (is2DTitle(titleArea)) {

                            } else {

                            }

                        }

                    }
                }
            }
        } catch (IOException ex) {
        }
        return sftpconfig;
    }

    private boolean isVerticalTitle(String[] titleArea) {
        return titleArea[0].isEmpty() && !titleArea[1].isEmpty();
    }

    private boolean isHorizontalTitle(String[] titleArea) {
        return !titleArea[0].isEmpty() && titleArea[1].isEmpty();
    }

    private boolean is2DTitle(String[] titleArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
