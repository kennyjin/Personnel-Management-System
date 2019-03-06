package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import dbConnection.DBConnection;
import view.Edit;
import view.MainWindow;

public class EditListener implements ActionListener
{
	Edit edit;
	MainWindow mw;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("确定"))
		{
			int row=mw.table.getSelectedRow();
			int id=Integer.parseInt(String.valueOf(mw.table.getValueAt(row, 0)));
			String sql="delete from staff where id="+id;
			Connection conn=DBConnection.getConnection();
			Statement stat=null;
			String name=null;
			int sex=0;
			String department=null;
			int salary=0;
			try {
				stat=conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try{
			id=Integer.parseInt(edit.getField1().getText());
			name=edit.getField2().getText();
			sex=edit.getBox1().getSelectedIndex();
			department=String.valueOf(edit.getBox2().getSelectedItem());
			salary=Integer.parseInt(edit.getField3().getText());
			String sql1="insert into staff values("+id+","+"'"+name+"',"+sex+",'"+department+"',"+salary+")";
			try{
				stat.executeUpdate(sql1);
			}catch(Exception e3){
				JOptionPane.showMessageDialog(null, "id重复，请重新输入","提示", JOptionPane.WARNING_MESSAGE);
				return;
			}
			mw.table.setValueAt(id, row, 0);
			mw.table.setValueAt(name, row, 1);
			String str=(sex==0)?"女":"男";
			mw.table.setValueAt(str, row, 2);
			mw.table.setValueAt(department, row, 3);
			mw.table.setValueAt(salary, row, 4);
			JOptionPane.showMessageDialog(null, "修改成功","提示", JOptionPane.INFORMATION_MESSAGE);
			edit.getFrame().dispose();
			mw.btn3.setEnabled(true);
			mw.edit.setEnabled(true);
			} catch (Exception e2){
				JOptionPane.showMessageDialog(null, "数据错误，请重新输入","提示", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
		}

		
	}
	public EditListener(Edit edit,MainWindow mw)
	{
		this.edit=edit;
		this.mw=mw;
	}

}
