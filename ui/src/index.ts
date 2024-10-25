import { definePlugin } from "@halo-dev/console-shared";
import { ExtensionAPlayer } from "./editor/APlayer";
import { ExtensionMeting } from "./editor/Meting";

export default definePlugin({
  components: {},
  routes: [],
  extensionPoints: {
    "default:editor:extension:create": () => {
      return [ExtensionAPlayer, ExtensionMeting];
    },
  },
});
