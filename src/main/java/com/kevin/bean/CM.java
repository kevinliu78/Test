package com.kevin.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Copyright (c) 2009, All rights reserved POJO for CM
 * 
 * @author
 * @version 2009-09-01 16:00:54.555
 */
public class CM implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public CM() {

	}


	// The three parameters below for HCM
	private String col_time;
	private Long col_timestamp;
	private Integer col_type;

	private Integer TRANSPONDER_ID;
	private String IP_ADDR = null;
	private String MAC_ADDR = null;
	private String UP_CHANNELNAME = null;
	private String DOWN_CHANNELNAME = null;
	private String CM_STATUSNAME = null;
	private String DOWN_SNRGRAPH = null;
	private String RX_POWERGRAPH = null;
	private Integer DOCSIS_VER;
	private Integer CM_INDEX;
	private Integer CM_STATUS;
	private Integer CM_TYPE;
	private Integer CPE_NUMBER;
	private Integer UP_CHANNELID;
	private Integer DOWN_CHANNELID;
	private Float UP_FREQ;
	private Float UP_WIDTH;
	private int UP_MODULATION;
	private Float DOWN_FREQ;
	private float DOWN_WIDTH;
	private int DOWN_MODULATION;
	private Float DOWN_SNR;
	private Float UP_SNR;
	private Float DOWN_CER;
	private Float DOWN_CCER;
	private Float TX_POWER;
	private Float RX_POWER;
	private Float UP_TRAFFIC;
	private Float DOWN_TRAFFIC;
	private Float FEC_UN_ERR;
	private Float FEC_COR_ERR;
	private Float FEC_UNCOR_ERR;
	private Float CMQI;
	private String GROUPNAME;
	private String GROUPCOLOR;
	private String CUSTOMER_NAME;
	private String CUSTOMER_ADDRESS;
	private String CUSTOMER_PHONE;
	/**
	 * 业务类型（1-互动，2-宽带，3-互动宽带一体） 处理结果状态 0-NONE 1-INTERACT 2-BROADBAND 3-HYBRID;
	 */
	private BusinessType businessType = BusinessType.NONE;

	private String systemDescr;
	
	//无网格信息默认为0l
	private Long gridId;

	// for PNM data analysis
	/**
	 * Do not cache cable modem preEqData detail
	 */
	private int caliGroup;
	private int caliBatch;

	private String CMTSIP;
	private String updateTime;
	private float cer;
	private float ccer;
	private long sysUpTime;
	private String cmCode;
	private long headendId;
	private int fbcEnable;
	private int downIfIndex;
	private int upIfIndex;
	private double lng;
	private double lat;

	private String preEqData = ""; // keep original data
	private String vendorID = ""; // keep identifier of vendor, normally by System.ObjectID
	private float upstreamFrequency = 0f;
	private float upstreamWidth = 6.4f; // Unit is MHz

	private boolean changed;// if changed by poll or other cause

	private double nmter = 0d;
	private double mtr = 0d;
	private int tdr = 0;

	// add additional indexs
	private double MTE = 0d;
	private double PreMTE = 0d;
	private double PostMTE = 0d;
	private double TTE = 0d;
	private double MTC = 0d;
	private double PreMTTER = 0d;
	private double PostMTTER = 0d;
	private double PPESR = 0d;
	private double mer = 0d;
	private String gridNo;

	// 多频点字段
	private String upFreqStr;
	private String upWidthStr;
	private String upModulationStr;
	private String upSnrStr;
	private String upIfIndexStr;
	private String preDataStr;
	private String nmterStr;
	private String mtrStr;
	private String tdrStr;
	private String MTEStr;
	private String PreMTEStr;
	private String PostMTEStr;
	private String TTEStr;
	private String MTCStr;
	private String PreMTTERStr;
	private String PostMTTERStr;
	private String PPESRStr;
	private String txPowerStr;
	private String hUpFreqStr;
	private String cmIndexStr;
	private String channelIdStr;


	public String getCUSTOMER_PHONE() {
		return CUSTOMER_PHONE;
	}

	public void setCUSTOMER_PHONE(String cUSTOMER_PHONE) {
		CUSTOMER_PHONE = cUSTOMER_PHONE;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public Long getGridId() {
		return gridId;
	}

	public void setGridId(Long gridId) {
		this.gridId = gridId;
	}

	public String getPreEqData() {
		return preEqData;
	}

	public void setPreEqData(String preEqData) {
		this.preEqData = preEqData;
	}

	public String getVendorID() {
		return vendorID;
	}

	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}

	public float getUpstreamFrequency() {
		return upstreamFrequency;
	}

	public void setUpstreamFrequency(float upstreamFrequency) {
		this.upstreamFrequency = upstreamFrequency;
	}

	public float getUpstreamWidth() {
		return upstreamWidth;
	}

	public void setUpstreamWidth(float upstreamWidth) {
		this.upstreamWidth = upstreamWidth;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public int getDownIfIndex() {
		return downIfIndex;
	}

	public void setDownIfIndex(int downIfIndex) {
		this.downIfIndex = downIfIndex;
	}

	public int getUpIfIndex() {
		return upIfIndex;
	}

	public void setUpIfIndex(int upIfIndex) {
		this.upIfIndex = upIfIndex;
	}

	public int getFbcEnable() {
		return fbcEnable;
	}

	public void setFbcEnable(int fbcEnable) {
		this.fbcEnable = fbcEnable;
	}

	@JsonIgnore
	public String getPK() {

		return "MAC_ADDR";
	}

	public String getCmCode() {
		return cmCode;
	}

	public void setCmCode(String cmCode) {
		this.cmCode = cmCode;
	}

	public long getHeadendId() {
		return headendId;
	}

	public void setHeadendId(long headendId) {
		this.headendId = headendId;
	}

	public float getCer() {
		return cer;
	}

	public void setCer(float cer) {
		this.cer = cer;
	}

	public float getCcer() {
		return ccer;
	}

	public void setCcer(float ccer) {
		this.ccer = ccer;
	}

	public long getSysUpTime() {
		return sysUpTime;
	}

	public void setSysUpTime(long sysUpTime) {
		this.sysUpTime = sysUpTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCOL_TIME() {

		return this.col_time;
	}

	public void setCOL_TIME(String s) {

		col_time = s;
	}

	public Long getCOL_TIMESTAMP() {

		return this.col_timestamp;
	}

	public void setCOL_TIMESTAMP(long l) {

		col_timestamp = l;
	}

	public Integer getCOL_TYPE() {

		return this.col_type;
	}

	public void setCOL_TYPE(Integer i) {

		col_type = i;
	}

	public Integer getTRANSPONDER_ID() {

		return this.TRANSPONDER_ID;
	}

	public void setTRANSPONDER_ID(Integer i) {

		TRANSPONDER_ID = i;
	}

	public String getIP_ADDR() {

		return this.IP_ADDR;
	}

	public void setIP_ADDR(String s) {

		IP_ADDR = s;
	}

	public String getMAC_ADDR() {

		return this.MAC_ADDR;
	}

	public void setMAC_ADDR(String s) {

		MAC_ADDR = s;
	}

	public Integer getDOCSIS_VER() {

		return this.DOCSIS_VER;
	}

	public void setDOCSIS_VER(Integer i) {

		DOCSIS_VER = i;
	}

	public Integer getCM_INDEX() {

		return this.CM_INDEX;
	}

	public void setCM_INDEX(Integer i) {

		CM_INDEX = i;
	}

	public Integer getCM_STATUS() {

		return this.CM_STATUS;
	}

	public void setCM_STATUS(Integer i) {

		CM_STATUS = i;
	}

	public Integer getCM_TYPE() {
		return CM_TYPE;
	}

	public void setCM_TYPE(Integer cM_TYPE) {
		CM_TYPE = cM_TYPE;
	}

	public Integer getCPE_NUMBER() {

		return this.CPE_NUMBER;
	}

	public void setCPE_NUMBER(Integer i) {

		CPE_NUMBER = i;
	}

	public Integer getUP_CHANNELID() {

		return this.UP_CHANNELID;
	}

	public void setUP_CHANNELID(Integer i) {

		UP_CHANNELID = i;
	}

	public Integer getDOWN_CHANNELID() {

		return this.DOWN_CHANNELID;
	}

	public void setDOWN_CHANNELID(Integer i) {

		DOWN_CHANNELID = i;
	}

	public String getUP_CHANNELNAME() {

		return this.UP_CHANNELNAME;
	}

	public void setUP_CHANNELNAME(String s) {

		UP_CHANNELNAME = s;
	}

	public String getDOWN_CHANNELNAME() {

		return this.DOWN_CHANNELNAME;
	}

	public void setDOWN_CHANNELNAME(String s) {

		DOWN_CHANNELNAME = s;
	}

	public String getCM_STATUSNAME() {

		return this.CM_STATUSNAME;
	}

	public void setCM_STATUSNAME(String s) {

		CM_STATUSNAME = s;
	}

	public Float getUP_FREQ() {

		return this.UP_FREQ;
	}

	public void setUP_FREQ(Float f) {

		UP_FREQ = f;
	}

	public Float getDOWN_FREQ() {

		return this.DOWN_FREQ;
	}

	public void setDOWN_FREQ(Float f) {

		DOWN_FREQ = f;
	}

	public Float getDOWN_SNR() {

		return this.DOWN_SNR;
	}

	public void setDOWN_SNR(Float f) {

		DOWN_SNR = f;
	}

	public String getDOWN_SNRGRAPH() {

		return this.DOWN_SNRGRAPH;
	}

	public void setDOWN_SNRGRAPH(String s) {

		DOWN_SNRGRAPH = s;
	}

	public Float getUP_SNR() {

		return this.UP_SNR;
	}

	public void setUP_SNR(Float f) {

		UP_SNR = f;
	}

	public Float getDOWN_CER() {

		return this.DOWN_CER;
	}

	public void setDOWN_CER(Float f) {

		DOWN_CER = f;
	}

	public Float getDOWN_CCER() {
		return DOWN_CCER;
	}

	public void setDOWN_CCER(Float dOWN_CCER) {
		DOWN_CCER = dOWN_CCER;
	}

	public Float getTX_POWER() {

		return this.TX_POWER;
	}

	public void setTX_POWER(Float f) {

		TX_POWER = f;
	}

	public Float getRX_POWER() {

		return this.RX_POWER;
	}

	public void setRX_POWER(Float f) {

		RX_POWER = f;
	}

	public String getRX_POWERGRAPH() {

		return this.RX_POWERGRAPH;
	}

	public void setRX_POWERGRAPH(String s) {

		RX_POWERGRAPH = s;
	}

	public Float getUP_TRAFFIC() {

		return this.UP_TRAFFIC;
	}

	public void setUP_TRAFFIC(Float f) {

		UP_TRAFFIC = f;
	}

	public Float getDOWN_TRAFFIC() {

		return this.DOWN_TRAFFIC;
	}

	public void setDOWN_TRAFFIC(Float f) {

		DOWN_TRAFFIC = f;
	}

	public Float getFEC_UN_ERR() {

		return this.FEC_UN_ERR;
	}

	public void setFEC_UN_ERR(Float f) {

		FEC_UN_ERR = f;
	}

	public Float getFEC_COR_ERR() {

		return this.FEC_COR_ERR;
	}

	public void setFEC_COR_ERR(Float f) {

		FEC_COR_ERR = f;
	}

	public Float getFEC_UNCOR_ERR() {

		return this.FEC_UNCOR_ERR;
	}

	public void setFEC_UNCOR_ERR(Float f) {

		FEC_UNCOR_ERR = f;
	}

	public Float getCMQI() {
		return CMQI;
	}

	public void setCMQI(Float cMQI) {
		CMQI = cMQI;
	}


	public void setCaliGroup(int caliGroup) {
		this.caliGroup = caliGroup;
	}

	public int getCaliGroup() {

		return caliGroup;
	}

	public void setCaliBatch(int caliBatch) {

		this.caliBatch = caliBatch;
	}

	public int getCaliBatch() {

		return caliBatch;
	}

	public String getSystemDescr() {

		return systemDescr;
	}

	public void setSystemDescr(String systemDescr) {

		this.systemDescr = systemDescr;
	}

	public String getGROUPNAME() {

		return GROUPNAME;
	}

	public void setGROUPNAME(String gROUPNAME) {

		GROUPNAME = gROUPNAME;
	}

	public String getGROUPCOLOR() {

		return GROUPCOLOR;
	}

	public void setGROUPCOLOR(String gROUPCOLOR) {

		GROUPCOLOR = gROUPCOLOR;
	}

	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}

	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}

	public String getCUSTOMER_ADDRESS() {
		return CUSTOMER_ADDRESS;
	}

	public void setCUSTOMER_ADDRESS(String cUSTOMER_ADDRESS) {
		CUSTOMER_ADDRESS = cUSTOMER_ADDRESS;
	}

	public String getCMTSIP() {

		return CMTSIP;
	}

	public void setCMTSIP(String cMTSIP) {

		CMTSIP = cMTSIP;
	}

	public Float getUP_WIDTH() {
		return UP_WIDTH;
	}

	public void setUP_WIDTH(Float uP_WIDTH) {
		UP_WIDTH = uP_WIDTH;
	}

	public int getUP_MODULATION() {
		return UP_MODULATION;
	}

	public void setUP_MODULATION(int uP_MODULATION) {
		UP_MODULATION = uP_MODULATION;
	}

	public float getDOWN_WIDTH() {
		return DOWN_WIDTH;
	}

	public void setDOWN_WIDTH(float dOWN_WIDTH) {
		DOWN_WIDTH = dOWN_WIDTH;
	}

	public int getDOWN_MODULATION() {
		return DOWN_MODULATION;
	}

	public void setDOWN_MODULATION(int dOWN_MODULATION) {
		DOWN_MODULATION = dOWN_MODULATION;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public double getNmter() {
		return nmter;
	}

	public void setNmter(double nmter) {
		this.nmter = nmter;
	}

	public double getMtr() {
		return mtr;
	}

	public void setMtr(double mtr) {
		this.mtr = mtr;
	}

	public int getTdr() {
		return tdr;
	}

	public void setTdr(int tdr) {
		this.tdr = tdr;
	}

	public double getPreMTE() {
		return PreMTE;
	}

	public void setPreMTE(double preMTE) {
		PreMTE = preMTE;
	}

	public double getPostMTE() {
		return PostMTE;
	}

	public void setPostMTE(double postMTE) {
		PostMTE = postMTE;
	}

	public double getPreMTTER() {
		return PreMTTER;
	}

	public void setPreMTTER(double preMTTER) {
		PreMTTER = preMTTER;
	}

	public double getPostMTTER() {
		return PostMTTER;
	}

	public void setPostMTTER(double postMTTER) {
		PostMTTER = postMTTER;
	}

	public double getPPESR() {
		return PPESR;
	}

	public void setPPESR(double pPESR) {
		PPESR = pPESR;
	}

	public double getMTE() {
		return MTE;
	}

	public void setMTE(double mTE) {
		MTE = mTE;
	}

	public double getTTE() {
		return TTE;
	}

	public void setTTE(double tTE) {
		TTE = tTE;
	}

	public double getMTC() {
		return MTC;
	}

	public void setMTC(double mTC) {
		MTC = mTC;
	}

	public double getMer() {
		return mer;
	}

	public void setMer(double mer) {
		this.mer = mer;
	}

	public String getCol_time() {
		return col_time;
	}

	public void setCol_time(String col_time) {
		this.col_time = col_time;
	}

	public Long getCol_timestamp() {
		return col_timestamp;
	}

	public void setCol_timestamp(Long col_timestamp) {
		this.col_timestamp = col_timestamp;
	}

	public Integer getCol_type() {
		return col_type;
	}

	public void setCol_type(Integer col_type) {
		this.col_type = col_type;
	}

	public String getUpFreqStr() {
		return upFreqStr;
	}

	public void setUpFreqStr(String upFreqStr) {
		this.upFreqStr = upFreqStr;
	}

	public String getUpWidthStr() {
		return upWidthStr;
	}

	public void setUpWidthStr(String upWidthStr) {
		this.upWidthStr = upWidthStr;
	}

	public String getUpModulationStr() {
		return upModulationStr;
	}

	public void setUpModulationStr(String upModulationStr) {
		this.upModulationStr = upModulationStr;
	}

	public String getUpSnrStr() {
		return upSnrStr;
	}

	public void setUpSnrStr(String upSnrStr) {
		this.upSnrStr = upSnrStr;
	}

	public String getUpIfIndexStr() {
		return upIfIndexStr;
	}

	public void setUpIfIndexStr(String upIfIndexStr) {
		this.upIfIndexStr = upIfIndexStr;
	}

	public String getPreDataStr() {
		return preDataStr;
	}

	public void setPreDataStr(String preDataStr) {
		this.preDataStr = preDataStr;
	}

	public String getNmterStr() {
		return nmterStr;
	}

	public void setNmterStr(String nmterStr) {
		this.nmterStr = nmterStr;
	}

	public String getMtrStr() {
		return mtrStr;
	}

	public void setMtrStr(String mtrStr) {
		this.mtrStr = mtrStr;
	}

	public String getTdrStr() {
		return tdrStr;
	}

	public void setTdrStr(String tdrStr) {
		this.tdrStr = tdrStr;
	}

	public String getMTEStr() {
		return MTEStr;
	}

	public void setMTEStr(String mTEStr) {
		MTEStr = mTEStr;
	}

	public String getPreMTEStr() {
		return PreMTEStr;
	}

	public void setPreMTEStr(String preMTEStr) {
		PreMTEStr = preMTEStr;
	}

	public String getPostMTEStr() {
		return PostMTEStr;
	}

	public void setPostMTEStr(String postMTEStr) {
		PostMTEStr = postMTEStr;
	}

	public String getTTEStr() {
		return TTEStr;
	}

	public void setTTEStr(String tTEStr) {
		TTEStr = tTEStr;
	}

	public String getMTCStr() {
		return MTCStr;
	}

	public void setMTCStr(String mTCStr) {
		MTCStr = mTCStr;
	}

	public String getPreMTTERStr() {
		return PreMTTERStr;
	}

	public void setPreMTTERStr(String preMTTERStr) {
		PreMTTERStr = preMTTERStr;
	}

	public String getPostMTTERStr() {
		return PostMTTERStr;
	}

	public void setPostMTTERStr(String postMTTERStr) {
		PostMTTERStr = postMTTERStr;
	}

	public String getPPESRStr() {
		return PPESRStr;
	}

	public void setPPESRStr(String pPESRStr) {
		PPESRStr = pPESRStr;
	}

	public String getTxPowerStr() {
		return txPowerStr;
	}

	public void setTxPowerStr(String txPowerStr) {
		this.txPowerStr = txPowerStr;
	}

	public String gethUpFreqStr() {
		return hUpFreqStr;
	}

	public void sethUpFreqStr(String hUpFreqStr) {
		this.hUpFreqStr = hUpFreqStr;
	}

	public String getCmIndexStr() {
		return cmIndexStr;
	}

	public void setCmIndexStr(String cmIndexStr) {
		this.cmIndexStr = cmIndexStr;
	}

	public String getChannelIdStr() {
		return channelIdStr;
	}

	public void setChannelIdStr(String channelIdStr) {
		this.channelIdStr = channelIdStr;
	}

	public String getGridNo() {
		return gridNo;
	}

	public void setGridNo(String gridNo) {
		this.gridNo = gridNo;
	}
	

}
