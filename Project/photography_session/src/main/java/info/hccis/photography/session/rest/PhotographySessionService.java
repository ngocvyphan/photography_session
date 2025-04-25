package info.hccis.photography.session.rest;

import info.hccis.photography.session.bo.PhotographySessionBO;
import info.hccis.photography.session.exception.AllAttributesNeededException;
import com.google.gson.Gson;
import info.hccis.photography.session.jpa.entity.PhotographySession;
import info.hccis.photography.session.jpa.entity.TicketOrder;
import info.hccis.photography.session.repositories.PhotographySessionRepository;
import info.hccis.photography.session.util.CisUtility;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Photography Session Service class for accessing using REST.
 *
 * @author Vy Phan
 * @since 20241115
 */
@Path("/PhotographySessionService/photographySessions")
public class PhotographySessionService
{
    private final PhotographySessionRepository _psr;
    
    @Autowired
    public PhotographySessionService(PhotographySessionRepository psr){
        this._psr = psr;
    }
    
    /**
     * Method to get all.
     * 
     * @author Vy Phan
     * @since 20241115
     * @return photography sessions
     */
    @GET
    @Produces("application/json")
    public Response getAll()
    {
        ArrayList<PhotographySession> photographySessions = (ArrayList<PhotographySession>) _psr.findAll();
        if (photographySessions == null || photographySessions.isEmpty()) {
            return Response.status(204).build();
        } else {
            return Response
                    .status(200)
                    .entity(photographySessions).build();
        }
    }
    
    /**
     * Method to get by their id using REST.
     * 
     * @author 2250
     * @since 20220201
     * @return response
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getPhotographySessionById(@PathParam("id") Integer id) throws URISyntaxException
    {
        Optional<PhotographySession> photographySession = _psr.findById(id);
         if (!photographySession.isPresent()) {
            return Response.status(204).build();
        } else {
            return Response
                    .status(200)
                    .entity(photographySession).build();
        }
    }
    
    /**
     * Method to create using REST.
     * 
     * @author 2250
     * @since 20201116
     * @return response
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String inJson)
    {
        try{
            String temp = save(inJson);
            return Response.status(HttpURLConnection.HTTP_OK).entity(temp).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();        
        }catch(AllAttributesNeededException aane){
            System.out.println("AANE Exception happened adding photography session.");
            //https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses
            return Response.status(HttpURLConnection.HTTP_NOT_ACCEPTABLE).entity(aane.getMessage()).build();
        }catch(Exception e){
            System.out.println("Exception happened adding photography session.");
            //https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses
            
            return Response.status(HttpURLConnection.HTTP_NOT_ACCEPTABLE).entity(e.getMessage()).build();
        }
    }

    /**
     * Method to update a photography session using REST.
     *
     * @author PAAG
     * @since 20201116
     * @return response
     */
//    @PUT
//    @Path("/{id}")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response updatePhotographySession(@javax.ws.rs.PathParam("id") int id, String photographySessionJson) throws URISyntaxException
//    {
//
//        try{
//            String temp = save(photographySessionJson);
//            return Response.status(201).entity(temp).header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
//        }catch(AllAttributesNeededException aane){
//            return Response.status(400).entity(aane.getMessage()).build();
//        }
//
//    }

    /**
     * Method to make sure all required inputs are present.
     * 
     * @author 2250
     * @since 20220201
     * @return string
     */
    public String save(String json) throws AllAttributesNeededException{
        
        Gson gson = new Gson();
        PhotographySession photographySession = gson.fromJson(json, PhotographySession.class);

        if(photographySession.getId() == null){
            photographySession.setId(0);
        }
        PhotographySessionBO.calculatePhotographySessionCost(photographySession);
        photographySession = _psr.save(photographySession);

        String temp = "";
        temp = gson.toJson(photographySession);

        return temp;
        
        
    }

    /**
     * Method to delete a photography session by its ID using REST.
     *
     * @author Vy Phan
     * @since 20241202
     * @param id ID of the photography session to delete
     * @return Response indicating success or failure
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePhotographySessionById(@PathParam("id") Integer id) {
        Optional<PhotographySession> photographySession = _psr.findById(id);
        if (!photographySession.isPresent()) {
            return Response.status(204).build();
        } else {
            _psr.deleteById(id);
            return Response
                    .status(201)
                    .entity(photographySession).build();
        }
    }
    
}
