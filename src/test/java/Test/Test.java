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
        //crearEstudiante();
        //recuperarPorId();
        //actualizarEstudiante();
        eliminarEstudiante();
    }
    
    private static void crearEstudiante(){        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpaLocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Estudiante est = new Estudiante(6,"FR896547", "Daniel","Fernández");
        em.persist(est);
        tx.commit();
        System.out.println("#### NUEVO REGISTRO INGRESADO ####");
        System.out.println("ID: " + est.getId());
        System.out.println("Carnet: " + est.getCarnet());
        System.out.println("Nombres: " + est.getNombres());
        System.out.println("Apellidos: " + est.getApellidos());
        em.close();
    }
    
    private static void recuperarPorId(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpaLocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Estudiante est = em.find(Estudiante.class, 7);
        tx.commit();
        if (est != null) {
        System.out.println("####REGISTRO ENCONTRADO####");
        System.out.println("ID: " + est.getId());
        System.out.println("Carnet: " + est.getCarnet());
        System.out.println("Nombres: " + est.getNombres());
        System.out.println("Apellidos: " + est.getApellidos());
    } else {
        System.out.println("No se encontró ningún estudiante con ese ID");
    }
        em.close();
    }
    
    private static void actualizarEstudiante(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpaLocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //INICIA TRANSFERENCIA
        
        Estudiante est = em.find(Estudiante.class, 4);
        tx.commit();//FINALIZA TRANSFERENCIA        
        System.out.println("####REGISTRO ENCONTRADO ####");
        System.out.println("ID: " + est.getId());
        System.out.println("Carnet: " + est.getCarnet());
        System.out.println("Nombres: " + est.getNombres());
        System.out.println("Apellidos: " + est.getApellidos());
        
        est.setNombres("MaRIANA"); //MODIFICAMOS EL VALOR
        EntityTransaction tx2 = em.getTransaction(); //NUEVA TRANSACTION
        tx2.begin();// LA EMPEZAMOS
        
        em.merge(est);// ELIMINAMOS EL REGISTRO ANTERIOR
        tx2.commit();
        System.out.println("####REGISTRO ACTUALIZADO ####");
        System.out.println("ID: " + est.getId());
        System.out.println("Carnet: " + est.getCarnet());
        System.out.println("Nombres: " + est.getNombres());
        System.out.println("Apellidos: " + est.getApellidos());
        em.close();
        
    }
    
    private static void eliminarEstudiante(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpaLocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Estudiante est = em.find(Estudiante.class, 7);
        tx.commit();     
        System.out.println("####REGISTRO ENCONTRADO ####");
        System.out.println("Nombres: " + est.getNombres());
        System.out.println("Apellidos: " + est.getApellidos());
        
        EntityTransaction tx2 = em.getTransaction(); 
        tx2.begin();
        
        em.remove(em.merge(est));
        tx2.commit();
        System.out.println("####REGISTRO ELIMINADO ####");
        em.close();

    }
}
