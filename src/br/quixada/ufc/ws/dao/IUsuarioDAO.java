package br.quixada.ufc.ws.dao;

import java.util.List;

import javax.ws.rs.core.Response;

import br.quixada.ufc.ws.model.Usuario;

public interface IUsuarioDAO {
	
	public Response cadastrar(Usuario usuario);
	public Response alterar(Usuario usuario);
	public Response excluir(Long idUsuario);
	public Usuario recuperar(Long idUsuario);
	public Usuario buscar(String email);
	public List<Usuario> listar();
	
}
