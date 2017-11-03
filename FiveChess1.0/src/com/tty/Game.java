package com.tty;

import java.io.*;

/**
 * ��Ϸ��
 */
public class Game {
	//����һ�����̶���
	private ChessBoard board = new ChessBoard();
	/**
	 * ������������
	 */
	private int pointX = 0,pointY = 0;
	/**
	 * ��ʤ��������һ��ֱ���ϵ�������Ϊ5
	 */
	private static final int WIN_COUNT = 5;
	/**
	 * ͬһֱ�������ŵ�������
	 */
	private int sameCount = 1;
	

	/**
	 * ��ʼ����
	 */
	public void start() {
		//��Ϸ��������
		boolean isOver = false;
		boolean isDogfall = false;
		//��ʼ������
		board.initBoard();
		//��ӡ����
		board.printBoard();
		//����һ����������ȡ�û�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		try {
			while((inputStr = br.readLine())!=null) {
				//�ж������Ƿ�Ϸ�
				if(!isValid(inputStr)) {
					//���Ϸ�����������
					continue;
				}
				//����Ϸ����ͰѶ�Ӧ������Ԫ�ظ�Ϊ"��"
				String chessMan = ChessMan.BLACK.getChessMan();
				String[][] b = board.getBoard();
				if(b[pointX][pointY] == "ʮ") {
					board.setBoard(pointX, pointY, chessMan);
				}
				else {
					System.out.println("�õ��������ӣ�����������");
					continue;
				}
				//�ж��Ƿ�����Ƿ��ʤ
				if(isWin(pointX,pointY,chessMan)) {
					isOver = true;
				}
				//�ж��Ƿ�ƽ��
				else if(isDogfall() == true) {
					isDogfall = true;
				}
				else {
					//ûӮ�����Կ�ʼ����,��õ��Ե���������
					int[] cDo = this.computerDo(pointX, pointY);
					chessMan = ChessMan.WHITE.getChessMan();
					board.setBoard(cDo[0], cDo[1], chessMan);
					//�жϼ�����Ƿ�Ӯ��
					if(isWin(cDo[0],cDo[1],chessMan)) {
						isOver = true;
					}
					else if(isDogfall() ==  true) {
						isDogfall = true;
					}
				}	
				if(isOver) {
					String msg = chessMan.equals(ChessMan.BLACK.getChessMan()) ? "��ϲ��Ӯ��" : "���ź���������";
					System.out.println(msg);
					break;
				}
				if(isDogfall) {
					System.out.println("ƽ�֣�");
					break;
				}
				//board.printBoard();
				System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �ж��Ƿ�ƽ��
	 */
	private boolean isDogfall() {
		String[][] b = board.getBoard();
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				if(b[i][j] == "ʮ") {
					return false;
				}
			}
		}
		return true;
		
	}
	/**
	 * �ж������Ƿ�Ϸ�
	 */
	private boolean isValid(String input) {
		String[] str = input.split(",");

		try {
			//X������
			pointX = Integer.parseInt(str[0]);
			pointY = Integer.parseInt(str[1]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�����ʽ�������� ��   ���֣�����    �ĸ�ʽ����");
			//���´�ӡ����
			board.printBoard();
			return false;	
		} catch(NumberFormatException e) {
			System.out.println("�����ʽ�������� ��   ���֣�����    �ĸ�ʽ����");
			//���´�ӡ����
			board.printBoard();
			return false;

		}
		if(pointX < 0 || pointY <0 || pointX > 14 || pointY > 14) {
			System.out.println("X��Y����ֻ�ܴ��ڵ���0,��С�ڵ���14,����������");
			board.printBoard();
			return false;
		}
		return true;
	}
	/**
	 * �ж��Ƿ��ʤ����ʤ������һ��ֱ����5����ͬ��ɫ����������һ��
	 */
	private boolean isWin(int x,int y,String chessMan) {
		//ֱ�߿�ʼ��X����
		int startX = 0;
		//ֱ���ʼ��Y����
		int startY = 0;
		//ֱ���յ��X����
		int endX = 14;
		//ֱ���յ��Y����
		int endY = 14;

		int temp = 0;
		//ȡ��Χ
		temp = x - 4;
		startX = temp > 0 ? temp : 0;
		temp = y - 4;
		startY = temp > 0 ? temp : 0;
		temp = x + 4;
		endX = temp > 14 ? 14 : temp; 
		temp = y + 4;
		endY = temp > 14 ? 14 : temp;
		//��õ�ǰ�������
		String[][] b = board.getBoard();
		//�������ж��Ƿ��ʤ
		for(int i = startY; i < endY; i++) {
			if(b[x][i] == chessMan && b[x][i+1] == chessMan) {
				sameCount++;
				ChessType.lrCount.setI(sameCount);
			}
			else if(sameCount != WIN_COUNT){
				sameCount = 1;
			}
		}
		//���ϵ����ж��Ƿ��ʤ
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
		//�����µ������ж�
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
		//�����ϵ������ж�
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
	 * ��������
	 */
	private int[] computerDo(int x,int y) {
		String[][] b = board.getBoard();
		//�����µ����ӵ�X����
		int cX = 0;
		//�����µ����ӵ�Y����
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
		while(b[cX][cY] != "ʮ") {
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
				//�ָ�ԭ����Ϊ�����
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
