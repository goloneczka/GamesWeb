package server.app.service;

import org.springframework.stereotype.Service;
import server.app.dao.Dao;
import server.app.dao.GameDao;
import server.app.dao.GameTagDao;
import server.app.dao.IDao;
import server.app.entity.Game;
import server.app.entity.GameTag;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    private Dao<Game> gameDao;
    private Dao<GameTag> gameTagDao;

    public GameService(GameDao gameDao, GameTagDao gameTagDao) {
        this.gameDao = gameDao;
        this.gameTagDao = gameTagDao;
    }

    public List<Game> getAll() {
        return gameDao.getAll();
    }

    public Game getById(UUID id) {
        return gameDao.getById(id);
    }

    public void add(Game game) {
        game.addId();
        game.getTags().forEach(gameTag -> {
            gameTag.addId();
            gameTag.setGameId(game.getId());
        });

        gameDao.add(game);
        game.getTags().forEach(gameTagDao::add);
    }

    public void update(Game game) {
        gameDao.update(game);
    }

    public void remove(UUID id) {
        gameDao.delete(id);
    }

    public List<Game> getLatestGames(int amount, int page) {
        return gameDao.getLatestGames(amount, page);
    }
}
