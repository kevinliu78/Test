package com.kevin.test;


public class DocsisSNMPConstant {
	
	public final static String sysUpTime							="1.3.6.1.2.1.1.3";
	
	public final static String CableModemMACAddress					="1.3.6.1.2.1.17.1.1";
	public final static String CableModemDescr						="1.3.6.1.2.1.1.1";
	public final static String CableModemObjectID					="1.3.6.1.2.1.1.2";
	public final static String docsDevMIBObjects					="1.3.6.1.2.1.69.1";
	public final static String docsDevSwCurrentVers 				="1.3.6.1.2.1.69.1.3.5";
	public final static String docsDevSerialNumber 					="1.3.6.1.2.1.69.1.1.4";
	public final static String docsIfDocsisVersionGroup				="1.3.6.1.2.1.10.127.21.4.2.1";
	public final static String ifIndex								="1.3.6.1.2.1.2.2.1.1";
	public final static String ifNumber								="1.3.6.1.2.1.2.1";
	public final static String ifType								="1.3.6.1.2.1.2.2.1.3";
	
	public final static String cseSysCPUUtilization					="1.3.6.1.4.1.9.9.305.1.1.1";
	public final static String cseSysMemoryUtilization				="1.3.6.1.4.1.9.9.305.1.1.2";
	
	//docsIfCmStatusTable,DOCS-IF-MIB [RFC4546], get directly from cable modem
	public final static String docsIfCmStatusTxPower				="1.3.6.1.2.1.10.127.1.2.2.1.3";
	public final static String docsIfCmStatusEqualizationData		="1.3.6.1.2.1.10.127.1.2.2.1.17";
	public final static String docsIfCmUpChannelFrequency			="1.3.6.1.2.1.10.127.1.1.2.1.2";
	public final static String docsIfCmUpStreamWidth				="1.3.6.1.2.1.10.127.1.1.2.1.3";
	
	public final static String docsIfCmCapabilities					="1.3.6.1.2.1.10.127.1.2.1.1.2";
	public final static String docsIfCmtsCapabilities				="1.3.6.1.2.1.10.127.1.3.1.1.1";
	public final static String docsIfSigQSignalNoise				="1.3.6.1.2.1.10.127.1.1.4.1.5";
	public final static String docsIfSigQUnerroreds					="1.3.6.1.2.1.10.127.1.1.4.1.2";
	public final static String docsIfSigQCorrecteds					="1.3.6.1.2.1.10.127.1.1.4.1.3";
	public final static String docsIfSigQUncorrectables				="1.3.6.1.2.1.10.127.1.1.4.1.4";
	public final static String docsIfSigQExtUnerroreds				="1.3.6.1.2.1.10.127.1.1.4.1.8";
	public final static String docsIfSigQExtCorrecteds				="1.3.6.1.2.1.10.127.1.1.4.1.9";
	public final static String docsIfSigQExtUncorrectables			="1.3.6.1.2.1.10.127.1.1.4.1.10";
	
	public final static String cpscTrafficType						="1.3.6.1.4.1.9.9.362.1.1.1.1.1";
	public final static String sysTraffic							="1.3.6.1.4.1.9.5.1.1.8";
	public final static String sysTrafficPeak						="1.3.6.1.4.1.9.5.1.1.19";
	public final static String docsSubMgtCmFilterDownstream			="1.3.6.1.3.83.4.1.8.1.3";
	public final static String cdxCmtsCmCurrCpeNumber				="1.3.6.1.4.1.9.9.116.1.3.6.1.2";
	public final static String docsIfCmStatusValue					="1.3.6.1.2.1.10.127.1.2.2.1.1";
	public final static String docsIfCmCmtsAddress					="1.3.6.1.2.1.10.127.1.2.1.1.1";
	
	public final static String brcmCMCER							="1.3.6.1.4.1.4413.2.2.2.1.2.1.8.1.1";
	
	//DOCSIS down channel
	public final static String docsIfDownChannelId					="1.3.6.1.2.1.10.127.1.1.1.1.1";
	public final static String docsIfDownChannelFrequency			="1.3.6.1.2.1.10.127.1.1.1.1.2";
	public final static String docsIfDownChannelWidth				="1.3.6.1.2.1.10.127.1.1.1.1.3";
	public final static String docsIfDownChannelModulation			="1.3.6.1.2.1.10.127.1.1.1.1.4";
	public final static String docsIfDownChannelPower				="1.3.6.1.2.1.10.127.1.1.1.1.6";
	
	//CMTS-CM index pointer
	public final static String docsIfCmtsCmPtr						="1.3.6.1.2.1.10.127.1.3.7.1.2"; //docsIfCmtsMacToCmTable
	
	//DOCSIS up channel
	public final static String docsIfUpChannelTable					="1.3.6.1.2.1.10.127.1.1.2.1"; //docsIfUpstreamChannelTable
	public final static String docsIfUpChannelId 					= "1.3.6.1.2.1.10.127.1.1.2.1.1";
	public final static String docsIfUpChannelIndex					="1.3.6.1.2.1.10.127.1.1.2.1.1";
	public final static String docsIfUpChannelFrequency				="1.3.6.1.2.1.10.127.1.1.2.1.2";
	public final static String docsIfUpChannelWidth					="1.3.6.1.2.1.10.127.1.1.2.1.3";
	public final static String docsIfUpChannelModulationProfile		="1.3.6.1.2.1.10.127.1.1.2.1.4";//must polled from CMTS
	public final static String docsIfUpChannelPreEqEnable			="1.3.6.1.2.1.10.127.1.1.2.1.19";
	public final static String docsIfUpChannelRxPower				="1.3.6.1.4.1.4491.2.1.20.1.25.1.2";
	
