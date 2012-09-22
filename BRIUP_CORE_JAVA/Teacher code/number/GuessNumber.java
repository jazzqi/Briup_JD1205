package com.briup.ch12;

public class GuessNumber {
	// 最终的答案
	private int num;
	// 猜的次数
	private int numGuesses;
	// 用户猜的数据
	private String answer;
	// 是否符合结果
	private boolean success;
	// 提示信息
	private String hint;
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the numGuesses
	 */
	public int getNumGuesses() {
		return numGuesses;
	}
	/**
	 * @param numGuesses the numGuesses to set
	 */
	public void setNumGuesses(int numGuesses) {
		this.numGuesses = numGuesses;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the hint
	 */
	public String getHint() {
		return hint;
	}
	/**
	 * @param hint the hint to set
	 */
	public void setHint() {
		int ans = Integer.parseInt
		(answer.trim());
		if(num<ans){
			this.hint="higher";
		}else if(num>ans){
			this.hint="lower";
		}
	}
	
	
}
