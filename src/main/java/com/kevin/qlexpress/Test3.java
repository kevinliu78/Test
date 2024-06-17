package com.kevin.qlexpress;

/**
 * @Author: LWS
 * @Date: 2020/9/14 18:26
 */
public class Test3 {
    public static void main(String[] args) {
        String content = "{\"rules\":[{\"name\":\"alarmLevel\",\"operator\":\"in\",\"value\":\"6\"},{\"name\":\"alarmFaultType\",\"operator\":\"in\",\"value\":\"1\"}," +
                "{\"name\":\"resourceType\",\"operator\":\"in\",\"value\":\"101\"}," +
                "{\"name\":\"resourceId\",\"operator\":\"in\",\"value\":\"865105867677113537,865105867677113538,929811654525340096,865105867677113539,865097750188924096," +
                "865097750188924097,865097750188924098,865097750188924099,865105867677113536,865080742118430784,865082949731620928,865084513099716672,865085140164943054," +
                "865081059946011840,865082279716722752,865085208884419777,865085114395139264,1123381209171354178,866762900419648705,862924591226424768,880044537026721344," +
                "880045215631553472,880041521959678912,865112773984524352,862921997066177984,862925149572173632,862925536119230272,862926146004585920,862926455242231616," +
                "862927675012943680,862928001430458177,862928482466795328,878531231069777344,862929272740777792,986169167411443159,879299617898900928,865121724696370368," +
                "949858208220994112,877578581553717568,889487701231810112,11000003,865114363122425024,865114998777584832,865115273655490624,10000002,10000001,10000004," +
                "10000005,10000006,10000003,11000002,11000001,877578590143652161,877578444114764224,878595406471114176,878594787995823552,879299720978116032,879299652258638913,879299660848573505\"," +
                "\"deviceName\":\"000296701071,000296701075,000496700122,000496700373,000496800128,000496800131,000496800367,000496800370,000498700488,3par2048,3parss8844,CF22070_HF1,CF22070_HF2," +
                "CF22084_GX1,CF22084_GX2,CF22685_HF1,CF22685_HF2,Dorado_GX1,Dorado_GX2,Dorado_HF1,HFBAKVDC01,HFBIZVDC01,HFDCSPVDC01,HFNASRP1,HW18800V5_HF1,HW18800V5_HF2,HW18800V5_HF3,HW18800V5_HF4," +
                "HW18800V5_HF5,HW18800V5_HF6,HW18800V5_HF7,HW18800V5_HFTM,HW18800V5_LC1,HW18810V5_HF1,IMG-LSANAS02,SOBSa_dr,ZBNASbak2,cluster-htdcsp,hfxskyvdi,hfm32nasbak1,hfts4500,hfz43nas1,hfzlnas1," +
                "hfzlnasbak1,i6000,i6000_BF,i6000_SC,i6000_ZL,hfzli6k,i6000_nbu,ts4500,ts4500_LC,xobs-hfdcbak01,xobs-hfdcbak02,xsky-hfbzxhgs,xsky-hfoaxhgs,zbnaspool,zbnaspool-2,zbnaspool3\"}]}";

        //NetappEventlognis.server not avallable
        FilterPolicy policy = new FilterPolicy();
        policy.setId(1);
        policy.setStatus(1);
        policy.setName("test");
        policy.setDesc("test");
        policy.setPriority(0);
        policy.setContent(content);

        Alarm alarm = new Alarm();
        alarm.setAlarmFaultType(1);
        alarm.setAlarmLevel(6);
        alarm.setUpTime("2023-10-16 00:33:00");
        alarm.setResourceType(101);
        alarm.setResourceId(865085208884419770L);

        boolean b = policy.doMatch(alarm);
        System.out.println(b);

    }
}

