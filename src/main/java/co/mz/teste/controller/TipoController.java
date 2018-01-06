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

import co.mz.teste.dao.TipoDao;
import co.mz.teste.model.TipoDoc;

@Path("tipo")
public class TipoController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<TipoDoc> listChamados() {
		try {
			TipoDao chamadoBus = new TipoDao();
			return chamadoBus.listar();

		} catch (Exception ex) {
			Logger.getLogger(TipoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public TipoDoc getTipoDoc(@PathParam("id") long id) {
		try {
			TipoDao chamadoBus = new TipoDao();
			return chamadoBus.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(TipoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(TipoDoc chamado) {
		try {
			TipoDao chamadoBus = new TipoDao();
			chamadoBus.inserir(chamado);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(TipoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(TipoDoc chamado) {
		try {

			TipoDao chamadoBus = new TipoDao();
			chamadoBus.alterar(chamado);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(TipoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long id) {
		try {
			TipoDao chamadoBus = new TipoDao();
			chamadoBus.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(TipoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
