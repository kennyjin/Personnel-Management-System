package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import dbConnection.DBConnection;
import view.MainWindow;

public class DeleteListener implements ActionListener {
	MainWindow mw;
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("删除"))
		{
			if (mw.table.getSelectedRow()<0)
			{
				JOptionPane.showMessageDialog(null, "请先选中至少一行记录");
				return;
			}
			if(JOptionPane.showConfirmDialog(null, "确定要删除吗？")==0)
			{
			Connection conn=DBConnection.getConnection();
			Statement stat=null;
			int[] rows = mw.table.getSelectedRows();
			for (int i=0;i<rows.length;i++){
			int id=Integer.parseInt(String.valueOf(mw.table.getValueAt(rows[i], 0)));
			mw.model.removeRow(rows[i]);
			for (int j=i+1;j<rows.length;j++)
			{
				rows[j]--;
			}
			String sql="delete from staff where id="+id;
			try {
				stat=conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			}
			try {
				stat.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}
	}
	public DeleteListener(MainWindow mw)
	{
		this.mw=mw;
	}

}
