package systems.singularity.buildware.interfaces;

import java.sql.SQLException;
import java.util.Set;

public interface Repository<E, K> {
    E get(K k) throws SQLException;

    Set<E> getAll() throws SQLException;

    boolean exists(K k) throws SQLException;

    K insert(E e) throws SQLException;

    void update(E e) throws SQLException;

    void remove(K k) throws SQLException;
}
