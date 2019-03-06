package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import dbConnection.DBConnection;
import model.Staff;
import view.MainWindow;

public class InputListener implements ActionListener
{
	MainWindow mw;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser chooser=new JFileChooser();
		chooser.showSaveDialog(null);
		File file=chooser.getSelectedFile();
		if (file==null)
		{
			return;
		}
		if(!file.getName().endsWith(".xml"))
		{
			JOptionPane.showMessageDialog(null, "��ѡ��һ��xml�ļ�");
			return;
		}
//		File file=new File("src/company1.xml");
		SAXReader reader=new SAXReader();
		Document document=null;
		try {
			document = reader.read(file);
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Element root=document.getRootElement();
		List<Element> l=root.elements();
		ArrayList<Staff> al=new ArrayList<Staff>();
		int id=0;
		String name=null;
		int sex=0;
		String department=null;
		int salary=0;
		Connection conn=DBConnection.getConnection();
		Statement stat=null;
		int num=0;//��¼xml�еļ�¼����
		int num1=0;
		int num2=0;//��¼û��¼�������
		try {
			stat=conn.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for(Element e1:l){
			try{
				id=Integer.valueOf(e1.element("id").getText());
				name=e1.element("name").getText();
				sex=Integer.valueOf(e1.element("sex").getText());
				department=e1.element("department").getText();
				salary=Integer.valueOf(e1.element("salary").getText());
				num++;
				al.add(new Staff(id,name,sex,department,salary));
			}catch (Exception e2){
				num1++;
			}
		}
		for(Staff s:al)
		{
			String sql="insert into staff values("+s.getId()+","+"'"+s.getName()+"',"+s.getSex()+",'"+s.getDepartment()+"',"+s.getSalary()+")";
			try {
				stat.executeUpdate(sql);
				String str=(s.getSex()==0)?"Ů":"��";
				Object[] rowData={s.getId(),s.getName(),str,s.getDepartment(),s.getSalary()};
			    mw.model.addRow(rowData);
			} catch (SQLException e2) {
				num2++;
			}
			
		}
		if (num1+num2<num)
		{
			JOptionPane.showMessageDialog(null, "�ɹ�����"+(num-num1-num2)+"����¼��"+(num1+num2)+"����¼û�е��롣");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "����ʧ�ܣ�"+(num1+num2)+"����¼û�е��롣");
		}
	}
	public InputListener(MainWindow mw) {
		super();
		this.mw = mw;
	}

}
