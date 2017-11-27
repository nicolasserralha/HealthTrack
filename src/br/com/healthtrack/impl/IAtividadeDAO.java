package br.com.healthtrack.impl;
import java.util.List;
import br.com.healthtrack.bean.AtividadeBean;
import br.com.healthtrack.exception.DBException;

public interface IAtividadeDAO {

	  void cadastrar(AtividadeBean atividade) throws DBException;
	  void atualizar(AtividadeBean atividade) throws DBException;
	  void remover(int codigo) throws DBException;
	  AtividadeBean buscar(int id);
	  List<AtividadeBean> listar(int codigoUsuario);
	  
	}
