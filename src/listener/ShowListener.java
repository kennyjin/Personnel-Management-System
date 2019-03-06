package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Add;
import view.Edit;
import view.MainWindow;
import view.Search;

public class ShowListener implements ActionListener
{
    MainWindow mw;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("增加"))
		{
			Add add=new Add(mw);
			
		}
		else if(e.getActionCommand().equals("修改"))
		{
			Edit edit=new Edit(mw);
		}
		else if(e.getActionCommand().equals("查询"))
		{
			Search search=new Search(mw);
		}
		
	}
	public ShowListener(MainWindow mw) {
		this.mw = mw;
	}

}
