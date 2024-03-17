package Test;
import com.mycompany.demojpalocal.Estudiante;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Test {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
        crearEstudiante();
        //recuperarPorId();
    }
    
    private static void crearEstudiante2() {        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpaLocal");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    
    // Utilizar el valor del carnet definido en la clase Estudiante
    Estudiante estudiante = new Estudiante("AB123456", "Anthodany", "Hernández"); // Cambia "AB123456" al valor deseado
    
    em.persist(estudiante);
    tx.commit();
    log.debug("Objeto: " + estudiante);
    em.close();
}

    private static void crearEstudiante(){        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpaLocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Estudiante estudiante = new Estudiante("HG100", "Anthodany","Hernsdadsández");
        em.persist(estudiante);
        tx.commit();
        log.debug("Objeto: " + estudiante);
        em.close();
    }
    
    private static void recuperarPorId(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpaLocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Estudiante est = em.find(Estudiante.class, 3);
        tx.commit();
        System.out.println("Objeto " + est);
        em.close();
    }
    
    private static void actualizarEstudiante(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpaLocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Estudiante est = em.find(Estudiante.class, 3);
        tx.commit();
        System.out.println("Objeto Recuperado" + est);
        
        //est.setNombre("Mateo");
    }
}
