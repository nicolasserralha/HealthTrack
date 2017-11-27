package br.com.healthtrack.impl;
import java.util.List;
import br.com.healthtrack.bean.PesoBean;
import br.com.healthtrack.exception.DBException;

public interface IPesoDAO {

	  void cadastrar(PesoBean peso) throws DBException;
	  void atualizar(PesoBean peso) throws DBException;
	  void remover(int codigo) throws DBException;
	  PesoBean buscar(int id);
	  List<PesoBean> listar(int codigoUsuario);
	}
