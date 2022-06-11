package Model.bean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
	private Statement stmt;
	
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
	
	public void obterProdutos() throws SQLException {
		try {
			conection.ConexaoBD.getInstance();
			Connection con = conection.ConexaoBD.getConexao();
			PreparedStatement stmt = con.prepareStatement("select * from produtos;");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			
			colunas = new String[numCols];
			for(int i=0;i<numCols;i++) {colunas[i]=rsmd.getColumnName(i+1);};
			dados.clear();
			
			while(rs.next()) {
				List<Produto> p =new ArrayList<>();
				p.set(0, null).setDescricao((String) rs.getObject(1));
				p.set(1, null).setQtde((Integer) rs.getObject(2));
				p.set(2, null).setValor((Double) rs.getObject(6));
				dados.addAll(p);
			}
			fireTableDataChanged();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
