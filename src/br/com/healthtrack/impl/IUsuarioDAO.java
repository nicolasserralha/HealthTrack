package br.com.healthtrack.impl;
import java.util.List;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.bean.UsuarioBean;

public interface IUsuarioDAO {
	//não precisa colocar public, porque na interface, por padrão, todos são public
	  void cadastrar(UsuarioBean usuario) throws DBException;
	  void atualizar(UsuarioBean usuario) throws DBException;
	  void remover(int codigo) throws DBException;
	  UsuarioBean buscar(int id);
	  List<UsuarioBean> listar();
	  UsuarioBean validarUsuario(UsuarioBean usuario) throws DBException;
	  void desativarUsuario(UsuarioBean usuario) throws DBException;
	}
