package com.alexc.gamerec.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "games_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> gamesWithTag;

    public Tag() {}

    public Tag(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getGamesWithTagIds() {
        List<Long> gameIds = new ArrayList<Long>();
        for(Game game : gamesWithTag) {
            gameIds.add(game.getId());
        }
        return gameIds;
    }

    public void setGamesWithTag(List<Game> gamesWithTag) {
        this.gamesWithTag = gamesWithTag;
    }
}
