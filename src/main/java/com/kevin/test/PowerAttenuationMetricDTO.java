package com.kevin.test;

/**
 * @Program: monitor-center
 * @Description:
 * @Author: Liuws
 * @Date: 2021-09-17 18:28:58
 **/
public class PowerAttenuationMetricDTO {

  private Integer alarmLevel;

  private Double lower4;
  private Double lower8;
  private Double lower16;

  public PowerAttenuationMetricDTO() {
  }

  public PowerAttenuationMetricDTO(Integer alarmLevel, Double lower4, Double lower8, Double lower16) {
    this.alarmLevel = alarmLevel;
    this.lower4 = lower4;
    this.lower8 = lower8;
    this.lower16 = lower16;
  }

  public Integer getAlarmLevel() {
    return alarmLevel;
  }

  public void setAlarmLevel(Integer alarmLevel) {
    this.alarmLevel = alarmLevel;
  }

  public Double getLower4() {
    return lower4;
  }

  public void setLower4(Double lower4) {
    this.lower4 = lower4;
  }

  public Double getLower8() {
    return lower8;
  }

  public void setLower8(Double lower8) {
    this.lower8 = lower8;
  }

  public Double getLower16() {
    return lower16;
  }

  public void setLower16(Double lower16) {
    this.lower16 = lower16;
  }
}
