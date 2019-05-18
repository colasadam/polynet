package com.polytech.polynetwork.data;

import com.polytech.polynetwork.StoryRepository;
import com.polytech.polynetwork.application.Authority;
import com.polytech.polynetwork.application.Commentaire;
import com.polytech.polynetwork.application.Story;
import com.polytech.polynetwork.application.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcStoryRepository implements StoryRepository {

    private DataSource dataSource;

    public JdbcStoryRepository(DataSource dataSource){
        this.dataSource =dataSource;
    }

    public List<Story> findAll() {
        List<Story> results = new ArrayList();
        try{
            Connection connection = dataSource.getConnection();
            String sql = "Select * FROM Story";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while(resultSet.next()){
                String content = resultSet.getString( "content");
                int id =resultSet.getInt("id");
                List<Commentaire> commentaires = coms(id);
                Story story = new Story(id,content,commentaires);
                results.add(story);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return results;
    }

    public void save(Story story) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("INSERT INTO Story(content) VALUES(?) ");
            sql.setString(1,story.getContent());
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save_com(Commentaire commentaire) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("INSERT INTO Commentaire(id_story,com) VALUES(?,?) ");
            //sql.setInt(1,commentaire.getID_story());
            sql.setString(2,commentaire.getCom());
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


    public List<Commentaire> coms(int id_story) {
        List<Commentaire> results = new ArrayList();
        try{
            Connection connection = dataSource.getConnection();
            String sql = "Select * FROM Commentaire where id_story="+id_story;
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while(resultSet.next()){
                String content = resultSet.getString( "com");
                    int id =resultSet.getInt("id");
                //Commentaire commentaire = new Commentaire(id,id_story,content);
                //results.add(commentaire);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return results;
    }
}
