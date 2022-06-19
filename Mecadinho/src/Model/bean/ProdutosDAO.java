package Model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutosDAO extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Produto> dados = new ArrayList<>();
	private String[] colunas= {"Descrição","Qtde","Valor"};
		
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// TODO Auto-generated method stub
		switch (coluna) {
		case 0: 
			return dados.get(linha).getDescricao();
		case 1: 
			return dados.get(linha).getQtde();
		case 2: 
			return dados.get(linha).getValor();
		}
		return null;
	}
	
	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		// TODO Auto-generated method stub
		switch (coluna) {
		case 0: 
			dados.get(linha).setDescricao((String) valor);
			break;
		case 1: 
			dados.get(linha).setQtde(Integer.parseInt((String) valor));
			break;
		case 2: 
			dados.get(linha).setValor(Double.parseDouble((String) valor));
			break;
		}
		
		this.fireTableRowsUpdated(linha, linha);
	}
	
	public void addRows(Produto p) {
		this.dados.add(p);
		this.fireTableDataChanged();
	}
	
	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
	
	
}
