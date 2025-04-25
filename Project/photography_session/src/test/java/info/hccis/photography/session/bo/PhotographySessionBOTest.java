package info.hccis.photography.session.bo;

import info.hccis.photography.session.jpa.entity.PhotographySession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhotographySessionBOTest {

    @Test
    void calculateCost_basicPackage_WITH_PHOTO_ALBUM() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(1);
        photographySession.setAddedPhotoAlbum(true);
        double actual = PhotographySessionBO.calculatePhotographySessionCost(photographySession);
        Assertions.assertEquals(200, actual);
    }

    @Test
    void calculateCost_premiumPackage_WITH_VIDEO_AND_100_EXTRA_PRINTS() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(3);
        photographySession.setAddedVideo(true);
        photographySession.setAddedExtraPrints(true);
        photographySession.setNumberOfExtraPrints(100);
        double actual = PhotographySessionBO.calculatePhotographySessionCost(photographySession);
        Assertions.assertEquals(1400, actual);
    }
}