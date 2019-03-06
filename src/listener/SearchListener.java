package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import dbConnection.DBConnection;
import model.Staff;
import view.MainWindow;
import view.Search;

public class SearchListener implements ActionListener
{
	    MainWindow mw;
	    Search search;
	    public SearchListener(MainWindow mw, Search search) {
			this.mw = mw;
			this.search = search;
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("确定"))
			{
				Connection conn=null;
				Statement stat=null;
				ResultSet rs=null;
				conn=DBConnection.getConnection();
				String sql=null;
				try{
				if (search.getBox3().getSelectedIndex()==1)
				{
					if(search.getField1().getText().length()==0&&search.getField2().getText().length()==0&&search.getField3().getText().length()==0)
					{
					sql="select* from staff where sex='"+search.getBox1().getSelectedIndex()+"'or department='"+String.valueOf(search.getBox2().getSelectedItem())+"'";
					}
					else if (search.getField1().getText().length()==0&&search.getField2().getText().length()!=0&&search.getField3().getText().length()!=0)
					{
						sql="select* from staff where sex='"+search.getBox1().getSelectedIndex()+"'or department='"+String.valueOf(search.getBox2().getSelectedItem())+"' or salary="+Integer.valueOf(search.getField3().getText());
					}
					else if(search.getField1().getText().length()==0&&search.getField2().getText().length()!=0&&search.getField3().getText().length()==0)
					{
						sql="select* from staff where name like '%"+search.getField2().getText()+"%' or sex='"+search.getBox1().getSelectedIndex()+"'or department='"+String.valueOf(search.getBox2().getSelectedItem())+"'";					
					}
					else if(search.getField1().getText().length()==0&&search.getField2().getText().length()==0&&search.getField3().getText().length()!=0)
					{
						sql="select* from staff where sex='"+search.getBox1().getSelectedIndex()+"'or department='"+String.valueOf(search.getBox2().getSelectedItem())+"' or salary="+Integer.valueOf(search.getField3().getText());					
					}
					else if(search.getField1().getText().length()!=0&&search.getField2().getText().length()==0&&search.getField3().getText().length()==0)
					{
						sql="select* from staff where id="+Integer.valueOf(search.getField1().getText())+ " or sex='"+search.getBox1().getSelectedIndex()+"'or department='"+String.valueOf(search.getBox2().getSelectedItem())+"'";					
					}
					else if(search.getField1().getText().length()!=0&&search.getField2().getText().length()==0&&search.getField3().getText().length()!=0)
					{
						sql="select* from staff where id="+Integer.valueOf(search.getField1().getText())+" or sex='"+search.getBox1().getSelectedIndex()+"'or department='"+String.valueOf(search.getBox2().getSelectedItem())+"' or salary="+Integer.valueOf(search.getField3().getText());
					}
					else if(search.getField1().getText().length()!=0&&search.getField2().getText().length()!=0&&search.getField3().getText().length()==0)
					{
						sql="select* from staff where id="+Integer.valueOf(search.getField1().getText())+" or name like '%"+search.getField2().getText()+"%' or sex='"+search.getBox1().getSelectedIndex()+"'or department='"+String.valueOf(search.getBox2().getSelectedItem())+"'";
					}
					else if(search.getField1().getText().length()!=0&&search.getField2().getText().length()!=0&&search.getField3().getText().length()!=0)
					{
						sql="select* from staff where id="+Integer.valueOf(search.getField1().getText())+" or name like '%"+search.getField2().getText()+"%' or sex='"+search.getBox1().getSelectedIndex()+"'or department='"+String.valueOf(search.getBox2().getSelectedItem())+"' or salary="+Integer.valueOf(search.getField3().getText());
					}
				}
				else if(search.getBox3().getSelectedIndex()==0)
				{
					if(search.getField1().getText().length()==0&&search.getField2().getText().length()==0&&search.getField3().getText().length()==0)
					{
					sql="select* from staff where sex='"+search.getBox1().getSelectedIndex()+"'and department='"+String.valueOf(search.getBox2().getSelectedItem())+"'";
					}
					else if (search.getField1().getText().length()==0&&search.getField2().getText().length()!=0&&search.getField3().getText().length()!=0)
					{
						sql="select* from staff where sex='"+search.getBox1().getSelectedIndex()+"'and department='"+String.valueOf(search.getBox2().getSelectedItem())+"' and salary="+Integer.valueOf(search.getField3().getText());
					}
					else if(search.getField1().getText().length()==0&&search.getField2().getText().length()!=0&&search.getField3().getText().length()==0)
					{
						sql="select* from staff where name like '%"+search.getField2().getText()+"%' and sex='"+search.getBox1().getSelectedIndex()+"'and department='"+String.valueOf(search.getBox2().getSelectedItem())+"'";					
					}
					else if(search.getField1().getText().length()==0&&search.getField2().getText().length()==0&&search.getField3().getText().length()!=0)
					{
						sql="select* from staff where sex='"+search.getBox1().getSelectedIndex()+"'and department='"+String.valueOf(search.getBox2().getSelectedItem())+"' and salary="+Integer.valueOf(search.getField3().getText());					
					}
					else if(search.getField1().getText().length()!=0&&search.getField2().getText().length()==0&&search.getField3().getText().length()==0)
					{
						sql="select* from staff where id="+Integer.valueOf(search.getField1().getText())+ " and sex='"+search.getBox1().getSelectedIndex()+"'and department='"+String.valueOf(search.getBox2().getSelectedItem())+"'";					
					}
					else if(search.getField1().getText().length()!=0&&search.getField2().getText().length()==0&&search.getField3().getText().length()!=0)
					{
						sql="select* from staff where id="+Integer.valueOf(search.getField1().getText())+" and sex='"+search.getBox1().getSelectedIndex()+"'and department='"+String.valueOf(search.getBox2().getSelectedItem())+"' and salary="+Integer.valueOf(search.getField3().getText());
					}
					else if(search.getField1().getText().length()!=0&&search.getField2().getText().length()!=0&&search.getField3().getText().length()==0)
					{
						sql="select* from staff where id="+Integer.valueOf(search.getField1().getText())+" and name like '%"+search.getField2().getText()+"%' and sex='"+search.getBox1().getSelectedIndex()+"'and department='"+String.valueOf(search.getBox2().getSelectedItem())+"'";
					}
					else if(search.getField1().getText().length()!=0&&search.getField2().getText().length()!=0&&search.getField3().getText().length()!=0)
					{
						sql="select* from staff where id="+Integer.valueOf(search.getField1().getText())+" and name like '%"+search.getField2().getText()+"%' and sex='"+search.getBox1().getSelectedIndex()+"'and department='"+String.valueOf(search.getBox2().getSelectedItem())+"' and salary="+Integer.valueOf(search.getField3().getText());
					}
				}
				}catch (Exception e1){
					JOptionPane.showMessageDialog(null, "数据错误，请重新输入","提示", JOptionPane.WARNING_MESSAGE);
				}
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
						String str=(s.getSex()==0)?"女":"男";
						Object[] rowData={s.getId(),s.getName(),str,s.getDepartment(),s.getSalary()};
						mw.model.addRow(rowData);
					}
					search.getFrame().dispose();
					mw.search.setEnabled(true);
					mw.btn5.setEnabled(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "数据错误，请重新输入","提示", JOptionPane.WARNING_MESSAGE);
				}
				
			}
			else if(e.getActionCommand().equals("取消"))
			{
				search.getFrame().dispose();
				mw.search.setEnabled(true);
				mw.btn5.setEnabled(true);
			}
		}
}
