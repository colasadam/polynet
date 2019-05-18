package com.polytech.polynetwork.api;

import com.polytech.polynetwork.application.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryControl {


    @Autowired
    PublicationService publicationService;

    @Autowired
    FeedService feedService;

    @Autowired
    RegisterService registerService;

    @PostMapping("/story")
    public List<Story> share(@RequestBody String content) {
        publicationService.share(new Story(content));
        System.out.println("test story");
        return feedService.fetchAll();

    }

    @PostMapping("/com/{id_story}")
    public List<Story> share_com(@PathVariable("id_story") int id, @RequestBody String s) {
        Commentaire comment =new Commentaire();
        comment.setCom(s);
        publicationService.share_com(id,comment);
        return feedService.fetchAll();

    }

    @GetMapping("/feed")
    public List<Story> feed() {
        return feedService.fetchAll();
    }

    @GetMapping("/toto")
    public void toto(@RequestParam("param1") Long param1, @RequestParam("param2") String param2) {
        System.out.println("");
    }

    @PostMapping("/delete")
    public List<Story> delete_story(@RequestBody int id) {
        publicationService.delete_story(id);
        return feedService.fetchAll();
    }

    @PostMapping("/test_users")
    public void user(@RequestBody User user) {
        user.setEnabled(1);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        System.out.println(user.toString());
        System.out.println("chemin user");
        registerService.insert_user(user);
        Authority authority =new Authority(user.getUsername(),"user");
        registerService.insert_authority(authority);


    }

}

