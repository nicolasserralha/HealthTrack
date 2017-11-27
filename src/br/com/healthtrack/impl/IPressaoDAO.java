package br.com.healthtrack.impl;

import java.util.List;
import br.com.healthtrack.bean.PressaoBean;
import br.com.healthtrack.exception.DBException;

public interface IPressaoDAO {

	  void cadastrar(PressaoBean pressao) throws DBException;
	  void atualizar(PressaoBean pressao) throws DBException;
	  void remover(int codigo) throws DBException;
	  PressaoBean buscar(int id);
	  List<PressaoBean> listar(int codigoUsuario);
	
}
