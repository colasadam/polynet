package com.polytech.polynetwork.application;

import com.polytech.polynetwork.StoryRepository;

import javax.transaction.Transactional;


public class PublicationServiceImpl implements PublicationService {

    private StoryRepository storyRepository;

    public PublicationServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void share(Story story) {
        storyRepository.save(story);
    }


    @Override
    @Transactional
    public void share_com(int id,Commentaire commentaire) {
        Story story = storyRepository.findOne(id);
        story.addComments(commentaire);
        storyRepository.save(story);
    }

    @Override
    public void delete_story(int id) {
        storyRepository.delete_story(id);
    }
}

