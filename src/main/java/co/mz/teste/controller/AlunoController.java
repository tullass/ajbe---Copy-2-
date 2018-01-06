/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mz.teste.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.mz.teste.dao.AlunoDao;
import co.mz.teste.model.Aluno;

@Path("aluno")
public class AlunoController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Aluno> listChamados() {
		try {
			AlunoDao chamadoBus = new AlunoDao();
			return chamadoBus.listar();

		} catch (Exception ex) {
			Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Aluno getAluno(@PathParam("id") long id) {
		try {
			AlunoDao chamadoBus = new AlunoDao();
			return chamadoBus.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Aluno chamado) {
		try {
			AlunoDao chamadoBus = new AlunoDao();
			chamadoBus.inserir(chamado);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Aluno chamado) {
		try {

			AlunoDao chamadoBus = new AlunoDao();
			chamadoBus.alterar(chamado);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long id) {
		try {
			AlunoDao chamadoBus = new AlunoDao();
			chamadoBus.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
