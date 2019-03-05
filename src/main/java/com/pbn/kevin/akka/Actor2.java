package com.pbn.kevin.akka;

import akka.actor.UntypedActor;
import scala.Option;

/**
 *@author kevin
 *@version 创建时间: 2016年11月28日下午3:10:47
 */
public class Actor2 extends UntypedActor{

	@Override
	public void onReceive(Object arg0) throws Exception {
		if(arg0 instanceof String){
			System.err.println("2------------------->"+arg0);
//			sender().tell("qq", getSelf());
		}
	}
	
	@Override
	public void preRestart(Throwable reason, Option<Object> message) throws Exception {
		super.preRestart(reason, message);
		System.err.println("actor:" + getSelf().path() + ", preRestart master, reason:" + reason + ", message:" + message);
		init();
	}

	@Override
	public void preStart() throws Exception {
		super.preStart();
		System.err.println("actor:" + getSelf().path() + ", master preStart ");
		init();
	}
	
	private void init() {
		System.out.println("init method start...");
		
	}

}
