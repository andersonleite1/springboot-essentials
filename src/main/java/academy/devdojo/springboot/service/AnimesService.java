package academy.devdojo.springboot.service;

import academy.devdojo.springboot.domain.Anime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AnimesService {
  public List<Anime> animeListAll() {
    return List.of(new Anime(1L, "Boku No Hero"), new Anime(2L, "Berserk"));
  }
}
