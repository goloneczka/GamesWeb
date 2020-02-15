package server.app.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import server.app.entity.Game;
import java.util.List;
import java.util.UUID;

@Repository()
public class GameDao extends Dao<Game> {

    private final GameTagDao gameTagDao;

    public GameDao(NamedParameterJdbcTemplate jdbcTemplate, GameTagDao gameTagDao) {
        super(jdbcTemplate);
        this.gameTagDao = gameTagDao;
    }

    public List<Game> getAll(){
        return jdbcTemplate.query("SELECT * from game", ((resultSet, i) -> new Game(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name"),
                resultSet.getInt("mark"),
                resultSet.getString("description"),
                gameTagDao.getAllTagsForGame(UUID.fromString(resultSet.getString("id")))))
        );
    }

    public List<Game> getLatestGames(int amount, int page){
        return jdbcTemplate.query("select * from game limit :amount OFFSET ((SELECT count(*) FROM game)-(:page * :amount))",
                new MapSqlParameterSource()
                        .addValue("amount", amount)
                        .addValue("page", page),
                ((resultSet, i) -> new Game(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name"),
                resultSet.getInt("mark"),
                resultSet.getString("description"),
                gameTagDao.getAllTagsForGame(UUID.fromString(resultSet.getString("id")))))
        );
    }

    public Game getById(UUID id){
        return jdbcTemplate.queryForObject("SELECT * from game where game.id = :id",
                new MapSqlParameterSource("id", id), (resultSet, i) -> new Game( UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name"),
                        resultSet.getInt("mark"),
                        resultSet.getString("description"),
                        gameTagDao.getAllTagsForGame(UUID.fromString(resultSet.getString("id")))));
    }

    @Override
    public void add(Game game) {
        jdbcTemplate.update("INSERT INTO game (id, name, mark, description) values(:id, :name, :mark, :description)",
                new MapSqlParameterSource().
                        addValue("name", game.getName()).
                        addValue("id", game.getId()).
                        addValue("mark", game.getMark()).
                        addValue("description", game.getDescription()));

    }

    @Override
    public void update(Game game) {
        jdbcTemplate.update("UPDATE game SET name = :name, mark = :mark, description = :description WHERE id = :id ",
                new MapSqlParameterSource().
                        addValue("name", game.getName()).
                        addValue("id", game.getId()).
                        addValue("mark", game.getMark()).
                        addValue("description", game.getDescription()));

    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update("DELETE FROM game WHERE id = :id ",
                new MapSqlParameterSource().
                        addValue("id", id));
    }


}
