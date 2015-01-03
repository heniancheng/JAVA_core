package AWT;

import java.awt.*;

import javax.swing.Box;

public class testComponent {
	Frame f=new Frame("test");
	Button ok=new Button("ok");
	CheckboxGroup group=new CheckboxGroup();
	Checkbox female=new Checkbox("girl",group,false);
	Checkbox male=new Checkbox("boy",group,true);
	Checkbox married= new Checkbox("married",group,false);
	Choice color=new Choice();
	List colorList = new List(6, true);
	TextArea text=new TextArea(5,20);
	TextField name=new TextField(50);
	public void init(){
		color.add("red");
		color.add("blue");
		colorList.add("red");
		colorList.add("blue");
		Panel p1=new Panel();
		p1.add(name);
		p1.add(ok);
		f.add(p1,BorderLayout.SOUTH);
		Panel p2=new Panel();
		p2.add(color);
		p2.add(male);
		p2.add(female);
		p2.add(married);
		Box topleft=Box.createVerticalBox();
		topleft.add(text);
		topleft.add(p2);
		Box top=Box.createHorizontalBox();
		top.add(topleft);
		top.add(colorList);
		f.add(top);
		f.pack();
		f.setVisible(true);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new testComponent().init();
	}

}
