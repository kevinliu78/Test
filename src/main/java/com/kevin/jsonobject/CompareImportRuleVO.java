package com.kevin.jsonobject;

/**
 * @Program: common-model
 * @Description: 比对导入参数VO
 * @Author: Liuws
 * @Date: 2022-04-12 14:21:42
 **/
public class CompareImportRuleVO {

  //导入规则ID
  private Integer importRuleId;

  //当前规则ID
  private Integer currentRuleId;

  //文件名称
  private String fileName;
  //规则比对操作类型
  private Integer compareRuleOperationType;
  //合并文件名称
  private String mergeFileName;

  public CompareImportRuleVO() {
  }

  public CompareImportRuleVO(Integer importRuleId, Integer currentRuleId, String fileName, Integer compareRuleOperationType, String mergeFileName) {
    this.importRuleId = importRuleId;
    this.currentRuleId = currentRuleId;
    this.fileName = fileName;
    this.compareRuleOperationType = compareRuleOperationType;
    this.mergeFileName = mergeFileName;
  }

  public Integer getImportRuleId() {
    return importRuleId;
  }

  public void setImportRuleId(Integer importRuleId) {
    this.importRuleId = importRuleId;
  }

  public Integer getCurrentRuleId() {
    return currentRuleId;
  }

  public void setCurrentRuleId(Integer currentRuleId) {
    this.currentRuleId = currentRuleId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Integer getCompareRuleOperationType() {
    return compareRuleOperationType;
  }

  public void setCompareRuleOperationType(Integer compareRuleOperationType) {
    this.compareRuleOperationType = compareRuleOperationType;
  }

  public String getMergeFileName() {
    return mergeFileName;
  }

  public void setMergeFileName(String mergeFileName) {
    this.mergeFileName = mergeFileName;
  }
}
