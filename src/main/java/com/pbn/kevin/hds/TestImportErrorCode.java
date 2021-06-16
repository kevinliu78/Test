package com.pbn.kevin.hds;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

/**
 * @Author: LWS
 * @Date: 2021/1/27 17:24
 */
public class TestImportErrorCode {

    public static void main(String[] args) {
        String path = "doc/IMPORT_HDS_ERROR_CODE_0128.xlsx";
        File file = new File(path);
        try {
            Workbook wb = createWorkbook("IMPORT_HDS_ERROR_CODE_0128.xlsx", new FileInputStream(file));
            for (int i = 0; i < 3; i++) {
                try {
                    Sheet sheet1 = wb.getSheetAt(i);
                    String sheetName = sheet1.getSheetName();
                    String outputPath = "doc/HDS_ERROR_CODE_" + sheetName + "_new.txt";
                    File outdatafile = new File(outputPath);
                    if (!outdatafile.exists()) {
                        outdatafile.createNewFile();
                    }
                    FileOutputStream cmout = new FileOutputStream(outdatafile);
                    BufferedWriter cmwriter = new BufferedWriter(new OutputStreamWriter(cmout));
                    for (Iterator<Row> rows = sheet1.rowIterator(); rows.hasNext(); ) {
                        try {
                            Row row = rows.next();
                            //row num start from 0
                            if (row.getRowNum() < 1) {
                                // jump the title
                                continue;
                            }
                            boolean isNullRow = true;
                            /* The null cell is not in row.cellIterator()*/
                            for (Iterator<Cell> cells = row.cellIterator(); cells.hasNext(); ) {
                                Cell cell = cells.next();
                                String value = cell.getCellType() == Cell.CELL_TYPE_NUMERIC ? cell.getNumericCellValue() + "" : cell.getStringCellValue().trim();
                                if (!value.equals("")) {
                                    isNullRow = false;
                                }
                            }
                            if (!isNullRow) {
                                Cell errorDescCell = row.getCell(0);
                                String errorDesc = "";
                                if (errorDescCell != null) {
                                    errorDesc = errorDescCell.getStringCellValue().trim();
                                }
                                Cell errorCodeCell = row.getCell(1);
                                String errorCode = "";
                                if (errorCodeCell != null) {
                                    errorCode = errorCodeCell.getCellType() == Cell.CELL_TYPE_NUMERIC ? (int) (errorCodeCell.getNumericCellValue()) + "" : errorCodeCell.getStringCellValue().trim();
                                    errorCode = errorCode.replaceAll("[XxYy]", "%");
                                    if (errorCode.contains("%")){
                                        errorCode = errorCode.substring(0, errorCode.indexOf("%"));
                                    }
                                }
                                Cell errorLevelCell = row.getCell(2);
                                String errorLevel = "";
                                if (errorLevelCell != null) {
                                    errorLevel = errorLevelCell.getStringCellValue().trim();
                                }
                                String text = errorDesc + "||" + errorCode + "||" + errorLevel;
                                cmwriter.write(text);
                                cmwriter.flush();
                                cmwriter.newLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
//                cmout.close();
//                cmwriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getEventLevel(String errorLevel) {
        try {
            String eventLevel = "";
            switch (errorLevel) {
                case "Service":
                    eventLevel = EventLevelEnum.WARN.getDesc();
                    break;
                case "Moderate":
                    eventLevel = EventLevelEnum.WILL.getDesc();
                    break;
                case "Serious":
                    eventLevel = EventLevelEnum.IMPORTANT.getDesc();
                    break;
                case "Acute":
                    eventLevel = EventLevelEnum.EMERGENCY.getDesc();
                    break;
                default:
                    eventLevel = EventLevelEnum.PROMPT.getDesc();
                    break;
            }
            return eventLevel;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    private static Workbook createWorkbook(String fileName, InputStream is) throws IOException {
        if (fileName.endsWith(".xls")) {
            return new HSSFWorkbook(is);
        } else if (fileName.endsWith(".xlsx")) {
            return new XSSFWorkbook(is);
        }
        return null;
    }
}
