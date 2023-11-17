package academy.devdojo.springboot.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.service.AnimesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimesController {
    private final AnimesService animesService;

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        return new ResponseEntity<>(animesService.animeListAll(), OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id) {
        return new ResponseEntity<>(animesService.findById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime) {
        Anime animeSaved = animesService.save(anime);
        return new ResponseEntity<>(animeSaved, CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animesService.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Anime anime) {
        animesService.replace(anime);
        return new ResponseEntity<>(NO_CONTENT);
    }

}
