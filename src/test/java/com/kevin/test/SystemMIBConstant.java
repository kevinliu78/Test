package com.kevin.test;


public interface SystemMIBConstant {
	// system
	public final static String sysDescr		= "1.3.6.1.2.1.1.1.0";
	public final static String sysObjectID	= "1.3.6.1.2.1.1.2.0";
	public final static String sysUpTime	= "1.3.6.1.2.1.1.3.0";
	public final static String sysName		= "1.3.6.1.2.1.1.5.0";
	
	// interfaces
	public final static String ifIndex		= "1.3.6.1.2.1.2.2.1.1";
	public final static String ifDescr		= "1.3.6.1.2.1.2.2.1.2";
	public final static String ifType		= "1.3.6.1.2.1.2.2.1.3";
	public final static String ifSpeed		= "1.3.6.1.2.1.2.2.1.5";//bps
	public final static String ifOperStatus	= "1.3.6.1.2.1.2.2.1.8";
	public final static String ifPhysAddress= "1.3.6.1.2.1.2.2.1.6";
	
	// interface operational type
	public final static int ifOperStatus_up = 1;
	public final static int ifOperStatus_down = 2;
	
	// IANAIfType
	public final static int ifType_other = 1;
	public final static int ifType_docsCableDownstream = 128;
	public final static int ifType_docsCableUpstream = 129;
	public final static int ifType_docsCableUpstreamChannel = 205;
	
}
