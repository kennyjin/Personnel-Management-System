package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import dbConnection.DBConnection;
import model.Staff;
import view.Add;
import view.MainWindow;

public class AddListener implements ActionListener
{
    Add add;
    MainWindow mw;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("确定"))
		{
			Staff staff=null;
			int id=0;
			String name=null;
			int sex=0;
			String department=null;
			int salary=0;
			try{
				id=Integer.valueOf(add.getField1().getText());
				name=add.getField2().getText();
				sex=add.getBox1().getSelectedIndex();
				department=String.valueOf(add.getBox2().getSelectedItem());
				salary=Integer.valueOf(add.getField3().getText());
				staff=new Staff(id,name,sex,department,salary);
			}catch (Exception e1){
				JOptionPane.showMessageDialog(null, "数据错误，请重新输入","提示", JOptionPane.WARNING_MESSAGE);
				return;
			}
			Connection conn=DBConnection.getConnection();
			Statement stat=null;
			ResultSet rs=null;
			String sql="insert into staff values("+id+","+"'"+name+"',"+sex+",'"+department+"',"+salary+")";
			String sql1="select *from staff where id="+id;
			try {
				stat=conn.createStatement();
				rs=stat.executeQuery(sql1);
				if(!rs.next())
				{
				stat.executeUpdate(sql);
				String str=(sex==0)?"女":"男";
				Object[] rowData={staff.getId(),staff.getName(),str,staff.getDepartment(),staff.getSalary()};
			    mw.model.addRow(rowData);
			    rs.close();
			    stat.close();
			    conn.close();
			    add.getFrame().dispose();
			    mw.btn1.setEnabled(true);
			    mw.add.setEnabled(true);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "id重复，请重新输入","提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
	}
	public AddListener(Add add, MainWindow mw) {
		this.add = add;
		this.mw = mw;
	}


}
