package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class testMenu {
	Frame f=new Frame("test");
	MenuBar menubar=new MenuBar();
	Menu file=new Menu("file");
	Menu edit=new Menu("edit");
	Menu fomat=new Menu("fomat");
	PopupMenu popmenu=new PopupMenu();
	MenuItem creat=new MenuItem("creat");
	MenuItem save=new MenuItem("save");
	MenuItem exit=new MenuItem("exit",new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap=new CheckboxMenuItem("auto warp");
	MenuItem copy=new MenuItem("copy");
	MenuItem paste=new MenuItem("paste");
	MenuItem comment=new MenuItem("comment",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem nocomment=new MenuItem("nocomment");
	private TextArea text=new TextArea(6,40);
	public void init(){
		ActionListener menuListener=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String cmd=e.getActionCommand();
				text.append("click "+cmd+" menu "+"\n");
				if(cmd.equals("exit")){
					System.exit(0);
				}
			}
		};
		comment.addActionListener(menuListener);
		exit.addActionListener(menuListener);
		file.add(creat);
		file.add(save);
		file.add(exit);
		fomat.add(comment);
		fomat.add(nocomment);
//		edit.add(autoWrap);
//		edit.addSeparator();
//		edit.add(copy);
//		edit.add(paste);
//		edit.add(new MenuItem("-"));
//		edit.add(fomat);
		
		popmenu.add(autoWrap);
		popmenu.addSeparator();
		popmenu.add(copy);
		popmenu.add(paste);
		popmenu.add(new MenuItem("-"));
		popmenu.add(fomat);
		final Panel p=new Panel();
		p.setPreferredSize(new Dimension(100,60));
		p.add(popmenu);
		p.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(e.isPopupTrigger()){
					popmenu.show(p, e.getX(), e.getY());
				}
			}
		});
		f.add(p);
		
		menubar.add(file);
//		menubar.add(edit);
		f.setMenuBar(menubar);
		f.addWindowListener(new WindowAdapter(){
			public void WindowClosing(WindowEvent e){
				text.append("is closing window");
				System.exit(0);
			}
		});
//		f.add(text);
		f.add(text,BorderLayout.NORTH);
		f.pack();
		f.setVisible(true);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new testMenu().init();
	}

}
