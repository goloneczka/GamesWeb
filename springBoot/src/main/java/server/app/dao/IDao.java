package server.app.dao;

import java.util.List;
import java.util.UUID;

public interface IDao<T> {

    public List<T> getAll();

    public List<T> getLatestGames(int amount, int page);

    public T getById(UUID id);

    public void add(T t);

    public void update(T t);

    public void delete(UUID t);

}
