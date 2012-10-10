package com.briup.run.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.briup.run.common.bean.Blackrecord;
import com.briup.run.common.bean.Friendrecord;
import com.briup.run.common.bean.Graderecord;
import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Memberspace;
import com.briup.run.common.bean.Pointaction;
import com.briup.run.common.bean.Pointrecord;
import com.briup.run.common.exception.DataAccessException;
import com.briup.run.dao.IMemberDao;

public class MemberDao implements IMemberDao {
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Memberinfo findMemberinfoByName(String name)
			throws DataAccessException {
		try {
			if (0 != session
					.createQuery("from Memberinfo m where m.nickname=?")
					.setString(0, name).list().size()) {
				return (Memberinfo) (session
						.createQuery("from Memberinfo m where m.nickname=?")
						.setString(0, name).list().get(0));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveOrUpdateMemberinfo(Memberinfo memberinfo)
			throws DataAccessException {
		Memberinfo persistentMemberinfo = this.findMemberinfoByName(memberinfo
				.getNickname());
		if (null != persistentMemberinfo) {
			memberinfo.setId(persistentMemberinfo.getId());
			// session.clear();
			session.update(memberinfo);
		} else {
			session.save(memberinfo);
		}
	}

	@Override
	public List<Memberinfo> findMemberinfoByNum(int number)
			throws DataAccessException {
		List<Memberinfo> members = session.createQuery(
				"from Memberinfo order by point desc").list();
		// System.out.println("members+++++++++++++++++++++++++++++++++++"+members.size());
		if (members.size() >= 10) {
			return members.subList(0, 10);
		}
		return members;
	}

	@Override
	public Integer findMemberinfoOnline() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Graderecord findMemberinfoLevel(Long point)
			throws DataAccessException {
		List result = session
				.createQuery(
						"from Graderecord where ? between minpoint and maxpoint")
				.setLong(0, point).list();
		if (result.size() > 0) {
			return (Graderecord) result.get(0);
		}
		return null;
	}

	@Override
	public Pointaction findPointactionByPointAction(String pointAction)
			throws DataAccessException {
		if (0 != session
				.createQuery("from Pointaction where actionname like ?")
				.setString(0, pointAction).list().size()) {
			return (Pointaction) session
					.createQuery("from Pointaction where actionname like ?")
					.setString(0, pointAction).list().get(0);
		}
		return null;
	}

	@Override
	public void saveOrUpdatePointrecord(Pointrecord pointrecord)
			throws DataAccessException {
		session.saveOrUpdate(pointrecord);
	}

	@Override
	public void saveOrUpdateFriend(Friendrecord friend)
			throws DataAccessException {
		session.save(friend);
	}

	@Override
	public void saveOrUpdateFriend(Blackrecord friend)
			throws DataAccessException {
		session.save(friend);
	}

	@Override
	public List<Memberinfo> listFriend(String selfname)
			throws DataAccessException {
		List friends = new ArrayList();
		List record = session.createQuery("from Friendrecord f where f.selfname like ?").setString(0, selfname).list();
		if(null != record && record.size()>0){
			for (Object friend : record) {
				Memberinfo m = this.findMemberinfoByName(((Friendrecord)friend).getFriendname());
				if(null != m){
					friends.add(m);
				}
			}
		}
		return friends;
	}

	@Override
	public List<Memberinfo> listBlack(String selfname)
			throws DataAccessException {
		List black = new ArrayList();
		List record = session.createQuery("from Blackrecord b where b.selfname like ?").setString(0, selfname).list();
		if(null != record && record.size()>0){
			for (Object o: record) {
				Memberinfo m = this.findMemberinfoByName(((Blackrecord)o).getBlackname());
				if(null != m){
					black.add(m);
				}
			}
		}
		return black;
	}

	@Override
	public void deleleBlack(Blackrecord black) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleleFriend(Friendrecord friend) throws DataAccessException {
		session.delete(friend);
	}

	@Override
	public Friendrecord findfriend(String selfName, String friendName)
			throws DataAccessException {
		List result = session.createQuery(
				"from Friendrecord where selfname like ? and friendname like ?")
				.setString(0, selfName).setString(1, friendName).list();
		if(null != result && result.size()>0){
			return (Friendrecord) result.get(0);
		}
		return null;
	}

	@Override
	public Blackrecord findBlack(String selfName, String blackName)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Memberspace findSpace(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delSpace(Memberspace space) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public Memberspace getSpace(Memberinfo member) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if (0 != session
					.createQuery("from Memberspace m where m.memberinfo=?")
					.setLong(0, member.getId()).list().size()) {
				return (Memberspace) (session
						.createQuery("from Memberspace m where m.memberinfo=?")
						.setLong(0, member.getId()).list().get(0));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
