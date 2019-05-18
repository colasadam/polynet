package com.polytech.polynetwork;


import com.polytech.polynetwork.application.Authority;
import com.polytech.polynetwork.application.Commentaire;
import com.polytech.polynetwork.application.Story;
import com.polytech.polynetwork.application.User;

import java.util.List;

public interface StoryRepository {
    List<Story> findAll();

    void save(Story story);

    void save_com(Commentaire commentaire);

    void delete_story(int id);

    Story findOne(int id);

    void save_user(User user);

    void save_authority(Authority authority);
}
