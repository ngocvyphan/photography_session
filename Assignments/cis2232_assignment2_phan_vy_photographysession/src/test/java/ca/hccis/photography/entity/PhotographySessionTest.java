package ca.hccis.photography.entity;

import ca.hccis.photography.exception.PhotographySessionException;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PhotographySessionTest {

    @org.junit.jupiter.api.Test
    void testCalculateCost_basicPackage() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(1);
        double actual = photographySession.calculateCost();
        Assertions.assertEquals(150, actual);
    }

    @org.junit.jupiter.api.Test
    void testCalculateCost_customPackage() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(5);
        photographySession.setNumberOfHoursBooked(5);
        double actual = photographySession.calculateCost();
        Assertions.assertTrue(actual == 750);
    }

    @org.junit.jupiter.api.Test
    void testCalculateCost_customPackage_WITH_10_EXTRA_PRINTS() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(5);
        photographySession.setNumberOfHoursBooked(3);
        photographySession.setAddedExtraPrints(true);
        photographySession.setNumberOfExtraPrints(10);
        double actual = photographySession.calculateCost();
        Assertions.assertTrue(actual == 480);
    }

    @org.junit.jupiter.api.Test
    void testCalculateCost_standardPackage() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(2);
        double actual = photographySession.calculateCost();
        Assertions.assertTrue(actual == 300);
    }

    @org.junit.jupiter.api.Test
    void testCalculateCost_basicPackage_WITH_PHOTO_ALBUM() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(1);
        photographySession.setAddedPhotoAlbum(true);
        double actual = photographySession.calculateCost();
        Assertions.assertEquals(200, actual);
    }

    @org.junit.jupiter.api.Test
    void testCalculateCost_basicPackage_WITH_PHOTO_ALBUM_AND_5_EXTRA_PRINTS() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(1);
        photographySession.setAddedPhotoAlbum(true);
        photographySession.setAddedExtraPrints(true);
        photographySession.setNumberOfExtraPrints(5);
        double actual = photographySession.calculateCost();
        Assertions.assertEquals(215, actual);
    }

    @org.junit.jupiter.api.Test
    void testCalculateCost_eventPackage_WITH_PHOTO_ALBUM_AND_EXTRA_EDITING() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(4);
        photographySession.setAddedPhotoAlbum(true);
        photographySession.setAddedExtraEditing(true);
        double actual = photographySession.calculateCost();
        Assertions.assertEquals(1350, actual);
    }

    @org.junit.jupiter.api.Test
    void testCalculateCost_premiumPackage_WITH_VIDEO_AND_100_EXTRA_PRINTS() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.setPackageNumber(3);
        photographySession.setAddedVideo(true);
        photographySession.setAddedExtraPrints(true);
        photographySession.setNumberOfExtraPrints(100);
        double actual = photographySession.calculateCost();
        Assertions.assertEquals(1400, actual);
    }

    @org.junit.jupiter.api.Test
    void testCalculateCost_packageNumber_Equals_6() {
        assertThrows(PhotographySessionException.class, ()->{
            PhotographySession photographySession = new PhotographySession();
            photographySession.setPackageNumber(6);
                }
        );
    }

    @org.junit.jupiter.api.Test
    void testCalculateCost_customPackage_With_NumberOfHoursBooked_Exceeds_10() {
        assertThrows(PhotographySessionException.class, ()->{
                    PhotographySession photographySession = new PhotographySession();
                    photographySession.setPackageNumber(5);
                    photographySession.setNumberOfHoursBooked(16);
                }
        );
    }


}