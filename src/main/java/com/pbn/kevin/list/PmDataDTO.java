package com.pbn.kevin.list;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2021-12-07 14:18:41
 **/
public class PmDataDTO {

    private Double dataValue;

    private String dataTime;

    public PmDataDTO() {
    }

    public PmDataDTO(Double dataValue, String dataTime) {
        this.dataValue = dataValue;
        this.dataTime = dataTime;
    }

    public Double getDataValue() {
        return dataValue;
    }

    public void setDataValue(Double dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }
}
