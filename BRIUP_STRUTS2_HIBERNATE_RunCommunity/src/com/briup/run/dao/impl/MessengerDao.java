package com.briup.run.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Messagerecord;
import com.briup.run.common.exception.DataAccessException;
import com.briup.run.dao.IMessengerDao;

public class MessengerDao implements IMessengerDao {
	private Session session;	

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Integer findNewMessageNum(String nickname)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findMemberinfoNum() throws DataAccessException {
		return session.createQuery("from Memberinfo").list().size();
	}

	@Override
	public Memberinfo findOneMemberinfo(int sum) throws DataAccessException {
		return (Memberinfo) session.createQuery("from Memberinfo").list().get(sum);
	}

	@Override
	public List findFriends(String age, String gender, String city)
			throws DataAccessException {
		String hql = "from Memberinfo m";
		boolean isFirst = true;
		if(!age.equals("unlimited")){
			hql += (" where m.age between "+age+"0"+" and "+age+"9");
			isFirst = false;
		}
		if(!gender.equals("unlimited")){
			if(isFirst){
				hql+=" where m.gender = "+gender;
			}else{
				hql+=" and m.gender = "+gender;
			}
		}
		if(!city.equals("unlimited")){
			if(isFirst){
				hql+=" where m.provincecity = "+city;
			}else{
				hql+=" and m.provincecity = "+city;
			}
		}
		return session.createQuery(hql).list();
	}

	@Override
	public void saveMessage(Messagerecord message) throws DataAccessException {
		session.saveOrUpdate(message);
	}

	@Override
	public List<Messagerecord> listSendMessage(String senderName)
			throws DataAccessException {
		return session.createQuery("from Messagerecord m where m.sender like ? and m.senderstatus = 0").setString(0, senderName).list();
	}

	@Override
	public List<Messagerecord> listRecieveMessage(String recieveName)
			throws DataAccessException {
		return session.createQuery("from Messagerecord m where m.receiver like ? and m.receiverstatus = 0").setString(0, recieveName).list();
	}

	@Override
	public Messagerecord findMessage(Long id) throws DataAccessException {
		return (Messagerecord) session.get(Messagerecord.class, id);
	}

	@Override
	public void deleteRecieveMessage(Long id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSendMessage(Long id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

}
