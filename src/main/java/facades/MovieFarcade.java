package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFarcade {

    private static MovieFarcade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MovieFarcade() {}
    
    
    
    public static MovieFarcade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFarcade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(m) FROM Movie m").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }

public Movie addMovie(int year, String s, String[] a){
        Movie m = new Movie(year,s,a);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            return m;
        }finally {
            em.close();
        }}

    public Movie findMovie(long id){
         EntityManager em = emf.createEntityManager();
        try{
            Movie m = em.find(Movie.class,id);
            return m;
        }finally {
            em.close();
        }}

}
