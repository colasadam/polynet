package com.polytech.polynetwork.data;


import com.polytech.polynetwork.StoryRepository;
import com.polytech.polynetwork.application.Authority;
import com.polytech.polynetwork.application.Commentaire;
import com.polytech.polynetwork.application.Story;
import com.polytech.polynetwork.application.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStoryRepository implements StoryRepository {
    private List<Story> stories = new ArrayList<Story>();

    public List<Story> findAll() {
        return stories;
    }

    public void save(Story story) {
        stories.add(story);
    }

    @Override
    public void save_com(Commentaire commentaire) {

    }

    @Override
    public void delete_story(int id) {

    }

    @Override
    public Story findOne(int id) {
        return null;
    }

    @Override
    public void save_user(User user) {

    }

    @Override
    public void save_authority(Authority authority) {

    }
}
