package com.briup.run.web.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Memberspace;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.impl.MemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateSpaceAction extends ActionSupport{

	private Memberspace space;
    private File image; //上传的文件
    private String imageFileName; //文件名称
    private String imageContentType; //文件类型
	private final MemberService memberService = (MemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);

    @Override
    public String execute() throws Exception {
        Memberinfo member = (Memberinfo) ActionContext.getContext().getSession().get("member");
        String realpath = ServletActionContext.getServletContext().getRealPath("/icon");
        //String realpath = "C:\\RunCommunity\\icon";
        //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
        //System.out.println("realpath: "+realpath);
        //System.out.println("name: "+imageFileName);
        //System.out.println("type: "+imageContentType);
        imageFileName = member.getNickname()+"."+imageContentType.split("/")[1];
        //System.out.println("realfile: "+realpath+"_"+imageFileName);
        if (image != null) {
            File savefile = new File(new File(realpath), imageFileName);
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            FileUtils.copyFile(image, savefile);
            ActionContext.getContext().put("message", "文件上传成功");
        }
        space.setIcon(imageFileName);
        member.setMemberSpace(space);
        space.setMemberinfo(member);
        memberService.saveOrUpdate(member);
        ActionContext.getContext().getSession().put("member",member);
        //ActionContext.getContext().getValueStack().put("member_nickname",member.getNickname());
        return SUCCESS;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }
	
	public Memberspace getSpace() {
		return space;
	}

	public void setSpace(Memberspace space) {
		this.space = space;
	}
}
