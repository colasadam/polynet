package com.polytech.polynetwork.application;

import com.polytech.polynetwork.StoryRepository;

public class RegisterServiceImp implements RegisterService {
    private StoryRepository storyRepository;

    public RegisterServiceImp(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override

    public void insert_user(User user) {
        storyRepository.save_user(user);
    }

    public void insert_authority(Authority authority){storyRepository.save_authority(authority);}
}
