package info.hccis.photography.session.soap;

import javax.xml.ws.Endpoint;

public class PhotographySessionServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish(
          "http://localhost:8083/photographysessionservice",
           new PhotographySessionServiceImpl());

    }
}