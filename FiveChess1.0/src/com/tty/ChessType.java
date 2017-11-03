package com.tty;

public enum ChessType {
	
	/**
	 * ������ͬһֱ�������ŵ�������
	 */
	lrCount(1),
	/**
	 * ���ϵ���ͬһֱ�������ŵ�������
	 */
	tbCount(1),
	/**
	 * �����ϵ�����ͬһֱ�������ŵ�������
	 */
	ltrbCount(1),
	/**
	 * �����µ�����ͬһֱ�������ŵ�������
	 */
	lbrtCount(1);
	private int i;
	
	ChessType(int i) {
		this.i = i;
	}
	
	public int getI() {
		return this.i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
}
