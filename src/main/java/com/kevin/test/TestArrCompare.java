package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: Dec 13, 20182:04:52 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestArrCompare {
	public static void main(String[] args) {
		String s = "208b37817774,14825b9f37d3,5cc6d01cb6dd,a089e4089948,14825b9112dd,14825b9f3f87,c88f2600d25f,c88f2600c643,208b37817773,"
				+ "a089e403ac36,c8afe336aab8,c88f2600dcc0,c88f2600dcc4,c88f2600cefb,c88f2600dcc2,14825b9f37f1,a089e4022a9f,a089e40b6bd1,"
				+ "208b37817c6f,14825b9f36e4,14825b9f32e3,c8afe30c45ee,208b37817dba,c8afe30c5011,14825b9f35e0,c88f2600dcc5,208b37817c47,"
				+ "a089e40a8f19,a089e40a8b71,a089e4088d92,30448702457d,c88f2600dcc1,14825b0a9529,a089e4022f8b,14825b9f3384,208b37817c51,"
				+ "c445ec117b65,c88f2600d5aa,c8afe33c23ef,14825b9e5669,14825b9f3378,14825b9fb109,208b3781772b,a089e4079860,c88f2600dcc6,"
				+ "14825b9e55bb,5cc6d01c9bd1,c88f2600c66b,c88f2600dcc3,a089e40b78c9,14825b9f36b3,c445ec0a5f6a,14825b9f465b,5cc6d01cdce8,"
				+ "14825b910a7c,a089e4086e15,c8afe3362af5,c88f2600dcc7,a089e4089197,a089e40230af";
		
		String t = "14825b0a9529, 14825b910a7c, 14825b9112dd, 14825b9e55bb, 14825b9e5669, 14825b9f32e3, 14825b9f3378, 14825b9f3384, "
				+ "14825b9f35e0, 14825b9f36b3, 14825b9f36e4, 14825b9f37d3, 14825b9f37f1, 14825b9f3f87, 14825b9f465b, 14825b9fb109, "
				+ "208b3781772b, 208b37817773, 208b37817774, 208b37817c47, 208b37817c51, 208b37817c6f, 208b37817dba, 30448702457d, "
				+ "5cc6d01c9bd1, 5cc6d01cb6dd, 5cc6d01cdce8, a089e4022a9f, a089e4022f8b, a089e40230af, a089e403ac36, a089e4086e15, "
				+ "a089e4088d92, a089e4089197, a089e4089948, a089e40a8b71, a089e40a8f19, a089e40b6bd1, a089e40b78c9, c445ec0a5f6a, "
				+ "c445ec117b65, c88f2600c643, c88f2600c66b, c88f2600cefb, c88f2600d25f, c88f2600d5aa, c88f2600dcc0, c88f2600dcc1, "
				+ "c88f2600dcc2, c88f2600dcc3, c88f2600dcc4, c88f2600dcc5, c88f2600dcc6, c88f2600dcc7, c8afe30c45ee, c8afe30c5011, "
				+ "c8afe3362af5, c8afe336aab8, c8afe33c23ef";
		
		
		
		String[] ss = s.split(",");
		String[] st = t.split(",");
		for (String sss : ss) {
			if(!t.contains(sss)) {
				System.out.println(sss);
			}
		}
		System.out.println(ss.length);
		System.out.println(st.length);
	}
}
