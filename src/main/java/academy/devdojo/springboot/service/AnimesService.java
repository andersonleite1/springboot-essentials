package academy.devdojo.springboot.service;

import academy.devdojo.springboot.domain.Anime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AnimesService {

  private static List<Anime> animeList;

  static {
    animeList = new ArrayList<>(List.of(new Anime(1L, "Boku No Hero"), new Anime(2L, "Berserk")));
  }

  public List<Anime> animeListAll() {
    return animeList;
  }

  public Anime findById(Long id) {
    return animeList.stream()
        .filter(anime -> anime.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
  }

  public Anime save(Anime anime) {
    anime.setId(ThreadLocalRandom.current().nextLong(3, 10000));
    animeList.add(anime);
    return anime;
  }

  public void delete(Long id) {
    animeList.remove(findById(id));
  }

  public void replace(Anime anime) {
    delete(anime.getId());
    animeList.add(anime);
  }
}
