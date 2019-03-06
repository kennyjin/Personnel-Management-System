package model;


import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class JTable1 extends JTable 
{

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public JTable1(TableModel dm) {
		super(dm);
	}



}
