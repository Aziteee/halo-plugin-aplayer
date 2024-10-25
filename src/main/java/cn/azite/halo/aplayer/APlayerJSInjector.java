package cn.azite.halo.aplayer;

public class APlayerJSInjector {
  static String getAPlayerScript() {
    return """
        <link rel="stylesheet" href="/plugins/halo-plugin-aplayer/assets/static/APlayer.min.css">
        <script defer src="/plugins/halo-plugin-aplayer/assets/static/APlayer.min.js"></script>
        <script defer src="/plugins/halo-plugin-aplayer/assets/static/Meting.min.js"></script>
        <script>
            document.addEventListener("DOMContentLoaded", function() {
              const aplayerElements = document.getElementsByClassName("aplayer");
              for (let i = 0; i < aplayerElements.length; i++) {
                const el = aplayerElements[i];
                new APlayer({
                  container: el,
                  autoplay: el.getAttribute("autoplay") === "true",
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
        """;
  }
}
