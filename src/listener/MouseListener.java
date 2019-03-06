package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.MainWindow;

public class MouseListener extends MouseAdapter
{
    MainWindow mw;

	public MouseListener(MainWindow mw) {
		super();
		this.mw = mw;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		
		if(e.getClickCount()==2)
		{
			if(mw.table.columnAtPoint(e.getPoint())==0)
			{
			if (!mw.mouseflag)
			{
				for(int i=0;i<mw.table.getRowCount();i++)
				{
				for (int row=0;row<mw.table.getRowCount()-1;row++)
				{
					int id1=Integer.parseInt(String.valueOf(mw.table.getValueAt(row, 0)));
					int id2=Integer.parseInt(String.valueOf(mw.table.getValueAt(row+1, 0)));
					if (id1<id2)
					{
						mw.model.moveRow(row, row, row+1);
					}
				}
				}
			}
			else
			{
				for(int i=0;i<mw.table.getRowCount();i++)
				{
				for (int row=0;row<mw.table.getRowCount()-1;row++)
				{
					int id1=Integer.parseInt(String.valueOf(mw.table.getValueAt(row, 0)));
					int id2=Integer.parseInt(String.valueOf(mw.table.getValueAt(row+1, 0)));
					if (id1>id2)
					{
						mw.model.moveRow(row, row, row+1);
					}
				}
				}	
			}
			mw.mouseflag=!mw.mouseflag;
			}
			else if(mw.table.columnAtPoint(e.getPoint())==1)
			{
				if (!mw.mouseflag)
				{
					for(int i=0;i<mw.table.getRowCount();i++)
					{
					for (int row=0;row<mw.table.getRowCount()-1;row++)
					{
						String name1=String.valueOf(mw.table.getValueAt(row, 1));
						String name2=String.valueOf(mw.table.getValueAt(row+1, 1));
						if (name1.compareToIgnoreCase(name2)<0)
						{
							mw.model.moveRow(row, row, row+1);
						}
					}
					}
				}
				else
				{
					for(int i=0;i<mw.table.getRowCount();i++)
					{
					for (int row=0;row<mw.table.getRowCount()-1;row++)
					{
						String name1=String.valueOf(mw.table.getValueAt(row, 1));
						String name2=String.valueOf(mw.table.getValueAt(row+1, 1));
						if (name1.compareToIgnoreCase(name2)>0)
						{
							mw.model.moveRow(row, row, row+1);
						}
					}
					}	
				}
				mw.mouseflag=!mw.mouseflag;
			}
			else if(mw.table.columnAtPoint(e.getPoint())==2)
			{
				if (!mw.mouseflag)
				{
					for(int i=0;i<mw.table.getRowCount();i++)
					{
						for (int row=0;row<mw.table.getRowCount()-1;row++)
						{
							int sex1=(mw.table.getValueAt(row, 2)).equals("Ů")?0:1;
							int sex2=(mw.table.getValueAt(row+1, 2)).equals("Ů")?0:1;
							if (sex1<sex2)
							{
								mw.model.moveRow(row, row, row+1);
							}
						}
					}
				}
				else
				{
					for(int i=0;i<mw.table.getRowCount();i++)
					{
						for (int row=0;row<mw.table.getRowCount()-1;row++)
						{
							int sex1=(mw.table.getValueAt(row, 2)).equals("Ů")?0:1;
							int sex2=(mw.table.getValueAt(row+1, 2)).equals("Ů")?0:1;
							if (sex1>sex2)
							{
								mw.model.moveRow(row, row, row+1);
							}
						}
					}	
				}
				mw.mouseflag=!mw.mouseflag;
			}
			else if(mw.table.columnAtPoint(e.getPoint())==3)
			{
				if (!mw.mouseflag)
				{
					for(int i=0;i<mw.table.getRowCount();i++)
					{
					for (int row=0;row<mw.table.getRowCount()-1;row++)
					{
						String department1=String.valueOf(mw.table.getValueAt(row, 3));
						String department2=String.valueOf(mw.table.getValueAt(row+1, 3));
						if (department1.compareTo(department2)<0)
						{
							mw.model.moveRow(row, row, row+1);
						}
					}
					}
				}
				else
				{
					for(int i=0;i<mw.table.getRowCount();i++)
					{
					for (int row=0;row<mw.table.getRowCount()-1;row++)
					{
						String department1=String.valueOf(mw.table.getValueAt(row, 3));
						String department2=String.valueOf(mw.table.getValueAt(row+1, 3));
						if (department1.compareTo(department2)>0)
						{
							mw.model.moveRow(row, row, row+1);
						}
					}
					}	
				}
				mw.mouseflag=!mw.mouseflag;
			}
			if(mw.table.columnAtPoint(e.getPoint())==4)
			{
			if (!mw.mouseflag)
			{
				for(int i=0;i<mw.table.getRowCount();i++)
				{
				for (int row=0;row<mw.table.getRowCount()-1;row++)
				{
					int salary1=Integer.parseInt(String.valueOf(mw.table.getValueAt(row, 4)));
					int salary2=Integer.parseInt(String.valueOf(mw.table.getValueAt(row+1, 4)));
					if (salary1<salary2)
					{
						mw.model.moveRow(row, row, row+1);
					}
				}
				}
			}
			else
			{
				for(int i=0;i<mw.table.getRowCount();i++)
				{
				for (int row=0;row<mw.table.getRowCount()-1;row++)
				{
					int salary1=Integer.parseInt(String.valueOf(mw.table.getValueAt(row, 4)));
					int salary2=Integer.parseInt(String.valueOf(mw.table.getValueAt(row+1, 4)));
					if (salary1>salary2)
					{
						mw.model.moveRow(row, row, row+1);
					}
				}
				}	
			}
			mw.mouseflag=!mw.mouseflag;
			}
		}
	}

}
