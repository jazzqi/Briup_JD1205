package com.briup.run.service.impl;

import java.util.List;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Messagerecord;
import com.briup.run.common.exception.MessengerServiceException;
import com.briup.run.common.transaction.HibernateTransaction;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.dao.impl.MessengerDao;
import com.briup.run.service.IMessengerService;

public class MessengerService implements IMessengerService {
	private final HibernateTransaction ht = new HibernateTransaction();
	private final MessengerDao messengerDao = (MessengerDao) BeanFactory
			.getBean(BeanFactory.MESSENGERDAO);

	@Override
	public Integer findNewMessageNum(String nickname)
			throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Memberinfo findOneMemberinfo() throws MessengerServiceException {
		ht.beginTransaction();
		messengerDao.setSession(ht.getSession());
		Memberinfo member = null;
		try {
			int count = messengerDao.findMemberinfoNum();
			int random = (int) (count * Math.random());
			member = messengerDao.findOneMemberinfo(random);
			ht.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ht.rollback();
		}
		return member;
	}

	@Override
	public List<Memberinfo> findFriends(String age, String gender, String city)
			throws MessengerServiceException {
		List members = null;
		ht.beginTransaction();
		messengerDao.setSession(ht.getSession());
		try{
			members = messengerDao.findFriends(age, gender, city);
			ht.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ht.rollback();
		}
		return members;
	}

	@Override
	public void saveMessage(Messagerecord message)
			throws MessengerServiceException {
		ht.beginTransaction();
		messengerDao.setSession(ht.getSession());
		try {
			messengerDao.saveMessage(message);
			ht.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ht.rollback();
		}

	}

	@Override
	public List<Messagerecord> listSendMessage(String senderName)
			throws MessengerServiceException {
		List result = null;
		ht.beginTransaction();
		messengerDao.setSession(ht.getSession());
		try {
			result = messengerDao.listSendMessage(senderName);
			ht.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ht.rollback();
		}
		return result;
	}

	@Override
	public List<Messagerecord> listRecieveMessage(String recieveName)
			throws MessengerServiceException {
		List result = null;
		ht.beginTransaction();
		messengerDao.setSession(ht.getSession());
		try {
			result = messengerDao.listRecieveMessage(recieveName);
			ht.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ht.rollback();
		}
		return result;
	}

	@Override
	public Messagerecord findMessage(Long id) throws MessengerServiceException {
		Messagerecord message = null;
		ht.beginTransaction();
		messengerDao.setSession(ht.getSession());
		try {
			message = messengerDao.findMessage(id);
			ht.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ht.rollback();
		}
		return message;
	}

	@Override
	public void delRecieveMessage(Long id) throws MessengerServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delSendMessage(Long id) throws MessengerServiceException {
		// TODO Auto-generated method stub

	}

}
