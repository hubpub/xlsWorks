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
    List<XlsFileConfig> xlsVariablesConfig = new ArrayList<>();

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

                        String[] contentTitle = fields[2].split(":", -1);
                        if (contentTitle.length > 2 && !(contentTitle[0].isEmpty() && contentTitle[1].isEmpty())) {
                            String[] titlePositions = new String[2];
                            System.arraycopy(contentTitle, 0, titlePositions, 0, 2);
                            _xlsFileConfig.setTitlePositions(titlePositions);
                            _xlsFileConfig.setEndWith(contentTitle[2]);
                            //add to config only when pass all tests.
                            xlsVariablesConfig.add(_xlsFileConfig);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.printf(ex.toString());
        }
        return xlsVariablesConfig;
    }

}
