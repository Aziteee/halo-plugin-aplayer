import { fileURLToPath, URL } from "url";

import { HaloUIPluginBundlerKit } from "@halo-dev/ui-plugin-bundler-kit";
import Vue from "@vitejs/plugin-vue";
import Icons from "unplugin-icons/vite";
import { defineConfig } from "vite";
import { viteStaticCopy as ViteStaticCopy } from "vite-plugin-static-copy";

export default defineConfig({
  plugins: [
    Vue(),
    Icons({ compiler: "vue3" }),
    HaloUIPluginBundlerKit(),
    ViteStaticCopy({
      targets: [
        {
          src: `./node_modules/aplayer/dist/*`,
          dest: "../static",
        },
        {
          src: `./node_modules/meting/dist/*`,
          dest: "../static",
        },
      ],
    }),
  ],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", import.meta.url)),
    },
  },
});
