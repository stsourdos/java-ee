package com.tsourdos.javaee7restfulapi.rest;

import com.tsourdos.javaee7restfulapi.exceptions.WebApplicationException;
import com.tsourdos.javaee7restfulapi.model.SuperUser;
import com.tsourdos.javaee7restfulapi.repo.UserRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author s.tsourdos
 */
@Stateless
@Path("/user")
public class UserRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestService.class);

    @Inject
    UserRepository userRepository;

    public UserRestService() {}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SuperUser> getAllSuperUsers() {
        return userRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SuperUser getSuperUser(@PathParam("id") int id) {
        SuperUser superUser;
        try {
            superUser = userRepository.find(id);
        } catch (NoResultException ex) {
            LOGGER.warn("User with id ({}) could not be found", id);
            throw new WebApplicationException("User could not be found", Response.Status.NOT_FOUND, 4325, ex);
        }

        return superUser;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveSuperUser(SuperUser superUser) {
        userRepository.save(superUser);
    }

    @DELETE
    @Path("/{id}")
    public void deleteSuperUser(@PathParam("id") int id) {
        userRepository.delete(getSuperUser(id));
    }

}
