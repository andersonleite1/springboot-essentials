package academy.devdojo.springboot.service;

import academy.devdojo.springboot.domain.Anime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AnimesService {

  private final List<Anime> animeList = List.of(new Anime(1L, "Boku No Hero"), new Anime(2L, "Berserk"));

  public List<Anime> animeListAll() {
    return animeList;
  }

  public Anime findById(Long id) {
    return animeList.stream()
        .filter(anime -> anime.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
  }
}
