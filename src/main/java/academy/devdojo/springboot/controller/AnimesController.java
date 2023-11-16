package academy.devdojo.springboot.controller;

import static org.springframework.http.HttpStatus.OK;

import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.service.AnimesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
