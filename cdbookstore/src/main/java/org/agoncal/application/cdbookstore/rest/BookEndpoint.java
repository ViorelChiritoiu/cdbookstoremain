package org.agoncal.application.cdbookstore.rest;

import org.agoncal.application.cdbookstore.model.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/books")
@Transactional
public class BookEndpoint {

    @Inject
    private EntityManager em;

    @GET
    @Produces({"text/plain"})
    @Path("/paper")
    public String listPaperBooks() {
        return "list paper books";
    }

    @GET
    @Produces({"text/plain"})
    @Path("/paper/old")
    public String listOldPaperBooks() {
        return "list old paper books";
    }

    @POST
    @Consumes({ "application/xml", "application/json"})
    public Response create(Book entity) {
        em.persist(entity);
        return Response.created(UriBuilder.fromResource(BookEndpoint.class)
                .path(String.valueOf(entity.getId())).build()).build();
    }
}
