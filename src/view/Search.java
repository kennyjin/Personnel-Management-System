package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener.CloseListener;
import listener.SearchListener;

public class Search {
	JFrame frame;
	JTextField field1;
	JTextField field2;
	JTextField field3;
	JComboBox<Object> box1;
	JComboBox<Object> box2;
	JComboBox<Object> box3;
	public MainWindow mw;
	public JFrame getFrame() {
		return frame;
	}
	public Search(MainWindow mw)
	{
		this.mw=mw;
		mw.btn5.setEnabled(false);
		mw.search.setEnabled(false);
		frame=new JFrame("查询");
		Container con=frame.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel panel0=new JPanel();
		panel0.setLayout(new FlowLayout(0));
		JLabel label1=new JLabel("编号:");
		JLabel label2=new JLabel("姓名:");
		JLabel label3=new JLabel("性别:");
		JLabel label4=new JLabel("部门:");
		JLabel label5=new JLabel("工资:");
		JLabel label6=new JLabel("请输入查询条件:");
		field1=new JTextField("",13);
		field2=new JTextField("",13);
		field3=new JTextField("",13);
		String []str1={"女","男"};
		box1=new JComboBox<Object>(str1);
		String []str2={"vendition","lead","secretary"};
		box2=new JComboBox<Object>(str2);
		String []str3={"And","Or"};
		box3=new JComboBox<Object>(str3);
		JButton btn1=new JButton("确定");
		SearchListener sl=new SearchListener(mw,this);
		btn1.addActionListener(sl);
		JButton btn2=new JButton("取消");
		CloseListener cl=new CloseListener(this);
		btn2.addActionListener(cl);
		JPanel panel1=new JPanel();
		panel1.add(label1);
		panel1.add(field1);
		JPanel panel2=new JPanel();
		panel2.add(label2);
		panel2.add(field2);
		JPanel panel3=new JPanel();
		panel3.add(label3);
		panel3.add(box1);
		panel3.setLayout(new FlowLayout());
		JPanel panel4=new JPanel();
		panel4.add(label4);
		panel4.add(box2);
		panel4.setLayout(new FlowLayout());
		JPanel panel5=new JPanel();
		panel5.add(label5);
		panel5.add(field3);
		JPanel panel7=new JPanel();
		panel7.add(label6);
		panel7.add(box3);
		panel7.setLayout(new FlowLayout());
		JPanel panel6=new JPanel();
		panel6.add(btn1);
		panel6.add(btn2);
		panel0.add(panel1);
		panel0.add(panel2);
		panel0.add(panel3);
		panel0.add(panel4);
		panel0.add(panel5);
		panel0.add(panel7);
		con.add(panel0,BorderLayout.CENTER);
		con.add(panel6, BorderLayout.SOUTH);
		frame.setSize(220, 310);
		frame.setResizable(false);
		frame.setLocation(500, 300);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				mw.btn5.setEnabled(true);
			    mw.search.setEnabled(true);
			}
		});
		}
	public JTextField getField1() {
		return field1;
	}
	public JTextField getField2() {
		return field2;
	}
	public JTextField getField3() {
		return field3;
	}
	public JComboBox<Object> getBox1() {
		return box1;
	}
	public JComboBox<Object> getBox2() {
		return box2;
	}
	public JComboBox<Object> getBox3() {
		return box3;
	}
	public MainWindow getMw() {
		return mw;
	}
}
