package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author hechen
 *事件监听器可以有四种实现形式：内部类，顶级类实现监听器，类本身继承事件适配器，匿名内部类
 */

public class testEvent {
	private Frame f=new Frame("test");
	private Button ok=new Button("ok");
	private TextField text=new TextField(30);
	public void init(){
		ok.addActionListener(new OKListener());
		f.add(text);
		f.add(ok,BorderLayout.SOUTH);
		f.setBounds(30,30,300,200);
		f.setVisible(true);
	}
	
	class OKListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("click me");
			text.setText("Hello World");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new testEvent().init();
	}

}
