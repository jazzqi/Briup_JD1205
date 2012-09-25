package com.briup.bbs.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.briup.bbs.pojo.Member;
import com.briup.bbs.pojo.Post;
import com.briup.bbs.pojo.Topic;
import com.briup.bbs.service.PostService;
import com.briup.bbs.service.TopicService;
import com.briup.bbs.service.impl.PostServiceImpl;
import com.briup.bbs.service.impl.TopicServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport {
	private Post post;
	private Topic topic;
	private Integer currentPage;

	private final TopicService topicService = new TopicServiceImpl();
	private final PostService postService = new PostServiceImpl();

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String addPost() {
		Post postInfo = new Post();
		postInfo.setContent(this.post.getContent());
		postInfo.setTitle(this.post.getTitle());
		postInfo.setTopic(topicService.findTopicByName(topic.getName()));
		postInfo.setIssueDate(new Date());
		// postInfo.setMember((Member)ActionContext.getContext().getSession().get("member"));
		postInfo.setMember((Member) ServletActionContext.getRequest()
				.getSession().getAttribute("member"));
		if (postService.saveOrUpdate(postInfo)) {
			return "add_post_success";
		}
		return "add_post_failed";
	}

	public String listPost() {
		List<Post> currentPosts = null;
		Member memberCur = (Member) ActionContext.getContext().getSession()
				.get("member");
		int postCount = postService.findPostCountByMemberId(memberCur.getId());
		int count = 5;
		int pageCount = (postCount - 1) / count + 1;
		currentPosts = postService.findCurrentPosts(currentPage,
				memberCur.getId(), pageCount, postCount, count);
		if (currentPosts.size() >= 0){
			Map session = ActionContext.getContext().getSession();
			session.put("currentPosts", currentPosts);
			session.put("pageCount", pageCount);
			session.put("currentPage", currentPage);
			session.put("listMethod", "listPost");
			session.put("currentListType", "listPost.action?currentPage=1");
			return "list_post_success";
		}
		return "list_post_failed";
	}

	public String listAllPost() {
		List<Post> currentPosts = null;
		int postCount = postService.findAllPostCount();
		int count = 10;
		int pageCount = (postCount - 1) / count + 1;
		currentPosts=postService.findCurrentPosts(currentPage, pageCount, postCount, count);
		if(currentPosts.size()>=0){
			Map session = ActionContext.getContext().getSession();
			session.put("currentPosts", currentPosts);
			session.put("pageCount", pageCount);
			session.put("currentPage", currentPage);
			session.put("listMethod", "listAllPost");
			session.put("currentListType", "listAllPost.action?currentPage=1");
			return "list_post_success";
		}
		return "list_post_success";
	}

	public String deletePost() {
		Integer id = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("postId"));
		if (postService.deletePostById(id)) {
			ActionContext.getContext().getValueStack().set("currentListType", ActionContext.getContext().getSession().get("currentListType"));
			return SUCCESS;
		}
		return "input";
	}

	public String viewPost() {
		Integer id = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("postId"));
		Post post = postService.findPostById(id);
		if (null != post) {
			ActionContext.getContext().getValueStack().push(post);
			return SUCCESS;
		}
		return "input";
	}

	public String modifyPost() {
		Integer id = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("postId"));
		Post post = postService.findPostById(id);
		if (null != post) {
			ActionContext.getContext().getSession().put("post", post);
			ActionContext.getContext().getSession()
					.put("topics", new TopicServiceImpl().findAllTopic());
			return SUCCESS;
		}
		return "input";
	}

	public String savePost() {
		Post postInfo = (Post) ActionContext.getContext().getSession()
				.get("post");
		postInfo.setContent(this.post.getContent());
		postInfo.setTitle(this.post.getTitle());
		postInfo.setTopic(topicService.findTopicByName(topic.getName()));
		postInfo.setIssueDate(new Date());
		if (postService.saveOrUpdate(postInfo)) {
			ActionContext.getContext().getValueStack()
					.set("postId", postInfo.getId());
			// ServletActionContext.getRequest().setAttribute("postId", postInfo.getId());
			return SUCCESS;
		}
		return "input";
	}
}
