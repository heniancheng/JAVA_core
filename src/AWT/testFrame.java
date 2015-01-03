package AWT;

import java.awt.*;

import javax.swing.JButton;

public class testFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame("测试窗口");
		Panel p=new Panel();
		p.add(new TextField(20));
		JButton b=new JButton("确定");
		p.add(b);
		f.add(p);
		f.setBounds(30, 30, 300, 200);
		f.setVisible(true);

	}

}
