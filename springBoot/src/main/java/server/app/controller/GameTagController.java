package server.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.app.entity.GameTag;
import server.app.service.GameTagService;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/gamesTag")
public class GameTagController {

    @Autowired
    GameTagService gameTagService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void remove(@PathVariable UUID id, HttpServletResponse response){
         gameTagService.remove(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void add(@RequestBody GameTag gameTag, HttpServletResponse response  ) {
        gameTagService.add(gameTag);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
