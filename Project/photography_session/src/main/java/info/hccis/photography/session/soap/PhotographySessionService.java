package info.hccis.photography.session.soap;

import info.hccis.photography.session.jpa.entity.PhotographySession;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface PhotographySessionService {
    @WebMethod
    PhotographySession getPhotographySession(int id);
    @WebMethod
    List<PhotographySession> getPhotographySessions();
    @WebMethod
    int getCount();
    
}