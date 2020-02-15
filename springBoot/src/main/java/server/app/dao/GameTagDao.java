package server.app.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import server.app.entity.GameTag;

import java.util.List;
import java.util.UUID;

@Repository()
public class GameTagDao extends Dao<GameTag> {

    public GameTagDao(NamedParameterJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<GameTag> getAllTagsForGame(UUID gameId) {
        return jdbcTemplate.query("SELECT * FROM game_tag WHERE game_tag.game_id = :id",
                new MapSqlParameterSource("id", gameId), (resultSet, rowNum) -> new GameTag(
                        UUID.fromString(resultSet.getString("id")),
                        gameId,
                        resultSet.getString("tag")
                ));
    }

    @Override
    public List<GameTag> getAll() {
        return jdbcTemplate.query("SELECT * FROM game_tag ", (resultSet, rowNum) -> new GameTag(
                UUID.fromString(resultSet.getString("id")),
                UUID.fromString(resultSet.getString("game_id")),
                resultSet.getString("tag")
        ));
    }

    @Override
    public List<GameTag> getLatestGames(int amount, int page) {
        return null;
    }

    public GameTag getById(UUID id) {
        return jdbcTemplate.queryForObject("SELECT * FROM game_tag WHERE game_tag.id = :id",
                new MapSqlParameterSource("id", id), (resultSet, rowNum) -> new GameTag(
                        UUID.fromString(resultSet.getString("id")),
                        id,
                        resultSet.getString("tag")
                ));
    }

    @Override
    public void add(GameTag gameTag) {
            jdbcTemplate.update("INSERT INTO game_tag (id, game_id, tag) values(:id, :gameId, :gameTag)",
                    new MapSqlParameterSource().
                            addValue("id", gameTag.getId()).
                            addValue("gameId", gameTag.getGameId()).
                            addValue("gameTag", gameTag.getTag()));
    }

    @Override
    public void update(GameTag gameTag) {
        jdbcTemplate.update("UPDATE game_tag SET tag = :gameTag WHERE id = :id ",
                new MapSqlParameterSource().
                        addValue("id", gameTag.getId()).
                        addValue("gameTag", gameTag.getTag()));
    }


    @Override
    public void delete(UUID id) {
            jdbcTemplate.update("DELETE FROM game_tag WHERE id = :id ",
                    new MapSqlParameterSource().
                            addValue("id", id));
    }


}
