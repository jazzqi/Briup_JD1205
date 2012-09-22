package com.briup.bbs.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.briup.bbs.dao.PostDao;
import com.briup.bbs.pojo.Post;

public class PostDaoImpl implements PostDao {
	private Session session;

	@Override
	public boolean saveOrUpdate(Post post) {
		// TODO Auto-generated method stub
		try {
			session.saveOrUpdate(post);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public int findPostCountByMemberId(int memberId) {
		// TODO Auto-generated method stub
		return ((Long) (session
				.createQuery(
						"select count(*) from Post p where p.member.id = ?")
				.setInteger(0, memberId).list().iterator().next())).intValue();
	}

	@Override
	public List<Post> findCurrentPosts(int currentPage, int memberId,
			int pageCount, int postCount,int count) {
		// TODO Auto-generated method stub
		if (currentPage == pageCount) {
			count = postCount-(currentPage-1)*count;
		}
		return session.createQuery("from Post p where p.member.id = ? ").setInteger(0, memberId)
				.setFirstResult((currentPage - 1) * count).setMaxResults(count)
				.list();
	}

	@Override
	public List<Post> findCurrentPosts(int currentPage, int pageCount,
			int postCount, int count) {
		// TODO Auto-generated method stub
		if(currentPage == pageCount){
			count = postCount-(currentPage-1)*count;
		}
		return session.createQuery("from Post").setFirstResult((currentPage-1)*count).setMaxResults(count).list();
	}

	@Override
	public int findAllPostCount() {
		// TODO Auto-generated method stub
		return ((Long)(session.createQuery("select count(*) from Post").list().iterator().next())).intValue();
	}

	@Override
	public boolean deletePostById(int id) {
		// TODO Auto-generated method stub
		Post post = this.findPostById(id);
		if (null != post) {
			session.delete(post);
			return true;
		}
		return false;
	}

	@Override
	public Post findPostById(int id) {
		// TODO Auto-generated method stub
		return (Post) (session.createQuery("from Post p where p.id = ?")
				.setInteger(0, id).list().iterator().next());
	}
	

}
