package app.DAO;

import java.util.List;

public interface IDAO<T, ID> {
    T create(T entity);
    List<T> getAll();
    void update(T entity);
    void remove(ID id);
}
