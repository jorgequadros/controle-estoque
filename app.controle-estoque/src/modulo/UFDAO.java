package modulo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UFDAO {

	public List<UF> obterFornecedor() throws SQLException{
		List<UF> uf = new ArrayList<UF>();
		
		try {
			ConexaoBD.getInstance();
			Connection con = ConexaoBD.getConexao();
			PreparedStatement stmt = con.prepareStatement("select *  from UF;");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UF U = new UF();
				U.setID(rs.getInt("id"));
				U.setValor(rs.getString("valor"));
				uf.add(U);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return uf;
	}
}
