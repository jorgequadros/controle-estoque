package modulo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import control.ConexaoBD;

public class ModeloTabelaConsulta extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Object[]> linhas = new ArrayList<>();
	private String[] colunas;
	private static Statement stmt;
	private String consulta;
	
	public void setConsulta(String consulta) {
		this.consulta=consulta;
	}
	
	public ModeloTabelaConsulta(String consulta) {
		try {
			this.consulta = consulta;
			
			ConexaoBD.getInstance();
			stmt = ConexaoBD.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			loadData();
			
			
			
		} catch (Exception e) {
			System.out.printf("%s[%s]\n", getClass().getSimpleName(), e.toString());
		}
	}
	
	public void loadData() { 
		
		try (ResultSet rs = stmt.executeQuery(consulta);) {
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			colunas = new String[numCols];
			for (int i = 0; i < numCols; i++) {
				colunas[i] = rsmd.getColumnName(i + 1);
			}
			linhas.clear();
			while (rs.next()) {
				Object l[] = new Object[numCols];
				for (int i = 0; i < numCols; i++) {
					l[i] = rs.getObject(i + 1);
				}
				linhas.add(l);
			}
			
			fireTableDataChanged();
			
		} catch (Exception e) {
			System.out.printf("%s[%s]\n", getClass().getSimpleName(), e.toString());
		} // rs.close() implicitos
		
	}
	
	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int lin, int col) {
		try {
			Object l[] = linhas.get(lin);
			return l[col];
		} catch (Exception e) {
			System.out.printf("%s[%s]\n", getClass().getSimpleName(), e.toString());
		}
		return null;
	}
	
	@Override
	public String getColumnName(int col) {
		return colunas[col];
	}

	@Override
	public boolean isCellEditable(int lin, int col) {
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	@Override
	public void setValueAt(Object value, int lin, int col) {
		Object l[] = linhas.get(lin);
		l[col] = value;
		fireTableCellUpdated(lin, col);
	}

}
