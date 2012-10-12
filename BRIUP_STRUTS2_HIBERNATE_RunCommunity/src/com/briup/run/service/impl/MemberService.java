package com.briup.run.service.impl;

import java.util.Date;
import java.util.List;

import com.briup.run.common.bean.Blackrecord;
import com.briup.run.common.bean.Friendrecord;
import com.briup.run.common.bean.Graderecord;
import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Memberspace;
import com.briup.run.common.bean.Pointaction;
import com.briup.run.common.bean.Pointrecord;
import com.briup.run.common.exception.DataAccessException;
import com.briup.run.common.exception.MemberServiceException;
import com.briup.run.common.transaction.HibernateTransaction;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.common.util.MD5;
import com.briup.run.common.util.RandomChar;
import com.briup.run.dao.impl.MemberDao;
import com.briup.run.service.IMemberService;

public class MemberService implements IMemberService {
	// private final MemberDao memberDao = new MemberDao();
	private final MemberDao memberDao = (MemberDao) BeanFactory
			.getBean(BeanFactory.MEMBERDAO);
	// private final MemberDao memberDao =
	// (MemberDao)BeanFactory.getBean("memberDao");
	private final HibernateTransaction ht = new HibernateTransaction();

	@Override
	public void registerMemberinfo(Memberinfo memberinfo)
			throws MemberServiceException {

		memberinfo.setPassword(MD5.getMD5Str(memberinfo.getPassword()));
		memberinfo.setRegisterdate(new Date());
		memberinfo.setPoint(0l);
		memberinfo.setLatestdate(new Date());
		memberinfo.setIsonline(1l);

		this.saveOrUpdate(memberinfo);

		// 推荐人加分
		if (null != memberinfo.getRecommender()
				&& null != this.findMemberinfoByName(memberinfo
						.getRecommender())) {
			Pointaction action0 = this
					.findPointactionByPointAction("RECOMMEND");
			Pointrecord record0 = new Pointrecord(action0,
					memberinfo.getRecommender(), new Date());
			this.save(record0);
		}
		// 本人注册加分
		Pointaction action = this.findPointactionByPointAction("REGISTER");
		Pointrecord record = new Pointrecord(action, memberinfo.getNickname(),
				new Date());
		this.save(record);
	}

	@Override
	public Memberinfo findMemberinfoByName(String nickname)
			throws MemberServiceException {
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		Memberinfo m = null;
		try {
			m = memberDao.findMemberinfoByName(nickname);
			ht.commit();
			return m;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ht.rollback();
		}
		return null;
	}

	@Override
	public Memberinfo login(String nickname, String passwd)
			throws MemberServiceException {
		Memberinfo member = this.findMemberinfoByName(nickname);
		if (null != member) {
			if (member.getPassword().equals(passwd)) {
				// 增加登录积分
				if (new Date().compareTo(member.getLatestdate()) > 0 && new Date().getDay() != member.getLatestdate().getDay()) {
					Pointaction action = this
							.findPointactionByPointAction("LOGIN");
					Pointrecord record = new Pointrecord(action,
							member.getNickname(), new Date());
					this.save(record);
				}
				// 修改上线记录和上线状态
				member.setLatestdate(new Date());
				member.setIsonline(1l);
				this.saveOrUpdate(member);
				return member;
			}
		}
		return null;

	}

	@Override
	public void logout(String nickname) throws MemberServiceException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Memberinfo> findMemberinfoByNum(int number)
			throws MemberServiceException {
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		List<Memberinfo> topmembers = null;
		try {
			topmembers = memberDao.findMemberinfoByNum(number);
			ht.commit();
			return topmembers;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ht.rollback();
		}
		return null;
	}

	@Override
	public int findMemberinfoOnline() throws MemberServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Graderecord findMemberinfoLevel(Long point)
			throws MemberServiceException {
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		Graderecord g = null;
		try {
			g = memberDao.findMemberinfoLevel(point);
			ht.commit();
			return g;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ht.rollback();
		}
		return null;
	}

