package server.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.app.entity.Game;
import server.app.service.GameService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Game> getAll(){
        return gameService.getAll();
    }

    @RequestMapping(value = "/{amount}/{page}", method = RequestMethod.GET)
    public List<Game> getLatestGames(@PathVariable int amount, @PathVariable int page){
        return gameService.getLatestGames(amount, page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public Game getById(@PathVariable UUID id){
        return gameService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void remove(@PathVariable UUID id, HttpServletResponse response){
        gameService.remove(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void add(@RequestBody Game game, HttpServletResponse response  ) {

        gameService.add(game);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void update(@RequestBody Game game, HttpServletResponse response, @PathVariable UUID id) {

        game.setId(id);
        gameService.update(game);
        response.setStatus(HttpServletResponse.SC_OK);
    }



}
