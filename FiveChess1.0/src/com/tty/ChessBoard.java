package com.tty;

import static tool.Print.*;
/**
 * 棋盘类
 */
public class ChessBoard {
	/**
	 * 创建一个15x15的棋盘
	 */
	private String[][] board = new String[15][15];
	/**
	 * 初始化棋盘
	 */
	public void initBoard() {
		for(int i = 0; i <= 14; i++) {
			for(int j = 0; j <= 14; j++) {
				board[i][j] = "十";
			}
		}
	}
	/**
	 * 打印棋盘
	 */
	public void printBoard() {
		for(int i = 0; i <= 14; i++) {
			for(int j = 0; j <= 14; j++) {
				print(board[i][j]);
			}
			//每打印完15个元素。换行
			print("\n");
		}
	}
	/**
	 * 获得棋盘
	 */
	public String[][] getBoard() {
		return this.board;
	}
	/**
	 * 玩家下棋
	 */
	public void setBoard(int x,int y,String chessMan) {
		
		board[x][y] = chessMan;
		printBoard();
	}
}
