package com.pbn.kevin.akka;

import akka.actor.UntypedActor;
import scala.Option;

/**
 *@author kevin
 *@version 创建时间: 2016年11月28日下午3:10:47
 */
public class Actor1 extends UntypedActor{
	
	

	public Actor1() {
		System.out.println("调用构造函数555555555555555");
	}
	
	public static void test1(){
		System.out.println("调用test1静态方法");
	}

	
	@Override
	public void onReceive(Object arg0) throws Exception {
		if(arg0 instanceof String){
			System.err.println("1------------------->"+arg0);
//			sender().tell("ww", getSelf());
		}else if(arg0 instanceof Start){
			System.err.println("success=============");
		}
		else{
			System.out.println("heihei===============>>"+arg0);
		}
	}
	
	@Override
	public void preRestart(Throwable reason, Option<Object> message) throws Exception {
		super.preRestart(reason, message);
		System.err.println("actor:" + getSelf().path() + ", preRestart master, reason:" + reason + ", message:" + message);
		init();
	}

	private void init() {
		System.out.println("init method start...");
		
	}

	@Override
	public void preStart() throws Exception {
		super.preStart();
		System.err.println("actor:" + getSelf().path() + ", master preStart ");
		init();
	}

}
