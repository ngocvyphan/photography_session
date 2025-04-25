package info.hccis.photography.session.soap;

import info.hccis.photography.session.dao.PhotographySessionDAO;
import info.hccis.photography.session.jpa.entity.PhotographySession;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "info.hccis.photography.session.soap.PhotographySessionService")
public class PhotographySessionServiceImpl implements PhotographySessionService {

    public PhotographySession getPhotographySession(int id) {

        PhotographySessionDAO photographySessionDAO = new PhotographySessionDAO();
        PhotographySession photographySession = null;
        for (PhotographySession current: getPhotographySessions()){
            if (current.getId().equals(id)){
                photographySession = current;
            }

        }
        return photographySession;

    }

    @Override
    public int getCount() {
        return getPhotographySessions().size();
    }

    @Override
    public List<PhotographySession> getPhotographySessions() {

        PhotographySessionDAO photographySessionDAO = new PhotographySessionDAO();
        ArrayList<PhotographySession> photographySessions = photographySessionDAO.selectAll();
        return photographySessions;


    }

}
