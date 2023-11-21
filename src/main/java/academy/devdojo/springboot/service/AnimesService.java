package academy.devdojo.springboot.service;

import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.repository.AnimeRepository;
import academy.devdojo.springboot.requests.AnimePostRequestBody;
import academy.devdojo.springboot.requests.AnimePutRequestBody;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AnimesService {

  private final AnimeRepository animeRepository;

  public List<Anime> animeListAll() {
    return animeRepository.findAll();
  }

  public Anime findByIdOrThrowBadRequestException(Long id) {
    return animeRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
  }

  public Anime save(AnimePostRequestBody animePostRequestBody) {
    Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
    return animeRepository.save(anime);
  }

  public void delete(Long id) {
    animeRepository.delete(findByIdOrThrowBadRequestException(id));
  }

  public void replace(AnimePutRequestBody animePutRequestBody) {
    findByIdOrThrowBadRequestException(animePutRequestBody.getId());

    Anime anime = Anime.builder()
        .id(animePutRequestBody.getId())
        .name(animePutRequestBody.getName())
        .build();

    animeRepository.save(anime);
  }
}
