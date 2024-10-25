package cn.azite.halo.aplayer;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import run.halo.app.theme.ReactivePostContentHandler;

@RequiredArgsConstructor
@Component
public class APlayerPostContentHandler implements ReactivePostContentHandler {

  @Override
  public Mono<PostContentContext> handle(PostContentContext postContent) {
    postContent.setContent(APlayerJSInjector.getAPlayerScript() + "\n" + postContent.getContent());
    return Mono.just(postContent);
  }

}
