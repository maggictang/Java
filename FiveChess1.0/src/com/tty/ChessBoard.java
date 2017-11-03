package com.tty;

import static tool.Print.*;
/**
 * ������
 */
public class ChessBoard {
	/**
	 * ����һ��15x15������
	 */
	private String[][] board = new String[15][15];
	/**
	 * ��ʼ������
	 */
	public void initBoard() {
		for(int i = 0; i <= 14; i++) {
			for(int j = 0; j <= 14; j++) {
				board[i][j] = "ʮ";
			}
		}
	}
	/**
	 * ��ӡ����
	 */
	public void printBoard() {
		for(int i = 0; i <= 14; i++) {
			for(int j = 0; j <= 14; j++) {
				print(board[i][j]);
			}
			//ÿ��ӡ��15��Ԫ�ء�����
			print("\n");
		}
	}
	/**
	 * �������
	 */
	public String[][] getBoard() {
		return this.board;
	}
	/**
	 * �������
	 */
	public void setBoard(int x,int y,String chessMan) {
		
		board[x][y] = chessMan;
		printBoard();
	}
}
