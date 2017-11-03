package com.tty;

public enum ChessType {
	
	/**
	 * 从左到右同一直线上连着的棋子数
	 */
	lrCount(1),
	/**
	 * 从上到下同一直线上连着的棋子数
	 */
	tbCount(1),
	/**
	 * 从左上到右下同一直线上连着的棋子数
	 */
	ltrbCount(1),
	/**
	 * 从左下到右上同一直线上连着的棋子数
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
