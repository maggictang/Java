package com.tty;

import java.io.*;

/**
 * 游戏类
 */
public class Game {
	//创建一个棋盘对象
	private ChessBoard board = new ChessBoard();
	/**
	 * 玩家下棋的坐标
	 */
	private int pointX = 0,pointY = 0;
	/**
	 * 获胜的条件，一条直线上的棋子数为5
	 */
	private static final int WIN_COUNT = 5;
	/**
	 * 同一直线上连着的棋子数
	 */
	private int sameCount = 1;
	

	/**
	 * 开始方法
	 */
	public void start() {
		//游戏结束条件
		boolean isOver = false;
		boolean isDogfall = false;
		//初始化棋盘
		board.initBoard();
		//打印棋盘
		board.printBoard();
		//创建一个输入流获取用户输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		try {
			while((inputStr = br.readLine())!=null) {
				//判断输入是否合法
				if(!isValid(inputStr)) {
					//不合法则重新输入
					continue;
				}
				//如果合法，就把对应的数组元素赋为"●"
				String chessMan = ChessMan.BLACK.getChessMan();
				String[][] b = board.getBoard();
				if(b[pointX][pointY] == "十") {
					board.setBoard(pointX, pointY, chessMan);
				}
				else {
					System.out.println("该点已有棋子，请重新输入");
					continue;
				}
				//判断是否玩家是否获胜
				if(isWin(pointX,pointY,chessMan)) {
					isOver = true;
				}
				//判断是否平局
				else if(isDogfall() == true) {
					isDogfall = true;
				}
				else {
					//没赢，电脑开始下棋,获得电脑的棋子坐标
					int[] cDo = this.computerDo(pointX, pointY);
					chessMan = ChessMan.WHITE.getChessMan();
					board.setBoard(cDo[0], cDo[1], chessMan);
					//判断计算机是否赢了
					if(isWin(cDo[0],cDo[1],chessMan)) {
						isOver = true;
					}
					else if(isDogfall() ==  true) {
						isDogfall = true;
					}
				}	
				if(isOver) {
					String msg = chessMan.equals(ChessMan.BLACK.getChessMan()) ? "恭喜您赢了" : "很遗憾，您输了";
					System.out.println(msg);
					break;
				}
				if(isDogfall) {
					System.out.println("平局！");
					break;
				}
				//board.printBoard();
				System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 判断是否平局
	 */
	private boolean isDogfall() {
		String[][] b = board.getBoard();
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				if(b[i][j] == "十") {
					return false;
				}
			}
		}
		return true;
		
	}
	/**
	 * 判断输入是否合法
	 */
	private boolean isValid(String input) {
		String[] str = input.split(",");

		try {
			//X点坐标
			pointX = Integer.parseInt(str[0]);
			pointY = Integer.parseInt(str[1]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("输入格式错误，请以 ：   数字，数字    的格式输入");
			//重新打印棋盘
			board.printBoard();
			return false;	
		} catch(NumberFormatException e) {
			System.out.println("输入格式错误，请以 ：   数字，数字    的格式输入");
			//重新打印棋盘
			board.printBoard();
			return false;

		}
		if(pointX < 0 || pointY <0 || pointX > 14 || pointY > 14) {
			System.out.println("X与Y坐标只能大于等于0,与小于等于14,请重新输入");
			board.printBoard();
			return false;
		}
		return true;
	}
	/**
	 * 判断是否获胜，获胜条件是一条直线上5个相同颜色的棋子连在一起
	 */
	private boolean isWin(int x,int y,String chessMan) {
		//直线开始的X坐标
		int startX = 0;
		//直线最开始的Y坐标
		int startY = 0;
		//直线终点的X坐标
		int endX = 14;
		//直线终点的Y坐标
		int endY = 14;

		int temp = 0;
		//取范围
		temp = x - 4;
		startX = temp > 0 ? temp : 0;
		temp = y - 4;
		startY = temp > 0 ? temp : 0;
		temp = x + 4;
		endX = temp > 14 ? 14 : temp; 
		temp = y + 4;
		endY = temp > 14 ? 14 : temp;
		//获得当前棋盘情况
		String[][] b = board.getBoard();
		//从左到右判断是否获胜
		for(int i = startY; i < endY; i++) {
			if(b[x][i] == chessMan && b[x][i+1] == chessMan) {
				sameCount++;
				ChessType.lrCount.setI(sameCount);
			}
			else if(sameCount != WIN_COUNT){
				sameCount = 1;
			}
		}
		//从上到下判断是否获胜
		if(sameCount != WIN_COUNT) {
			for(int i = startX; i < endX; i++) {
				if(b[i][y] == chessMan && b[i+1][y] ==chessMan) {
					sameCount++;
					ChessType.tbCount.setI(sameCount);
				}
				else if(sameCount != WIN_COUNT) {
					sameCount = 1;
				}
			}
		}
		//从左下到右上判断
		if(sameCount != WIN_COUNT) {
			for(int i = endX; i > startX; i--) {
				for(int j = startY; j < endY; j++) {
					if(b[i][j] == chessMan && b[i-1][j+1] == chessMan) {
						sameCount++;

					}
					else if(sameCount != WIN_COUNT) {
						sameCount = 1;
						ChessType.lbrtCount.setI(sameCount);
					}
				}
			}
		}
		//从左上到右下判断
		if(sameCount != WIN_COUNT) {
			for(int i = startX; i < endX; i++) {
				for(int j = startY; j < endY; j++) {
					if(b[i][j] == chessMan && b[i+1][j+1] == chessMan) {
						sameCount++;
						ChessType.ltrbCount.setI(sameCount);
					}
				}
			}
			if(sameCount != WIN_COUNT) {
				sameCount = 1;
			}
		}
		return sameCount == WIN_COUNT ? true : false;
	}
	/**
	 * 电脑下棋
	 */
	private int[] computerDo(int x,int y) {
		String[][] b = board.getBoard();
		//电脑下的棋子的X坐标
		int cX = 0;
		//电脑下的棋子的Y坐标
		int cY = 0;
		ChessType[] type = {ChessType.lbrtCount,ChessType.lrCount,ChessType.ltrbCount,ChessType.tbCount};
		ChessType max1 = MaxTpye(type);
		switch(max1) {
		case lbrtCount : {
			cX = x - 1;
			cY = y + 1;
			if(cY > 14) {
				cY = y - ChessType.lbrtCount.getI();
			}
			if(cX < 0) {
				cX = x + ChessType.lbrtCount.getI();
			}
		} break;
		case lrCount : {
			cY = y + 1;
			cX = x;
			if(cY > 14) {
				cY = y - ChessType.lrCount.getI();
			}
		} break;
		case ltrbCount : {
			cX = x + 1;
			cY = y + 1;
			if(cX > 14) {
				cX = x - ChessType.ltrbCount.getI();
			}
			if(cY > 14) {
				cY = x - ChessType.ltrbCount.getI();
			}
		} break;
		case tbCount : {
			cX = x + 1;
			cY = y ;
			if(cX > 14) {
				cX = x - ChessType.tbCount.getI();
			}
		} break;
		}
		while(b[cX][cY] != "十") {
			switch(max1) {
			case lbrtCount : {
				cX = x - 1;
				cY = y + 1;
				if(cY > 14) {
					cY = y - ChessType.lbrtCount.getI();
				}
				if(cX < 0) {
					cX = x + ChessType.lbrtCount.getI();
				}
			} break;
			case lrCount : {
				//恢复原来的为坐标点
				//y = y - 1;
				cY = y - 1;
				cX = x;
				if(cY < 0) {
					cY = y  + ChessType.lrCount.getI();
				}
			} break;
			case ltrbCount : {
				cX = x + 1;
				cY = y + 1;
				if(cX > 14) {
					cX = x - ChessType.ltrbCount.getI();
				}
				if(cY > 14) {
					cY = x - ChessType.ltrbCount.getI();
				}
			} break;
			case tbCount : {
				cX = x + 1;
				cY = y ;
				if(cX > 14) {
					cX = x - ChessType.tbCount.getI();
				}
			} break;
			}
			
			
			/*temp = (((int)(Math.random()*8)) - 4) + x;
			if(temp < 0) {
				temp = 0;
			} 
			else if(temp > 14) {
				temp = 14;
			}	
			cX = temp;		
			temp =  (((int)(Math.random()*8)) - 4) + y;		
			if(temp < 0) {
				temp = 0;
			} 
			else if(temp > 14) {
				temp = 14;
			}
			cY = temp;*/

		}

		int[] result = {cX,cY};
		return result;
	}	






	private ChessType MaxTpye(ChessType[] type) {
		int max = 0;
		ChessType chess = null;
		for(int i = 0; i < type.length; i++) {
			if(type[i].getI() > max) {
				max = type[i].getI();
				chess = type[i];
			}
		}
		return chess;
	}


	public static void main(String[] args) {
		new Game().start();
	}
}
