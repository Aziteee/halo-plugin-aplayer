package cn.azite.halo.aplayer;

public class APlayerJSInjector {

    static String getAPlayerScript(String api, String version) {
        String apiCustomCode = (api == null) ? "" : "var meting_api='" + api + "';";
        return """
                <link rel="stylesheet" href="/plugins/halo-plugin-aplayer/assets/static/APlayer.min.css?version=%s">
                <script defer src="/plugins/halo-plugin-aplayer/assets/static/APlayer.min.js"></script>
                <script defer src="/plugins/halo-plugin-aplayer/assets/static/Meting.js"></script>
                <link rel="stylesheet" href="/plugins/halo-plugin-aplayer/assets/static/var.css?version=%s">
                <script>
                    %s
                    document.addEventListener("DOMContentLoaded", function() {
                      const aplayerElements = document.querySelectorAll("div[aplayer]");
                      for (let i = 0; i < aplayerElements.length; i++) {
                        const el = aplayerElements[i];
                        new APlayer({
                          container: el,
                          autoplay: el.getAttribute("autoplay") === "true",
                          lrcType: 3,
                          audio: [
                            {
                              name: el.getAttribute("name"),
                              artist: el.getAttribute("artist"),
                              url: el.getAttribute("url"),
                              cover: el.getAttribute("cover"),
                              lrc: el.getAttribute("lrc"),
                            },
                          ],
                        });
                      }
                    });
                </script>
                """
                .formatted(version, version, apiCustomCode);
    }

}
