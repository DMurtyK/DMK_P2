package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public PostService(){
        System.out.println("******* POST Service*************");
    }

    public List<Post> getAllPosts(){


         return repository.getAllPosts();

    }

    public Post getOnePost() {
        ArrayList<Post> posts = new ArrayList<>();
/*
        //   Post post1 = new Post();
        //  post1.setTitle("This is your Post");
        // post1.setBody("This is your Post. It has some valid content");
        //  post1.setDate(new Date());
        // posts.add(post1);
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog", "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts where id = 4");
            while (rs.next()) {
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
*/
        return repository.getLatestPost();

    }

    public void createPost (Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Posts"+newPost);
    }
    public Post getPost(Integer postId) {
        return repository.getPost(postId);
    }
    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }
    public void deletePost(Integer postId) {
        repository.deletePost(postId);
    }
}
