package com.briup.ch09;

public BlackMailEvent {
	private Object source;
	private String mailAddress;
	public BlackMailEvent(Object e,String address){
		setSource(e);
		setMailAddress(address);
	}
	public void setSource(Object e) throws MailException{
		if(e == null)
			throws new MailException("sender is null!");
		this.source=e;
	}
	public void setMailAddress(String m){
		this.mailAddress=m;
	}
	public String getMailAddress(){
		return mailAddress;
	}
	public Object getSource(){
		return source;
	}
}