	@Override
	public Memberinfo saveOrUpDate(Memberinfo memberinfo, String oldPasswd)
			throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBackPasswd(String nickname, String pwdQuestion,
			String pwdAnswer) throws MemberServiceException {
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		String newPwd = "";
		try {
			Memberinfo member = memberDao.findMemberinfoByName(nickname);
			if (null != member
					&& member.getPasswordquestion().equals(pwdQuestion)
					&& member.getPasswordanswer().equals(pwdAnswer)) {
				// 生成新密码
				newPwd = RandomChar.getChars(RandomChar.RANDOM_ALL, 6);
				member.setPassword(MD5.getMD5Str(newPwd));
				memberDao.saveOrUpdateMemberinfo(member);
				ht.commit();
			} else {
				ht.rollback();
				throw new MemberServiceException();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			ht.rollback();
		}
		return newPwd;
	}

	@Override
	public void saveOrUpdate(Memberinfo memberinfo)
			throws MemberServiceException {
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		try {
			memberDao.saveOrUpdateMemberinfo(memberinfo);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// here should throw new DataAccessException();
			ht.rollback();
		}
		ht.commit();
	}

	@Override
	public void saveOrUpdate(String selfname, String friendname)
			throws MemberServiceException {
		Friendrecord friend = new Friendrecord(selfname, friendname);
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		try {
			memberDao.saveOrUpdateFriend(friend);
			ht.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ht.rollback();
		}
	}

	@Override
	public List<Memberinfo> listFriend(String selfname)
			throws MemberServiceException {
		List<Memberinfo> friend = null;
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		try {
			friend = memberDao.listFriend(selfname);
			ht.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ht.rollback();
		}
		return friend;
	}

	@Override
	public void moveToBlack(String selfname, String blackname)
			throws MemberServiceException {
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		try {
			Friendrecord record = memberDao.findfriend(selfname, blackname);
			if (null != record) {
				memberDao.deleleFriend(record);
			}
			memberDao.saveOrUpdateFriend(new Blackrecord(selfname, blackname));
			ht.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ht.rollback();
		}
	}

	@Override
	public List<Memberinfo> listBlack(String selfname)
			throws MemberServiceException {
		List<Memberinfo> black = null;
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		try {
			black = memberDao.listBlack(selfname);
			ht.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ht.rollback();
		}
		return black;
	}

	@Override
	public Friendrecord findFriend(String selfName, String friendName)
			throws MemberServiceException {
		Friendrecord friend = null;
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		try {
			friend = memberDao.findfriend(selfName, friendName);
			ht.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ht.rollback();
		}
		return friend;
	}

	// This is a stupid method.
	@Override
	public Boolean isMemberspace(Long id) throws MemberServiceException {
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		boolean result = false;
		try {
			Memberinfo member = new Memberinfo();
			member.setId(id);
			if (null != memberDao.getSpace(member)) {
				result = true;
			}
			ht.commit();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ht.rollback();
		}
		return result;
	}

	@Override
	public void moveToFriend(String selfName, String name_searching)
			throws MemberServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleleBlack(String selfName, String black)
			throws MemberServiceException {
	}

	@Override
	public void deleleFriend(String selfName, String friend)
			throws MemberServiceException {
	}

	@Override
	public void delSpace(Long id) throws MemberServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Pointaction findPointactionByPointAction(String actionName)
			throws MemberServiceException {
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		Pointaction action = null;
		try {
			action = memberDao.findPointactionByPointAction(actionName);
			ht.commit();
			return action;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ht.rollback();
		}
		return null;
	}

	@Override
	public void save(Pointrecord pointrecord) throws MemberServiceException {
		Long point = pointrecord.getPointaction().getPoint();
		// 修改用户信息
		Memberinfo member = this
				.findMemberinfoByName(pointrecord.getNickname());
		// 修改等级
		member.setGraderecord(this.findMemberinfoLevel(member.getPoint()
				+ point));
		// 修改当前积分
		member.setPoint(member.getPoint() + point);
		this.saveOrUpdate(member);
		// 增加积分记录
		try {
			memberDao.saveOrUpdatePointrecord(pointrecord);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Memberspace getSpace(Memberinfo member)
			throws MemberServiceException {
		ht.beginTransaction();
		memberDao.setSession(ht.getSession());
		Memberspace space = null;
		try {
			space = memberDao.getSpace(member);
			ht.commit();
			return space;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ht.rollback();
		}
		return null;
	}
}
