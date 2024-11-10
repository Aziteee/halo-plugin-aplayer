package cn.azite.halo.aplayer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import reactor.core.publisher.Mono;
import run.halo.app.plugin.PluginContext;
import run.halo.app.plugin.ReactiveSettingFetcher;
import run.halo.app.theme.dialect.TemplateHeadProcessor;

@Component
@RequiredArgsConstructor
public class APlayerHeadProcessor implements TemplateHeadProcessor {

    private final ReactiveSettingFetcher settingFetcher;

    private final PluginContext pluginContext;

    @Override
    public Mono<Void> process(ITemplateContext context, IModel model,
        IElementModelStructureHandler structureHandler) {
        return settingFetcher.fetch(CustomSetting.GROUP, CustomSetting.class)
            .doOnNext(customSetting -> {
                final IModelFactory modelFactory = context.getModelFactory();
                model.add(modelFactory.createText(APlayerJSInjector.getAPlayerScript(customSetting.api(), pluginContext.getVersion())));
            })
            .then();
    }

    record CustomSetting(String api) {
        public static final String GROUP = "custom";
    }
}
