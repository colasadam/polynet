package com.polytech.polynetwork.data;

import com.polytech.polynetwork.StoryRepository;
import com.polytech.polynetwork.application.Authority;
import com.polytech.polynetwork.application.Commentaire;
import com.polytech.polynetwork.application.Story;
import com.polytech.polynetwork.application.User;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.EntityManager;
import javax.persistence.JoinTable;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class JpaStoryRepository implements StoryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Story> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Story s");
        return query.getResultList();
    }

    @Override
    public void save(Story story) {
        entityManager.persist(story);
    }

    @Override
    public void save_com(Commentaire commentaire) {
        entityManager.persist(commentaire);
    }

    @Override
    public void delete_story(int id) {
        Story story = entityManager.find(Story.class,id);
        entityManager.remove(story);
    }

    @Override
    public Story findOne(int id) {
        return entityManager.find(Story.class,id);
    }

    @Override
    public void save_user(User user) {
        user.toString();
        entityManager.persist(user);
    }

    @Override
    public void save_authority(Authority authority) {
        entityManager.persist(authority);
    }


}
