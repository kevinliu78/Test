package com.kevin.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Author: LWS
 * @Date: 2020/9/15 16:28
 */
public class TestStringRegexMap {

    private static Map<Pattern, String> errorCodeMap = new HashMap<>();

    private static void initErrorCodeMap() {
        errorCodeMap.put(Pattern.compile(".*Diagnostic event trace triggered.*"), "1050");
        errorCodeMap.put(Pattern.compile(".*Remote.*diagnostic event trace triggered.*"), "1051");
        errorCodeMap.put(Pattern.compile(".*Memory.*automatically disabled due to cache error.*"), "1053");
        errorCodeMap.put(Pattern.compile(".*Spare invoked against a disk.*"), "1054");
        errorCodeMap.put(Pattern.compile(".*M2 mirror resynchronizing with its M1 mirror.*"), "1055");
        errorCodeMap.put(Pattern.compile(".*M1 mirror resynchronizing with its M2 mirror.*"), "1056");
        errorCodeMap.put(Pattern.compile(".*Disk director not responding.*"), "1057");
        errorCodeMap.put(Pattern.compile(".*Data migration completed on all migration devices.*"), "1058");
        errorCodeMap.put(Pattern.compile(".*Device resynchronization process started.*"), "1059");
        errorCodeMap.put(Pattern.compile(".*Spare invoked against a remote R2 mirror disk.*"), "1060");
        errorCodeMap.put(Pattern.compile(".*Fibre Channel front-end has failed or is inoperable.*"), "1063");
        errorCodeMap.put(Pattern.compile(".*No SRDF links in an RDF group are operational.*"), "1064");
        errorCodeMap.put(Pattern.compile(".*All SRDF links in an RDF group are operational.*"), "1065");
        errorCodeMap.put(Pattern.compile(".*Bus Arbiter problem.*"), "1066");
        errorCodeMap.put(Pattern.compile(".*Internal temperature too high.*"), "1067");
        errorCodeMap.put(Pattern.compile(".*Alarm signal was set.*but no alarm found.*"), "1068");
        errorCodeMap.put(Pattern.compile(".*Power subsystem alarm or fault has occurred.*"), "1069");
        errorCodeMap.put(Pattern.compile(".*Device mirror not ready.*"), "1070");
        errorCodeMap.put(Pattern.compile(".*Device mirror write disabled.*"), "1071");
        errorCodeMap.put(Pattern.compile(".*SRDF R2 device not ready.*"), "1072");
        errorCodeMap.put(Pattern.compile(".*Service Processor down or not communicating with array.*"), "1073");
        errorCodeMap.put(Pattern.compile(".*Service Processor could not complete a call for service.*"), "1074");
        errorCodeMap.put(Pattern.compile(".*Abnormal DC voltage.*situation exists.*"), "1075");
        errorCodeMap.put(Pattern.compile(".*Power subsystem environmental sense cable missing.*"), "1076");
        errorCodeMap.put(Pattern.compile(".*Power system AC line interruption detected.*"), "1077");
        errorCodeMap.put(Pattern.compile(".*Battery system not fully charged.*"), "1078");
        errorCodeMap.put(Pattern.compile(".*Latched alarms discovered for the power subsystem.*"), "1079");
        errorCodeMap.put(Pattern.compile(".*Single SRDF link in an RDF group is not operational.*"), "1080");
        errorCodeMap.put(Pattern.compile(".*Single SRDF link in an RDF group is now operational.*"), "1081");
        errorCodeMap.put(Pattern.compile(".*Service Processor successfully completed a call for service.*"), "1082");
        errorCodeMap.put(Pattern.compile(".*Subsystem unable to set a shared register.*"), "1083");
        errorCodeMap.put(Pattern.compile(".*Disabled Memory Bank error reported to a host.*"), "1084");
        errorCodeMap.put(Pattern.compile(".*Validity problem detected during environmental test.*"), "1085");
        errorCodeMap.put(Pattern.compile(".*Environmental testing enabled in diagnostic mode.*"), "1086");
        errorCodeMap.put(Pattern.compile(".*Communication board data does not match expected value.*"), "1087");
        errorCodeMap.put(Pattern.compile(".*Communication board information mismtach.*"), "1088");
        errorCodeMap.put(Pattern.compile(".*Failure detected during thermal test.*"), "1089");
        errorCodeMap.put(Pattern.compile(".*Power-on-Time inconsistencies detected.*"), "1090");
        errorCodeMap.put(Pattern.compile(".*No records found for the last Service Processor connection time.*"), "1091");
        errorCodeMap.put(Pattern.compile(".*Service Processor communicating via a serial line.*"), "1092");
        errorCodeMap.put(Pattern.compile(".*Remote session to the Service Processor connected.*"), "1093");
        errorCodeMap.put(Pattern.compile(".*Remote session to the Service Processor denied access.*"), "1094");
        errorCodeMap.put(Pattern.compile(".*Remote session to the Service Processor disconnected.*"), "1095");
        errorCodeMap.put(Pattern.compile(".*Service Processor detected excessive memory usage.*"), "1096");
        errorCodeMap.put(Pattern.compile(".*Battery test detected a failure.*"), "1097");
        errorCodeMap.put(Pattern.compile(".*Service Processor could not communicate with a director.*"), "1098");
        errorCodeMap.put(Pattern.compile(".*Service Processor could not query a director.*"), "1099");
        errorCodeMap.put(Pattern.compile(".*Service Processor is communicating via local director.*"), "1100");
        errorCodeMap.put(Pattern.compile(".*Service Processor unable to read an environmental sensor.*"), "1101");
        errorCodeMap.put(Pattern.compile(".*Service Processor detected a failed or unrecognized communications card.*"), "1102");
        errorCodeMap.put(Pattern.compile(".*Service Processor found environmental readings to be out of limits.*"), "1103");
        errorCodeMap.put(Pattern.compile(".*Service Processor disk is full.*"), "1104");
        errorCodeMap.put(Pattern.compile(".*Service Processor detected a smoke detector malfunction.*"), "1105");
        errorCodeMap.put(Pattern.compile(".*Service Processor detected a smoke detector alert.*"), "1106");
        errorCodeMap.put(Pattern.compile(".*Service Processor triggered a call home for service.*"), "1107");
        errorCodeMap.put(Pattern.compile(".*Database Double Checksum event triggered.*"), "1108");
        errorCodeMap.put(Pattern.compile(".*Service Processor successfully rebooted.*"), "1110");
        errorCodeMap.put(Pattern.compile(".*Volume.*not ready.*"), "1114");
        errorCodeMap.put(Pattern.compile(".*Director not responding.*"), "1117");
        errorCodeMap.put(Pattern.compile(".*Generic Double Checksum event triggered.*"), "1127");
        errorCodeMap.put(Pattern.compile(".*One of the Power Zones is down - shutdown will occur in 20 hours.*"), "1128");
        errorCodeMap.put(Pattern.compile(".*One of the Power Zones is down - shutdown will occur in 5 hours.*"), "1129");
        errorCodeMap.put(Pattern.compile(".*Power Supply A multiple Fan fault.*"), "1142");
        errorCodeMap.put(Pattern.compile(".*Power Supply A single Fan fault.*"), "1143");
        errorCodeMap.put(Pattern.compile(".*Power Supply A faulted.*"), "1144");
        errorCodeMap.put(Pattern.compile(".*Power Supply A shutdown.*"), "1145");
        errorCodeMap.put(Pattern.compile(".*Power Supply B multiple fan fault.*"), "1146");
        errorCodeMap.put(Pattern.compile(".*Power Supply B single fan fault.*"), "1147");
        errorCodeMap.put(Pattern.compile(".*Power Supply B faulted.*"), "1148");
        errorCodeMap.put(Pattern.compile(".*Power Supply B shutdown.*"), "1149");
        errorCodeMap.put(Pattern.compile(".*Link Card Controller A temperature high.*"), "1150");
        errorCodeMap.put(Pattern.compile(".*Link Card Controller B temperature high.*"), "1151");
        errorCodeMap.put(Pattern.compile(".*Supplemental Power Supply internal fault.*"), "1152");
        errorCodeMap.put(Pattern.compile(".*Supplemental Power Supply battery end of line.*"), "1153");
        errorCodeMap.put(Pattern.compile(".*Supplemental Power Supply low input AC Voltage.*"), "1154");
        errorCodeMap.put(Pattern.compile(".*Entries are being written to the audit log at an unusually high rate.*"), "1155");
        errorCodeMap.put(Pattern.compile(".*Audit log has lost its redundancy due to an SFS mirror being offline.*"), "1156");
        errorCodeMap.put(Pattern.compile(".*Audit log entries have been overwritten in an unusually short time period.*"), "1157");
        errorCodeMap.put(Pattern.compile(".*Device state has changed to.*"), "1200");
        errorCodeMap.put(Pattern.compile(".*Array state has changed to.*"), "1201");
        errorCodeMap.put(Pattern.compile(".*Director state has changed to.*"), "1202");
        errorCodeMap.put(Pattern.compile(".*Port state has changed to.*"), "1203");
        errorCodeMap.put(Pattern.compile(".*Disk state is now.*"), "1204");
        errorCodeMap.put(Pattern.compile(".*Disk is.*Spare.*"), "1210");
        errorCodeMap.put(Pattern.compile(".*Number of available disk spares is.*"), "1211");
        errorCodeMap.put(Pattern.compile(".*Component state has changed to.*"), "1244");
        errorCodeMap.put(Pattern.compile(".*Disk Group has.*"), "1246");
        errorCodeMap.put(Pattern.compile(".*Disk.*spare coverage.*"), "1247");
    }

    public static void main(String args[]) {
        initErrorCodeMap();
        String eventDesc = "Disk state is now Offline Spare(was:Online).-Object is: 000496800367:02C:C1";
        Set<Pattern> errorDescSet = errorCodeMap.keySet();
        String errorCode = "";
        for (Pattern errorDesc : errorDescSet) {
            Matcher matcher = errorDesc.matcher(eventDesc);
            if (matcher.find()) {
                errorCode = errorCodeMap.get(errorDesc);
                break;
            }
        }
        System.out.println("errorCode=======" + errorCode);
        String keyword = ".*Disk state is now.*";
        boolean matches = Pattern.matches(keyword, eventDesc);
        System.out.println("matches====" + matches);
    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        // 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]";
        // 清除掉所有特殊字符
        String regEx = "[`~!@#$^&*()+=|{}':;',\\[\\]<>/?~！@#￥……&*（）——+|{}【】‘；：”“’。 ，、？\\u000A\\u0009\\\\]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String result = m.replaceAll("").trim();
        return result;
//        return result.replaceAll(" ","");
    }
}