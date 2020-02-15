package server.app.service;

import org.springframework.stereotype.Service;
import server.app.dao.IDao;
import server.app.entity.GameTag;

import java.util.UUID;

@Service
public class GameTagService {

    private IDao<GameTag> gameTagDao;

    public GameTagService(IDao<GameTag> gameTagDao) {
        this.gameTagDao = gameTagDao;
    }

    public void update(GameTag gameTag) {
        gameTagDao.update(gameTag);
    }

    public void add(GameTag gameTag){
        gameTag.addId();
        gameTagDao.add(gameTag);
    }

    public void remove(UUID id){
        gameTagDao.delete(id);
    }
}
