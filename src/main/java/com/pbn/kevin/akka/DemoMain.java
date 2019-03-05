package com.pbn.kevin.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 *@author kevin
 *@version 创建时间: 2016年11月28日下午3:13:40
 */
public class DemoMain {

	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("demos");
		ActorSystem system1 = ActorSystem.create("demo2");
		
		ActorRef actor1 = system.actorOf(Props.create(Actor1.class));
//		ActorRef actor2 = system.actorOf(Props.create(Actor2.class));
		actor1.tell("qqq",actor1);
		Actor1.test1();
	}

}
