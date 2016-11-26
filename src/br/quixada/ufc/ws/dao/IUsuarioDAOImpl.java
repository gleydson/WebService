package br.quixada.ufc.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import br.quixada.ufc.ws.factory.FactoryEntityManager;
import br.quixada.ufc.ws.model.Usuario;

public class IUsuarioDAOImpl implements IUsuarioDAO {
	
	private FactoryEntityManager fem = new FactoryEntityManager();
	private EntityManager manager;
	
	@Override
	public Response cadastrar(Usuario usuario) {
		
		if(usuario != null) {
			manager = fem.getManager();
					
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
					
			manager.close();
					
			return Response.status(200).entity("Usuário Cadastrado com Sucesso").build();
		}
		
		return Response.status(500).build();
	}

	@Override
	public Response alterar(Usuario usuario) {
		
		if(usuario != null) {
			manager = fem.getManager();
				
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
				
			manager.close();
				
			return Response.status(200).entity("Usuário Alterado com Sucesso").build();
		}
		
		return Response.status(500).build();
	}
	
	@Override
	@SuppressWarnings("unused")
	public Response excluir(Long idUsuario) {
		
		manager = fem.getManager();
			
		Usuario usuario = manager.find(Usuario.class, idUsuario);
		
		System.out.println(usuario.getNome());
		
		if(usuario != null) {
			manager.getTransaction().begin();
			manager.remove(usuario);
			manager.getTransaction().commit();
				
			manager.close();
				
			return Response.status(200).entity("Usuário Removido com Sucesso").build();
		}
		
		return Response.status(500).build();
	}

	@Override
	public Usuario recuperar(Long idUsuario) {
		
		manager = fem.getManager();
			
		Usuario usuario = manager.find(Usuario.class, idUsuario);
			
		manager.close();
			
		if(usuario != null) {
			return usuario;
		}
		
		return usuario;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Usuario buscar(String email) {
		
		String hql = "SELECT u FROM usuario AS u WHERE email = :param_email";
		
		manager = fem.getManager();
			
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = query.setParameter("param_email", email).getResultList();
			
		if(usuarios.size() != 0) {
			return usuarios.get(0);
		}
		
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		
		String hql = "SELECT u FROM usuario AS u";
		manager = fem.getManager();
			
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = query.getResultList();
			
		if(usuarios.size() != 0) {
			return usuarios;
		}
		
		return usuarios;
	}

}
