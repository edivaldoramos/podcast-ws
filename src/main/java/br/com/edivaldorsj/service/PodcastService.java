package br.com.edivaldorsj.service;

import br.com.edivaldorsj.mapper.PodcastMapper;
import br.com.edivaldorsj.model.Podcast;
import br.com.edivaldorsj.service.validacao.IPodcastValidacaoService;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldorsj.utils.exceptions.RecursoNaoEncontradoException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PodcastService implements IPodcastService {

  private final PodcastMapper            podcastMapper;
  private final IPodcastValidacaoService validacaoService;

  @Override
  public Podcast recuperarPorId(Long id) throws ParametroInvalidoException {
    validacaoService.validarIdPodcast(id);

    return Optional.ofNullable(podcastMapper.recuperarPorId(id))
        .orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum resultado para o id passado por parametro."));
  }

  @Override
  public Podcast recuperarPorNome(String nome) throws ParametroInvalidoException {
    validacaoService.validarNomePodcast(nome);

    return Optional.ofNullable(podcastMapper.recuperarPorNome(nome))
        .orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum resultado para o nome passado por parametro."));
  }

  @Override
  public List<Podcast> recuperarTodos() {
    return podcastMapper.recuperarTodos();
  }

}
