package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import listener.DeleteListener;
import listener.InputListener;
import listener.MouseListener;
import listener.OutputListener;
import listener.ShowListener;
import listener.UpdateListener;
import model.JTable1;

public class MainWindow 
{
	public boolean mouseflag;//ֵΪfalse����Ϊ����true������
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane jscp;
	public JMenuItem add;
	public JMenuItem edit;
	public JMenuItem search;
	public JButton btn1;
	public JButton btn3;
	public JButton btn5;
	public MainWindow()
	{
		JFrame frame=new JFrame("���¹���ϵͳ");
		Container con=frame.getContentPane();
		con.setLayout(new FlowLayout());
		JMenuBar bar=new JMenuBar();
		JMenu file=new JMenu("File");
		JMenu help=new JMenu("Help");
		add=new JMenuItem("����");
		ShowListener show=new ShowListener(this);
		add.addActionListener(show);
		DeleteListener dl=new DeleteListener(this);
		JMenuItem delete=new JMenuItem("ɾ��");
		delete.addActionListener(dl);
		edit=new JMenuItem("�޸�");
		edit.addActionListener(show);
		JMenuItem update=new JMenuItem("����");
		search=new JMenuItem("��ѯ");
		search.addActionListener(show);
		JMenuItem input=new JMenuItem("����");
		InputListener il=new InputListener(this);
		input.addActionListener(il);
		JMenuItem output=new JMenuItem("����");
		OutputListener ol=new OutputListener(this);
		output.addActionListener(ol);
		file.add(add);
		file.add(delete);
		file.add(edit);
		file.add(update);
		file.add(search);
		file.add(input);
		file.add(output);
		bar.add(file);
		bar.add(help);
		bar.setPreferredSize(new Dimension(460,30));
		frame.setJMenuBar(bar);
		JLabel label=new JLabel("                                                              ���¹���ϵͳ");
		Object[] obj={"���","����","�Ա�","����","����"};
		model=new DefaultTableModel(obj,0);
		table=new JTable1(model);
		jscp=new JScrollPane(table);
		MouseListener ml=new MouseListener(this);
		table.addMouseListener(ml);
		JPanel p1=new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(label,BorderLayout.NORTH);
		p1.add(jscp,BorderLayout.CENTER);
		btn1=new JButton("����");
		btn1.addActionListener(show);
		JButton btn2=new JButton("ɾ��");
		btn2.addActionListener(dl);
		btn3=new JButton("�޸�");
		btn3.addActionListener(show);
		JButton btn4=new JButton("����");
		UpdateListener ul=new UpdateListener(this);
		btn4.addActionListener(ul);
		btn5=new JButton("��ѯ");
		btn5.addActionListener(show);
		JPanel p2=new JPanel();
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		p2.add(btn4);
		p2.add(btn5);
		con.add(p1);
		con.add(p2);
		frame.setSize(500, 560);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