	public final static String docsIfCmtsModType					="1.3.6.1.2.1.10.127.1.3.5.1.4";//table value from CMTS
	
	//cable modem key indexs from CMTS
	public final static String docsIfCmtsCmStatusMacAddress			="1.3.6.1.2.1.10.127.1.3.3.1.2";
	public final static String docsIfCmtsCmStatusIpAddress			="1.3.6.1.2.1.10.127.1.3.3.1.3";
	public final static String docsIfCmtsCmStatusDownChannelIfIndex	="1.3.6.1.2.1.10.127.1.3.3.1.4";
	public final static String docsIfCmtsCmStatusUpChannelIfIndex	="1.3.6.1.2.1.10.127.1.3.3.1.5";
	public final static String docsIfCmtsCmStatusRxPower			="1.3.6.1.2.1.10.127.1.3.3.1.6";
	public final static String docsIfCmtsCmStatusValue				="1.3.6.1.2.1.10.127.1.3.3.1.9";
	public final static String docsIfCmtsCmStatusUnerroreds			="1.3.6.1.2.1.10.127.1.3.3.1.10";
	public final static String docsIfCmtsCmStatusCorrecteds			="1.3.6.1.2.1.10.127.1.3.3.1.11";
	public final static String docsIfCmtsCmStatusUncorrectables		="1.3.6.1.2.1.10.127.1.3.3.1.12";
	public final static String docsIfCmtsCmStatusSignalNoise		="1.3.6.1.2.1.10.127.1.3.3.1.13";
	
	// 
	public final static String docsSubMgtCmFilterUpstream			="1.3.6.1.3.83.4.1.8.1.4";
	
	//Table 
	public final static String entPhysicalTable						="1.3.6.1.2.1.47.1.1.1";
	public final static String entAliasMappingTable					="1.3.6.1.2.1.47.1.3.2.1.2.";
	public final static String entPhysicalContainsTable				="1.3.6.1.2.1.47.1.3.3";
	public final static String docsIfCmtsMacToCmTable				="1.3.6.1.2.1.10.127.1.3.7";
	
	//Spectrum Trace
	
	public final static String ccsSpectrumRequestLowFreq			="1.3.6.1.4.1.9.9.114.1.2.1.1.4";//start frequency;KHz;R/C
	public final static String ccsSpectrumRequestUpperFreq			="1.3.6.1.4.1.9.9.114.1.2.1.1.5";//stop frequency;KHz;R/C
	public final static String ccsSpectrumRequestResolution			="1.3.6.1.4.1.9.9.114.1.2.1.1.6";//frequency span;KHz;R/C
	public final static String ccsSpectrumRequestOperation 			="1.3.6.1.4.1.9.9.114.1.2.1.1.7";//operation type:START or ABORT;R/C
	public final static String ccsSpectrumRequestIfIndex 			="1.3.6.1.4.1.9.9.114.1.2.1.1.2"; //R/C
	public final static String ccsSpectrumRequestMacAddr 			="1.3.6.1.4.1.9.9.114.1.2.1.1.3";
	public final static String ccsSpecGroupUpstreamIfIndex 			="1.3.6.1.4.1.9.9.114.1.3.1.1.11";//
	public final static String ccsUpSpecMgmtToCenterFreq			="1.3.6.1.4.1.9.9.114.1.3.1.1.11";//current center frequency;KHz;R
	public final static String ccsUpSpecMgmtSnrPollPeriod			="1.3.6.1.4.1.9.9.114.1.3.1.1.8";//polling time interval;msec;R/W
	
	public final static String ccsSpectrumDataFreq 					="1.3.6.1.4.1.9.9.114.1.2.2.1.1";
	public final static String ccsSpectrumDataPower 				="1.3.6.1.4.1.9.9.114.1.2.2.1.2";
	
	 
	public final static int docsIfCmtsCmStatusValue_offline = 1;
	public final static int docsIfCmtsCmStatusValue_ranging = 2;
	public final static int docsIfCmtsCmStatusValue_rangingAborted = 3;
	public final static int docsIfCmtsCmStatusValue_rangingComplete = 4;
	public final static int docsIfCmtsCmStatusValue_ipComplete = 5;
	public final static int docsIfCmtsCmStatusValue_online = 6;

	
	//Docsis 3.0 Cable Modem Spectrum
	public static final String docsIf3CmSpectrumAnalysisCtrlCmdEnable 		="1.3.6.1.4.1.4491.2.1.20.1.34.1.0";
	public static final String cmdInactivityTimeout 						="1.3.6.1.4.1.4491.2.1.20.1.34.2.0";
	public static final String firstSegmentCenterFrequency 					="1.3.6.1.4.1.4491.2.1.20.1.34.3.0";
	public static final String lastSegmentCenterFrequency 					="1.3.6.1.4.1.4491.2.1.20.1.34.4.0";
	public static final String cmdSegmentFrequencySpan 						="1.3.6.1.4.1.4491.2.1.20.1.34.5.0";
	public static final String binsPerSegment 								="1.3.6.1.4.1.4491.2.1.20.1.34.6.0";
	public static final String docsIf3CmSpectrumAnalysisMeasAmplitudeData 	="1.3.6.1.4.1.4491.2.1.20.1.35.1.2";
	public static final String docsIf3CmStatusUsEqData					 	="1.3.6.1.4.1.4491.2.1.20.1.2.1.6.4";
	
	public static final int cmdSegmentFrequencySpan_min = 1000000;//Hz
	public static final int cmdSegmentFrequencySpan_max = 900000000;//Hz
	public static final int binsPerSegment_min = 2;
	public static final int binsPerSegment_max = 2048;
}
