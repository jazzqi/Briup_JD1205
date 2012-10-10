package com.briup.run.common.util;

import com.briup.run.dao.IMemberDao;
import com.briup.run.dao.IMessengerDao;
import com.briup.run.dao.impl.MemberDao;
import com.briup.run.dao.impl.MessengerDao;
import com.briup.run.service.IMemberService;
import com.briup.run.service.IMessengerService;
import com.briup.run.service.impl.MemberService;
import com.briup.run.service.impl.MessengerService;

public class BeanFactory {
	public static String MEMBERDAO = "memberDao";
	public static String MEMBERSERVICE = "memberService";
	public static String MESSENGERDAO = "messengerDao";
	public static String MESSENGERSERVICE = "messengerService";

	private static IMemberDao memberDao = new MemberDao();
	private static IMemberService memberService = new MemberService();
	private static IMessengerDao messengerDao = new MessengerDao();
	private static IMessengerService messengerService = new MessengerService();

	public static Object getBean(String beanName) {
		if (beanName.equals(MEMBERDAO)) {
			memberDao = getMemberDao();
			return memberDao;
		}
		if (beanName.equals(MEMBERSERVICE)) {
			memberService = getMemberService();
			return memberService;
		}
		if (beanName.equals(MESSENGERDAO)) {
			messengerDao = getMessengerDao();
			return messengerDao;
		}
		if (beanName.equals(MESSENGERSERVICE)) {
			messengerService = getMessengerService();
			return messengerService;
		}
		
		return null;
	}
	
	synchronized private static IMemberDao getMemberDao() {

		return memberDao;
	}

	synchronized private static IMemberService getMemberService() {
		return memberService;
	}

	synchronized private static IMessengerDao getMessengerDao() {
		return messengerDao;
	}

	synchronized private static IMessengerService getMessengerService() {
		return messengerService;
	}
}
