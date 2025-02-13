package app.DAO;

import java.util.List;

public interface IDAO<T, I> {
    T create(T t);
    List<T> getAll();
    T update(T t);
    void remove(I i);
}
