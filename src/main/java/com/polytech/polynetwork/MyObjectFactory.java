package com.polytech.polynetwork;


import com.polytech.polynetwork.StoryRepository;
import com.polytech.polynetwork.application.PublicationService;
import com.polytech.polynetwork.application.PublicationServiceImpl;
import com.polytech.polynetwork.data.InMemoryStoryRepository;

import java.util.HashMap;
import java.util.Map;

public class MyObjectFactory {

    private Map<Class,Object> map = new HashMap<Class,Object>();

    public MyObjectFactory(){
        InMemoryStoryRepository storyRepository = new InMemoryStoryRepository();
        map.put(StoryRepository.class, storyRepository);
        map.put(PublicationService.class, new PublicationServiceImpl(storyRepository));
    }

    public <T> T getByType(Class clazz) {
        return (T)map.get(clazz);
    }


}
