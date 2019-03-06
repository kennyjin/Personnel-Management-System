package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import model.Staff;
import view.MainWindow;

public class OutputListener implements ActionListener
{
	MainWindow mw;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("导出"))
		{
			JFileChooser chooser=new JFileChooser();
			chooser.showSaveDialog(null);
			File file=chooser.getSelectedFile();
			if (file==null)
			{
				return;
			}
			ArrayList<Staff> al=new ArrayList<Staff>();
			for (int row=0;row<mw.table.getRowCount();row++)
			{
			int id=Integer.parseInt(String.valueOf(mw.table.getValueAt(row, 0)));
			String name=String.valueOf(mw.table.getValueAt(row, 1));
			int sex=0;
			if(mw.table.getValueAt(row, 2).equals("女"))
			{
			    sex=0;
			}
			else
			{
				sex=1;
			}
			String department=String.valueOf(mw.table.getValueAt(row, 3));
			int salary=Integer.parseInt(String.valueOf(mw.table.getValueAt(row, 4)));
			al.add(new Staff(id,name,sex,department,salary));
			}
			Document document=DocumentHelper.createDocument();
			Element root=document.addElement("company");
			
//			File file=new File("src/company.xml");
			for (Staff s:al)
			{
				Element staff=root.addElement("staff");
				Element id=staff.addElement("id");
				id.setText(String.valueOf(s.getId()));
				Element name=staff.addElement("name");
				name.setText(s.getName());
				Element sex=staff.addElement("sex");
				sex.setText(String.valueOf(s.getSex()));
				Element department=staff.addElement("department");
				department.setText(String.valueOf(s.getDepartment()));
				Element salary=staff.addElement("salary");
				salary.setText(String.valueOf(s.getSalary()));
			}
			try {
				BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
				document.write(bw);
				bw.flush();
				bw.close();
				JOptionPane.showMessageDialog(null, "导出成功","提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public OutputListener(MainWindow mw) {
		super();
		this.mw = mw;
	}

}
