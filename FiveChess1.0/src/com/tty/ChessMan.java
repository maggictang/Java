package com.tty;
/**
 * ������
 */
public enum ChessMan {
	
	BLACK("��"),WHITE("��");
	private String chessMan;
	/**
	 * ˽���࣬�������ⲿ��������ֻ��
	 */
	private ChessMan(String chessMan) {
		this.chessMan = chessMan;
	}
	public String getChessMan() {
		return chessMan;
	}
}
