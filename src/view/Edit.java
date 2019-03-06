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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener.CloseListener;
import listener.EditListener;

public class Edit {
	JTextField field1;
	JTextField field2;
	JTextField field3;
	JComboBox<Object> box1;
	JComboBox<Object> box2;
	JFrame frame;
	public MainWindow mw;
	public Edit(MainWindow mw)
	{
		if (mw.table.getSelectedRow()<0||mw.table.getSelectedRows().length>1)
		{
			JOptionPane.showMessageDialog(null, "请先选中一行记录");
			return;
		}
		this.mw=mw;
		mw.btn3.setEnabled(false);
		mw.edit.setEnabled(false);
		int row=mw.table.getSelectedRow();
		int id=Integer.parseInt(String.valueOf(mw.table.getValueAt(row, 0)));
		String name=String.valueOf(mw.table.getValueAt(row, 1));
		int sex=0;
		if (String.valueOf(mw.table.getValueAt(row, 2)).equals("女"))
		{
			sex=0;
		}
		else if (String.valueOf(mw.table.getValueAt(row, 2)).equals("男"))
		{
			sex=1;
		}
		String department=String.valueOf(mw.table.getValueAt(row, 3));
		int salary=Integer.parseInt(String.valueOf(mw.table.getValueAt(row, 4)));
		frame=new JFrame("修改");
		Container con=frame.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel panel0=new JPanel();
		panel0.setLayout(new FlowLayout(0));
		JLabel label1=new JLabel("编号:");
		JLabel label2=new JLabel("姓名:");
		JLabel label3=new JLabel("性别:");
		JLabel label4=new JLabel("部门:");
		JLabel label5=new JLabel("工资:");
		field1=new JTextField(String.valueOf(id),13);
		field2=new JTextField(name,13);
		field3=new JTextField(String.valueOf(salary),13);
		String []str1={"女","男"};
		box1=new JComboBox<Object>(str1);
		box1.setSelectedIndex(sex);
		String []str2={"vendition","lead","secretary"};
		box2=new JComboBox<Object>(str2);
		if (department.equals("vendition"))
		{
			box2.setSelectedIndex(0);
		}
		else if (department.equals("lead"))
		{
			box2.setSelectedIndex(1);
		}
		else if (department.equals("secretary"))
		{
			box2.setSelectedIndex(2);
		}
		JButton btn1=new JButton("确定");
		EditListener el=new EditListener(this,mw);
		btn1.addActionListener(el);
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
		JPanel panel6=new JPanel();
		panel6.add(btn1);
		panel6.add(btn2);
		panel0.add(panel1);
		panel0.add(panel2);
		panel0.add(panel3);
		panel0.add(panel4);
		panel0.add(panel5);
		con.add(panel0,BorderLayout.CENTER);
		con.add(panel6, BorderLayout.SOUTH);
		frame.setSize(220, 260);
		frame.setLocation(500, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				mw.btn3.setEnabled(true);
			    mw.edit.setEnabled(true);
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
	public MainWindow getMw() {
		return mw;
	}
	public JFrame getFrame() {
		return frame;
	}
}
