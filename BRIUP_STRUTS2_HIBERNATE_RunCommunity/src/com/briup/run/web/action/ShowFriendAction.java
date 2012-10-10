/**
 * 
 */
package com.briup.run.web.action;

import java.util.List;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ShowFriendAction extends ActionSupport {
	private final IMemberService memberService = (IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	
	@Override
	public String execute() throws Exception {
		Memberinfo member = (Memberinfo) ActionContext.getContext().getSession().get("member");
		List<Memberinfo> friend = memberService.listFriend(member.getNickname());
			//System.out.println(friend.size()+"ppppppppppppppppppppppppppppppppppp");
		if(null != friend && friend.size()>=0){
			ActionContext.getContext().getValueStack().set("friend", friend);
		}	
		return SUCCESS;
	}
}
