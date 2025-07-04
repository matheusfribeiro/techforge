package com.techforge.persistance.hibernate;

import com.techforge.models.Category;
import com.techforge.models.Course;
import com.techforge.models.Subcategory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();

        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Course.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Category.class)
            .buildMetadata();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
