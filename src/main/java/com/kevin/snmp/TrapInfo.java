package com.kevin.snmp;

import com.kevin.util.DateFormatUtil;

import java.util.Date;

/**
 * @Author: LWS
 * @Date: 2019/12/18 15:03
 */
public class TrapInfo {
    public String trapOid;
    public String agentAddress;
    public int port;
    public Object pdu = null;
    public String version;
    public String netype = "";
    public String strMsg = "";
    public String strOccurTime;
    public String strNETimestamp;
    public String generic;
    public String specifics;

    //告警源节点类型
    // 1 网元节点 2 性能探针
    private int m_nSourceNodeType = 1;

    //默认是0-正常报文 1-SNMP错误报文 2-SNMP不完整报文
    private int trapInfoType = 0;

    public TrapInfo() {
        super();
    }

    public TrapInfo(String addr, int port_, Object pdu_, String version_) {
        agentAddress = addr;
        port = port_;
        pdu = pdu_;
        version = version_;
        netype = null;
        strOccurTime = DateFormatUtil.formatDateTime24(new Date());
    }

    public String getGeneric() {
        return generic;
    }

    public String getSpecifics() {
        return specifics;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    public void setSpecifics(String specifics) {
        this.specifics = specifics;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTrapOid() {
        return trapOid;
    }

    public void setTrapOid(String trapOid) {
        this.trapOid = trapOid;
    }

    public void setNETimestamp(String strTimestamp) {
        this.strNETimestamp = strTimestamp;
    }

    public void setNeType(String netype_) {
        netype = netype_;
    }

    public String getNeType() {
        return netype;
    }

    public void setOriginalMsg(String msg_) {
        strMsg = msg_;
    }

    public String getOriginalMsg() {
        return strMsg;
    }

    public int getSourceNodeType() {
        return m_nSourceNodeType;
    }

    public void setSourceNodeType(int sourceNodeType) {
        m_nSourceNodeType = sourceNodeType;
    }

    public String getStrOccurTime() {
        return strOccurTime;
    }

    public void setStrOccurTime(String strOccurTime) {
        this.strOccurTime = strOccurTime;
    }

    public int getTrapInfoType() {
        return trapInfoType;
    }

    public void setTrapInfoType(int trapInfoType) {
        this.trapInfoType = trapInfoType;
    }

    @Override
    public String toString() {
        return strMsg;
    }
}
