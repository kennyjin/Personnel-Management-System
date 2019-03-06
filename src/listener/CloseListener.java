package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Add;
import view.Edit;
import view.Search;

public class CloseListener implements ActionListener
{
	Add add;
	Edit edit;
	Search search;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("È¡Ïû"))
		{
			if (add!=null)
			{
				add.getFrame().dispose();
				add.mw.btn1.setEnabled(true);
			    add.mw.add.setEnabled(true);
			}
			else if (edit!=null)
			{
				edit.getFrame().dispose();
				edit.mw.btn3.setEnabled(true);
				edit.mw.edit.setEnabled(true);
			}
			else if (search!=null)
			{
				search.getFrame().dispose();
				search.mw.btn5.setEnabled(true);
				search.mw.search.setEnabled(true);
			}
		}
	}
	public CloseListener(Add add) {
		this.add = add;
	}
	public CloseListener(Search search) {
		this.search = search;
	}
	public CloseListener(Edit edit) {
		this.edit = edit;
	}
	

}
