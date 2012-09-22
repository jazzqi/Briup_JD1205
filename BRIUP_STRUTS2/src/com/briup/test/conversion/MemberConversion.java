package com.briup.test.conversion;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.briup.bbs.pojo.Member;

public class MemberConversion extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// TODO Auto-generated method stub
		if(toClass == Member.class){
			String[] memberString=values[0].trim().split(":");
			Member member=new Member();
			member.setName(memberString[0]);
			member.setAge(Integer.parseInt(memberString[1]));
			member.setEmail(memberString[2]);
			member.setTele(memberString[3]);
//			member.setName("hello");
//			member.setAge(100);
//			member.setEmail("jazzqi@gmail.com");
//			member.setTele("13526655610");
			return member;
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}


}
