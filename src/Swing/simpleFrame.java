package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class simpleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					simpleFrame frame = new simpleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public simpleFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 83, 26);
		getContentPane().add(menuBar);
		
		JMenu menu1 = new JMenu("文件");
		menuBar.add(menu1);
		
		JMenu menu2 = new JMenu("编辑");
		menuBar.add(menu2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 63, 432, 74);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("用户名");
		label1.setBounds(14, 13, 45, 18);
		panel.add(label1);
		
		JLabel label2 = new JLabel("密码");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(0, 44, 63, 31);
		panel.add(label2);
		
		
	}
}
