package view;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listener.LoginListener;

public class Login 
{
	public JTextField field1;
	public JPasswordField field2;
	public JFrame frame;
	public Login()
	{
		frame=new JFrame("µÇÂ¼");
		Container con=frame.getContentPane();
		con.setLayout(new FlowLayout());
		field1=new JTextField("",10);
		field2=new JPasswordField("",10);
		field2.setEchoChar('*');
		JLabel label1=new JLabel("ÓÃ»§Ãû:");
		JLabel label2=new JLabel("¡¡ÃÜÂë:");
		JPanel panel1=new JPanel();
		panel1.add(label1);
		panel1.add(field1);
		JPanel panel2=new JPanel();
		panel2.add(label2);
		panel2.add(field2);
		JButton btn=new JButton("µÇÂ¼");
		LoginListener ll=new LoginListener(this);
		btn.addActionListener(ll);
		con.add(panel1);
		con.add(panel2);
		con.add(btn);
		frame.setSize(200, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500,100);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
