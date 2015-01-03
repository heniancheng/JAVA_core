package AWT;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class testPaint {
	private final String RECT="rect";
	private final String OVAL="oval";
	private Frame f=new Frame("paint");
	private Button rect=new Button("rect");
	private Button oval=new Button("oval");
	private myCanvas drawArea=new myCanvas();
	private String shape="";
	public void init(){
		Panel p=new Panel();
		rect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shape=RECT;
				drawArea.repaint();
			}
		});
		oval.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shape=OVAL;
				drawArea.repaint();
			}
		});
		p.add(rect);
		p.add(oval);
		drawArea.setPreferredSize(new Dimension(250,180));
		f.add(drawArea);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	class myCanvas extends Canvas{
		public void paint(Graphics g){
			Random rand=new Random();
			if(shape.equals(RECT)){
				g.setColor(new Color(100,80,150));
				g.fillRect(rand.nextInt(200), rand.nextInt(100), 40, 60);
			}
			if(shape.equals(OVAL)){
				g.setColor(new Color(100,80,150));
				g.fillOval(rand.nextInt(200), rand.nextInt(100), 40, 60);
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new testPaint().init();
	}

}
