package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.service.ImageService;
import ImageHoster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {


    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public List<Comment> getAllComments() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c", Comment.class);
        List<Comment> resultList = query.getResultList();

        return resultList;
    }


    public List<Comment> getCommentsofanImage(Image imageid) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image_id =:imageid", Comment.class).setParameter("imageid", imageid);;
        List<Comment> resultList = query.getResultList();

        return resultList;
    }




    public Comment createComment(Comment newComment){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
        return  newComment;
    }


    public Comment getComment(Integer commentId) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> typedQuery = em.createQuery("SELECT i from Comment i where i.id =:commentId", Comment.class).setParameter("commentId", commentId);
        Comment comment = typedQuery.getSingleResult();
        return comment;
    }


}
