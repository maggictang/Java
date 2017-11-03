package com.tty;
/**
 * 棋子类
 */
public enum ChessMan {
	
	BLACK("●"),WHITE("○");
	private String chessMan;
	/**
	 * 私有类，不允许外部创建对象，只能
	 */
	private ChessMan(String chessMan) {
		this.chessMan = chessMan;
	}
	public String getChessMan() {
		return chessMan;
	}
}
