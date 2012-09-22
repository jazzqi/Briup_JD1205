package com.briup.bbs.dao;

import java.util.List;

import com.briup.bbs.pojo.Post;

public interface PostDao {
	public boolean saveOrUpdate(Post post);

	public boolean deletePostById(int id);

	public Post findPostById(int id);

	public int findPostCountByMemberId(int memberId);
	
	public int findAllPostCount();

	public List<Post> findCurrentPosts(int currentPage, int memberId,
			int pageCount, int postCount,int count);

	public List<Post> findCurrentPosts(int currentPage, int pageCount,
			int postCount, int count);
}
