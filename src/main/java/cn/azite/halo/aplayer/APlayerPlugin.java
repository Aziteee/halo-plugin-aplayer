package cn.azite.halo.aplayer;

import org.springframework.stereotype.Component;
import run.halo.app.plugin.BasePlugin;
import run.halo.app.plugin.PluginContext;

@Component
public class APlayerPlugin extends BasePlugin {
    public APlayerPlugin(PluginContext pluginContext) {
        super(pluginContext);
    }
}
