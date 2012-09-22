package com.briup.bbs.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.briup.bbs.dao.impl.PostDaoImpl;
import com.briup.bbs.pojo.Post;
import com.briup.bbs.service.PostService;
import com.briup.bbs.util.HibernateSessionFactory;

public class PostServiceImpl implements PostService {
	private final PostDaoImpl postDao=new PostDaoImpl();

	@Override
	public boolean saveOrUpdate(Post post) {
		// TODO Auto-generated method stub
		Session session=new HibernateSessionFactory().getSession();
		postDao.setSession(session);
		Transaction transaction = session.beginTransaction();
		if(postDao.saveOrUpdate(post)){
			transaction.commit();
			return true;
		}
		transaction.rollback();
		return false;
	}

	@Override
	public int findPostCountByMemberId(int memberId) {
		// TODO Auto-generated method stub
		Session session=new HibernateSessionFactory().getSession();
		postDao.setSession(session);
		Transaction transaction=session.beginTransaction();
		int count=0;
		try{
			count = postDao.findPostCountByMemberId(memberId);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return count;
	}
	
	@Override
	public List<Post> findCurrentPosts(int currentPage, int memberId,
			int pageCount, int postCount, int count){
		Session session=new HibernateSessionFactory().getSession();
		postDao.setSession(session);
		Transaction transaction=session.beginTransaction();
		List<Post> posts=null;
		try {
			posts =  postDao.findCurrentPosts(currentPage, memberId, pageCount, postCount, count);
			transaction.commit();
			return posts;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		return null;
	}

	@Override
	public List<Post> findCurrentPosts(int currentPage, int pageCount,
			int postCount, int count) {
		// TODO Auto-generated method stub
		Session session=new HibernateSessionFactory().getSession();
		postDao.setSession(session);
		Transaction transaction = session.beginTransaction();
		List<Post> posts=null;
		try {
			posts = postDao.findCurrentPosts(currentPage, pageCount, postCount, count);
			transaction.commit();
			return posts;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return null;
	}

	@Override
	public int findAllPostCount() {
		// TODO Auto-generated method stub
		Session session=new HibernateSessionFactory().getSession();
		postDao.setSession(session);
		Transaction transaction=session.beginTransaction();
		int count=0;
		try {
			count=postDao.findAllPostCount();
			transaction.commit();
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return 0;
	}

	@Override
	public boolean deletePostById(int id) {
		Session session = new HibernateSessionFactory().getSession();
		postDao.setSession(session);
		Transaction transaction = session.beginTransaction();
		try {
			postDao.deletePostById(id);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return false;
	}

	@Override
	public Post findPostById(int id) {
		// TODO Auto-generated method stub
		Session session = new HibernateSessionFactory().getSession();
		postDao.setSession(session);
		Transaction transaction = session.beginTransaction();
		Post post = null;
		try {
			post = postDao.findPostById(id);
			transaction.commit();
			return post;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return null;
	}

}
