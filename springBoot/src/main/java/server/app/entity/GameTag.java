package server.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity (name = "GameTag")
@Table (name = "game_tag")
public class GameTag {

    @Id
    private UUID id;
    private UUID gameId;
    private String tag;

    public GameTag(UUID id, UUID gameId, String tag) {
        this.id = id;
        this.gameId = gameId;
        this.tag = tag;
    }

    public GameTag(UUID gameId, String tag) {
        this.id = UUID.randomUUID();
        this.gameId = gameId;
        this.tag = tag;
    }

    public GameTag() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void addId() { this.id = UUID.randomUUID(); }

    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
