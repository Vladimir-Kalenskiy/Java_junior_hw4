package homework4.program;

import homework4.model.Courses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Courses.class)
                .buildSessionFactory();

        // Создание сессии
        Session session = sessionFactory.getCurrentSession();

        try {
            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Courses course = new Courses("Информатика", 250);

            // Сохранение объекта в базе данных
            session.save(course);
            System.out.println("Object course save successfully");

//            // Чтение объекта из базы данных
//            Courses retrievedCourse = new Courses();
//            retrievedCourse = session.get(Courses.class, course.getId());
//            System.out.println("Object student retrieved successfully");
//            System.out.println("Retrieved student object: " + retrievedCourse);
//
//            // Обновление объекта
//            retrievedCourse.updateTitle("Литература");
//            retrievedCourse.updateDuration(300);
//            session.update(retrievedCourse);
//            System.out.println("Object student update successfully");

            // Удаление объекта
            //session.delete(retrievedСourse);
            //System.out.println("Object student delete successfully");

            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        } finally {
            sessionFactory.close();
        }
    }
}
