package co.mz.teste.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
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

import co.mz.teste.dao.FaturaDao;
import co.mz.teste.model.Fatura;
import co.mz.teste.model.Servico;
import co.mz.teste.model.TipoDoc;

@Stateless
@Path("fatura")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FaturaController {
	public FaturaController() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Fatura> listChamados() {
		try {
			FaturaDao chamadoBus = new FaturaDao();
			return chamadoBus.listar();

		} catch (Exception ex) {
			Logger.getLogger(FaturaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tipo")
	public List<TipoDoc> listene() {
		try {
			FaturaDao chamadoBus = new FaturaDao();
			return chamadoBus.listene();

		} catch (Exception ex) {
			Logger.getLogger(FaturaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/servico")
	public List<Servico> listera() {
		try {
			FaturaDao chamadoBus = new FaturaDao();
			return chamadoBus.listarSer();

		} catch (Exception ex) {
			Logger.getLogger(FaturaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Fatura getChamado(@PathParam("id") long id) {
		try {
			FaturaDao chamadoBus = new FaturaDao();
			return chamadoBus.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(FaturaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/")
	 public Response create(Fatura chamado) {
	 try {
	 FaturaDao chamadoBus = new FaturaDao();
	 chamadoBus.inserir(chamado);
	 return Response.status(Response.Status.OK).build();
	 } catch (Exception ex) {
	 Logger.getLogger(FaturaController.class.getName()).log(Level.SEVERE,
	 null, ex);
	 throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
	 }
	 }

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Fatura chamado) {
		try {

			FaturaDao chamadoBus = new FaturaDao();
			chamadoBus.alterar(chamado);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(FaturaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long id) {
		try {
			FaturaDao chamadoBus = new FaturaDao();
			chamadoBus.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(FaturaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Path("{id}/")
	public Response concluir(@PathParam("id") long id) {
		try {
			FaturaDao chamadoBus = new FaturaDao();

			Fatura c = chamadoBus.selecionar(id);

			chamadoBus.alterar(c);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(FaturaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
