import java.awt.*;
import java.awt.event.*;
/**
 * 计算器
 */
public class Cel extends Frame {

	private static final long serialVersionUID = 1L;
	/**
	 * 输入文本框
	 */
	private TextField tf = new TextField();
	/**
	 * 存有其他操作符的panel
	 */
	private OtherPanel op = new OtherPanel();
	/**
	 * 运算符
	 */
	private Operator operator = null;
	/**
	 * 运算结果
	 */
	//private double result = 0;
	/**
	 * 运算符枚举类
	 */
	private enum Operator {
		ADD,REDUCE,MUL,DIV,MOD;
	}
	/**
	 * 构造器
	 */
	public Cel(String title) {
		super(title);
	}
	/**
	 * 初始化计算器
	 */
	private void init() {
		this.add(tf,BorderLayout.NORTH);
		/*tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}			
		});*/
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}		
		});
		this.add(op, BorderLayout.CENTER);
		op.init();
		pack();
	}
	/**
	 * 存有其他操作符的panel
	 *
	 */
	private class OtherPanel extends Panel {

		private static final long serialVersionUID = 1L;
		/**
		 * 清空
		 */
		Button c = new Button("C");
		/**
		 * 数字按钮数组
		 */
		Button[] nums = new Button[10];
		/**
		 * 除
		 */
		Button div = new Button("/");
		/**
		 * 开平方
		 */
		Button sqrt = new Button("√");
		/**
		 * 退格
		 */
		Button back = new Button("Back");
		/**
		 * 乘
		 */
		Button mul = new Button("*");
		/**
		 * 取模
		 */
		Button mod = new Button("%");
		/**
		 * π
		 */
		Button pai = new Button("π");
		/**
		 * 减
		 */
		Button reduce = new Button("-");
		/**
		 * 平方
		 */
		Button squ = new Button("x²");
		/**
		 * 倒数
		 */
		Button rec = new Button("1/x");
		/**
		 * 负数
		 */
		Button neg = new Button("(-)");
		/**
		 * 小数点
		 */
		Button point  = new Button(".");
		/**
		 * 加
		 */
		Button add  = new Button("+");
		/**
		 * 等号
		 */
		Button equl = new Button("=");


		private void init() {
			this.setLayout(new GridLayout(4,6));		
			//为数字按钮初始化
			for(int i = 0; i <= 9; i++) {
				String temp = String.valueOf(i);
				nums[i] = new Button(temp);
			}
			this.add(c);
			c.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText("");				
				}			
			});
			this.add(nums[7]);
			nums[7].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "7");				
				}			
			});
			this.add(nums[8]);
			nums[8].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "8");				
				}			
			});
			this.add(nums[9]);
			nums[9].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "9");				
				}			
			});
			this.add(div);		
			div.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "/");		
					operator = Operator.DIV;
				}			
			});
			this.add(sqrt);
			sqrt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//String str = tf.getText();
					//System.out.println(str);
					if(!"".equals(tf.getText())) {		
						double d = Double.parseDouble(tf.getText());
						tf.setText(String.valueOf(Math.sqrt(d)));
					}		
				}
			});
			this.add(back);
			back.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText();
					System.out.println(str);
					if("".equals(tf.getText())) {
						//如果输入框里没有内容，什么都不做
					} else {
						String subStr = str.substring(0, str.length() - 1);
						tf.setText(subStr);
					}
				}			
			});
			this.add(nums[4]);
			nums[4].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "4");				
				}			
			});
			this.add(nums[5]);
			nums[5].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "5");				
				}			
			});
			this.add(nums[6]);
			nums[6].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "6");				
				}			
			});
			this.add(mul);
			mul.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "*");		
					operator = Operator.MUL;
				}			
			});
			this.add(mod);
			mod.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "%");		
					operator = Operator.MOD;
				}			
			});
			this.add(pai);
			pai.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + Math.PI);				
				}			
			});
			this.add(nums[1]);
			nums[1].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "1");				
				}			
			});
			this.add(nums[2]);
			nums[2].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "2");				
				}			
			});
			this.add(nums[3]);
			nums[3].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "3");				
				}			
			});
			this.add(reduce);
			reduce.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "-");		
					operator = Operator.REDUCE;
				}			
			});
			this.add(squ);
			squ.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String temp = tf.getText();
					if(!("".equals(temp))) {
						double i = Double.parseDouble(temp);
						tf.setText(String.valueOf(i*i));
					}
				}			
			});
			this.add(rec);
			rec.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String temp = tf.getText();
					if(!("".equals(temp))) {
						double i = Double.parseDouble(temp);
						tf.setText(String.valueOf(1/i));
					}
				}			
			});
			this.add(nums[0]);
			nums[0].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "0");				
				}			
			});
			this.add(point);
			point.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + ".");				
				}			
			});
			this.add(neg);
			neg.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					double d = Double.parseDouble(tf.getText());
					d = 0 - d;
					tf.setText(String.valueOf(d));				
				}			
			});
			this.add(add);
			add.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(tf.getText() + "+");		
					operator = Operator.ADD;
				}			
			});
			this.add(equl);
			equl.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(operator == null) {
						
					}
					else {
						switch(operator) {
						case ADD:
						{
							String[] temp = tf.getText().split("\\+");
							double num1 = Double.parseDouble(temp[0]);
							double num2 = Double.parseDouble(temp[1]);
							//result = num1 + num2;	
							tf.setText(String.valueOf(num1 + num2));
						} break;
						case REDUCE:
						{
							String[] temp = tf.getText().split("\\-");
							double num1 = Double.parseDouble(temp[0]);
							double num2 = Double.parseDouble(temp[1]);
							tf.setText(String.valueOf(num1 - num2));			
						} break;
						case MOD:
						{
							String[] temp = tf.getText().split("\\%");
							double num1 = Double.parseDouble(temp[0]);
							double num2 = Double.parseDouble(temp[1]);
							tf.setText(String.valueOf(num1 % num2));		
						} break;
						case DIV:
						{
							String[] temp = tf.getText().split("\\/");
							double num1 = Double.parseDouble(temp[0]);
							double num2 = Double.parseDouble(temp[1]);
							tf.setText(String.valueOf(num1 / num2));				
						} break;
						case MUL:
						{
							String[] temp = tf.getText().split("\\*");
							double num1 = Double.parseDouble(temp[0]);
							double num2 = Double.parseDouble(temp[1]);
							tf.setText(String.valueOf(num1 * num2));		
						} break;
						default:
							
						}
					}			
				}			
			});
		}
	}


	public static void main(String[] args) {
		new Cel("计算器").init();
	}
}
