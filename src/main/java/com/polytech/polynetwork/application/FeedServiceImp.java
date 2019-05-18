package com.polytech.polynetwork.application;

import com.polytech.polynetwork.StoryRepository;

import java.util.List;

public class FeedServiceImp implements FeedService {

    private StoryRepository storyRepository;

    public FeedServiceImp (StoryRepository Sr) {
        storyRepository =Sr;
    }

    public List fetchAll() {
        return storyRepository.findAll();
    }
}
