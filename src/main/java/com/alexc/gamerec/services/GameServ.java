package com.alexc.gamerec.services;

import com.alexc.gamerec.models.Game;
import com.alexc.gamerec.models.Tag;
import com.alexc.gamerec.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServ {
    @Autowired
    GameRepo gameRepo;

    public Game createGame(Game game) {
        return gameRepo.save(game);
    }

    public Game createGame(String title, String description) {
        return gameRepo.save(new Game(title, description));
    }

    public Game findGameById(Long id) {
        if(gameRepo.findById(id).isEmpty()){
            return null;
        }
        return gameRepo.findById(id).get();
    }

    public List<Game> findGamesByTitle(String title) {
        return gameRepo.findGamesByTitle(title);
    }

    public Game updateGame(Game game) {
        return gameRepo.save(game);
    }

    public void deleteGame(Game game) {
        gameRepo.delete(game);
    }

    public void addTag(Game game, Tag tag) {
        List<Tag> tags = game.getTagList();
        tags.add(tag);
        game.setTagList(tags);
        gameRepo.save(game);
    }


}
