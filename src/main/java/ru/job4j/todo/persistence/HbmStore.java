package ru.job4j.todo.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.todo.model.Item;

import java.util.List;

public class HbmStore implements Store, AutoCloseable {

    private static final class Lazy {
        private static final HbmStore INST = new HbmStore();
    }

    public static HbmStore instOf() {
        return HbmStore.Lazy.INST;
    }

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();


    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public void update(int id, boolean done) {
        Session session = sf.openSession();
        session.beginTransaction();
        String hql = "update ru.job4j.todo.model.Item i set i.done= :done where i.id = :id";
        Query hqlQuery = session.createQuery(hql);
        hqlQuery.setParameter("done", !done);
        hqlQuery.setParameter("id", id);
        hqlQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.todo.model.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
