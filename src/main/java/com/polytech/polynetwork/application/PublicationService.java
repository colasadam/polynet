package com.polytech.polynetwork.application;


public interface PublicationService {

    void share(Story story);

    void share_com(int id,Commentaire commentaire);

    void delete_story(int id);
}
