package com.pbn.kevin.test;


/**
 * @author kevin
 * @version 创建时间: 2018年9月5日下午3:00:45
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestPnmLib {
	//CMFRN[j] = 10 * Math.log((new Complex(CMFR[j],CMFI[j]).abs()) / (new Complex(MaxAmplitude,0).abs()));
	public static void main(String[] args) {
		String s1 = "7f:f0:00:00";
		String s2 = "7f:f0:00:00";
		String s3 = "7f:f0:00:00";
		String s4 = "fe:30:00:00";
		
		int fr = parseFourNibbles("7ff0");
		int fi = parseFourNibbles("0000");
		double CMFRN = 10 * Math.log((new Complex(fr,fi).abs()) / (new Complex(4095,0).abs()));
		System.out.println(CMFRN);
		int fr1 = parseThreeNibbles("fe30");
		int fi1 = parseThreeNibbles("0000");
		double CMFRN1 = 10 * Math.log((new Complex(fr1,fi1).abs()) / (new Complex(4095,0).abs()));
		System.out.println(CMFRN1);
	}
	public static int parseFourNibbles(String strFourNibbles)
	{
		try
		{			
			// get Sign flag from first nibble
			String strSignNibble = strFourNibbles.substring(0,1).toUpperCase();
  			
			if((Integer.valueOf(strSignNibble,16).intValue() & 8) == 8)
			{ // 00001000
				return decodeFourNibbleTwoComplementInteger(strFourNibbles);
			}
			else
			{
				return Integer.valueOf(strFourNibbles,16).intValue();
			}
			
		}
		catch(Exception e)
		{
			// System.out.print("Exception:"+e.getMessage());
		}
		
		return 0; // Default Value?
	}
		
	public static int parseThreeNibbles(String strFourNibbles)
	{
	
		try
		{
 			// get Sign flag from second nibble
			String strSignNibble = strFourNibbles.substring(1,2).toUpperCase();
			
			// remove first nibble
			String strThreeNibbles = strFourNibbles.substring(1,strFourNibbles.length());
			
			// System.out.println("Four="+strFourNibbles+" SignNibble="+strSignNibble+" ThreeNibble="+strThreeNibbles);
			if((Integer.valueOf(strSignNibble,16).intValue() & 8) == 8)
			{ // 00001000
				return decodeThreeNibbleTwoComplementInteger(strThreeNibbles);
			}
			else
			{
				return Integer.valueOf(strThreeNibbles,16).intValue();
			}
		}
		catch(Exception e)
		{
			// System.out.print("Exception:"+e.getMessage());
		}
		
		return 0; // Default Value?
	}
	
	private static int decodeThreeNibbleTwoComplementInteger(String str)
	{
 		int t1 = Integer.valueOf("F" + str,16).intValue();
		// System.out.println("t1="+t1+" binary string="+Integer.toBinaryString(t1)+",HexString(i)="+Integer.toHexString(t1)+",bit count"+Integer.bitCount(t1));
		// 32767 = 0111 1111 1111 1111
		// 65536 = 0001 0000 0000 0000 0000
		return (t1 > 32767) ? t1 - 65536 : t1;
	}
	
	private static int decodeFourNibbleTwoComplementInteger(String str)
	{
 		int t1 = Integer.valueOf(str,16).intValue();
		//System.out.println("t1="+t1+" binary string="+Integer.toBinaryString(t1)+",HexString(i)="+Integer.toHexString(t1)+",bit count"+Integer.bitCount(t1));
		// 32767 = 0111 1111 1111 1111
		// 65536 = 0001 0000 0000 0000 0000
		return (t1 > 32767) ? t1 - 65536 : t1;
	}
}
