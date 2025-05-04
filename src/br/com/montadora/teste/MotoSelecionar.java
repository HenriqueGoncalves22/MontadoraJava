package br.com.montadora.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.MotoDAO;
import br.com.montadora.model.Moto;

public class MotoSelecionar {

	public static void main(String[] args) {
        Connection con = Conexao.abrirConexao();
        MotoDAO motodao = new MotoDAO(con);
		
		ArrayList<Moto> lista = motodao.retornarDados();
		
		if(lista != null) {
			for(Moto moto: lista) {
				System.out.println("Montadora: " + moto.getMontadora() + " | " +
			      "Nome: " + moto.getNome() + " | " + "Quantidade de Adesivos: " + 
			      moto.getQuantidadeAdesivos() );
			}
		}
			

	}

}
