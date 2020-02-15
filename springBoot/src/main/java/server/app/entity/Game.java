package server.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table( name = "game")
public class Game {

    @Id
    private UUID id;
    private String name;
    private int mark;
    private String description;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "gameId")
    private List<GameTag> tags = new ArrayList<>();

    public Game(UUID id, String name, int mark, String description, List<GameTag> tags ) {
        this.name = name;
        this.mark = mark;
        this.description = description;
        this.id = id;
        this.tags = tags;
    }

    public Game(String name, int mark, String description, List<GameTag> tags) {
        this.name = name;
        this.mark = mark;
        this.description = description;
        this.tags = tags;

        this.id = UUID.randomUUID();
    }

    public Game() {}

    public List<GameTag> getTags() {
        return tags;
    }

    public void setTags(List<GameTag> tags) {
        this.tags = tags;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void addId() { this.id = UUID.randomUUID(); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripton) {
        this.description = descripton;
    }
}
