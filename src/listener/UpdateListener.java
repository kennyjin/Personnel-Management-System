package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dbConnection.DBConnection;
import model.Staff;
import view.MainWindow;

public class UpdateListener implements ActionListener
{
    MainWindow mw;
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("¸üÐÂ"))
		{
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			conn=DBConnection.getConnection();
			String sql="select* from staff";
			ArrayList<Staff> al=new ArrayList<Staff>();
			try {
				stat=conn.createStatement();
				rs=stat.executeQuery(sql);
				while (rs.next())
				{
					int id=rs.getInt("id");
					String name=rs.getString("name");
					int sex=rs.getInt("sex");
					String department=rs.getString("department");
					int salary=rs.getInt("salary");
					al.add(new Staff(id,name,sex,department,salary));
				}
				rs.close();
				stat.close();
				conn.close();
				int count=mw.model.getRowCount();
				for(int i=1;i<=count;i++)
				{
					mw.model.removeRow(0);
				}
				for(Staff s:al)
				{
					String str=(s.getSex()==0)?"Å®":"ÄÐ";
					Object[] rowData={s.getId(),s.getName(),str,s.getDepartment(),s.getSalary()};
					mw.model.addRow(rowData);
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	public UpdateListener(MainWindow mw) {
		this.mw = mw;
	}
	
}
