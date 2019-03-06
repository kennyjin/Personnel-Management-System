package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import dbConnection.DBConnection;
import view.Login;
import view.MainWindow;

public class LoginListener implements ActionListener {
	Login log;
    public LoginListener (Login log)
    {
    	this.log=log;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("登录"))
		{
			String username=this.log.field1.getText();
			String password=String.valueOf(this.log.field2.getPassword());
			Connection conn=DBConnection.getConnection();
			Statement stat=null;
			ResultSet rs=null;
			String sql="select* from manager where username='"+username+"'"+"and password='"+password+"'";
			try {
				stat=conn.createStatement();
				rs=stat.executeQuery(sql);
				if(rs.next())
				{
					MainWindow mw=new MainWindow();
					log.frame.dispose();
					rs.close();
					stat.close();
					conn.close();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "用户名或密码错误","提示", JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}


}
