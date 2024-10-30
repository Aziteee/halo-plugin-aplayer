package cn.azite.halo.aplayer;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import run.halo.app.plugin.ReactiveSettingFetcher;
import run.halo.app.theme.ReactivePostContentHandler;

@Component
@RequiredArgsConstructor
public class APlayerPostContentHandler implements ReactivePostContentHandler {

    private final ReactiveSettingFetcher reactiveSettingFetcher;

    private static void injectJS(PostContentContext contentContext, String api) {
        String parsedAPlayerScript = APlayerJSInjector.getAPlayerScript(api);
        contentContext.setContent(parsedAPlayerScript + "\n" + contentContext.getContent());
    }

    @Override
    public Mono<PostContentContext> handle(PostContentContext contentContext) {
        return reactiveSettingFetcher.fetch("custom", CustomSetting.class).map(customSetting -> {
            injectJS(contentContext, customSetting.api());
            return contentContext;
        });
    }

}
