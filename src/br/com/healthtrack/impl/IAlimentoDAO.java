package br.com.healthtrack.impl;

import java.util.List;
import br.com.healthtrack.bean.AlimentoBean;
import br.com.healthtrack.exception.DBException;

public interface IAlimentoDAO {

	  void cadastrar(AlimentoBean alimento) throws DBException;
	  void atualizar(AlimentoBean alimento) throws DBException;
	  void remover(int codigo) throws DBException;
	  AlimentoBean buscar(int id);
	  List<AlimentoBean> listar(int codigoUsuario);
	
}
