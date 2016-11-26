package br.quixada.ufc.ws.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.quixada.ufc.ws.dao.IUsuarioDAOImpl;
import br.quixada.ufc.ws.model.Usuario;

@Path("/usuario")
public class UsuarioController {

	private IUsuarioDAOImpl uDAO = new IUsuarioDAOImpl();
	
	@POST
	@Path("/cadastrar")
	@Consumes("application/json") 
	public Response cadastrar(Usuario usuario) {
		return uDAO.cadastrar(usuario);
	}
	
	@PUT
	@Path("/alterar")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response alterar(Usuario usuario) {
		return uDAO.alterar(usuario);
	}
	
	@DELETE
	@Path("/excluir/{idUsuario}")
	public Response excluir(@PathParam("idUsuario") Long idUsuario) {
		System.out.println("Entrou Aqui");
		return uDAO.excluir(idUsuario);
	}
	
	@GET
	@Path("/recuperar/{idUsuario}")
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario recuperar(@PathParam("idUsuario") Long idUsuario) {
		return uDAO.recuperar(idUsuario);
	}
	
	@GET
	@Path("/buscar/{email}")
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario buscar(@PathParam("email") String email) {
		return uDAO.buscar(email);
	}
	
	@GET
	@Path("/listar")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Usuario> listar() {
		return uDAO.listar();
	}
}
