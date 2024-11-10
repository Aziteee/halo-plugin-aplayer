# halo-plugin-aplayer

集成 [APlayer](https://aplayer.js.org/) 音乐播放器与 [MetingJS](https://github.com/metowolf/MetingJS) 到 Halo 2.0。

[![pAwNZ7R.png](https://s21.ax1x.com/2024/10/25/pAwNZ7R.png)](https://imgse.com/i/pAwNZ7R)

[![pABvjq1.png](https://s21.ax1x.com/2024/10/31/pABvjq1.png)](https://imgse.com/i/pABvjq1)

## 使用说明

### 默认编辑器

在文章编辑页面，点击“插入”按钮，选择“APlayer”，根据[官方文档](https://aplayer.js.org/#/home)配置播放器参数即可。

或者插入“Meting”，输入歌曲链接即可自动生成播放器。

### 其他编辑器

插入对应的 html 代码即可。

#### APlayer

插入以下代码，并更改其中除了 `aplayer` 以外的属性。

```html
<div
  aplayer="true"
  name="name"
  artist="artist"
  url="audio.mp3"
  cover="cover.jpg"
  lrc="lrc.lrc"
  autoplay="true"
></div>
```

#### MetingJS

参考[官方文档](https://github.com/metowolf/MetingJS)。

示例：

```html
<meting-js auto="https://music.163.com/song?id=2011072415"></meting-js>
```

## 配置

支持自定义 [Meting API](https://github.com/metowolf/Meting)。

## 主题适配

### 自定义样式

此插件通常无需主题主动适配，可以开箱即用，但也暴露出了部分 CSS 变量。

目前已提供的 CSS 变量：

| 变量名                            | 描述             |
| --------------------------------- | ---------------- |
| `--aplayer-bg-color`              | 背景颜色         |
| `--aplayer-title-color`           | 标题颜色         |
| `--aplayer-artist-color`          | 艺术家颜色       |
| `--aplayer-lyrics-color`          | 歌词颜色         |
| `--aplayer-progress-bar-color`    | 进度条颜色       |
| `--aplayer-progress-loaded-color` | 进度条已加载颜色 |
| `--aplayer-progress-played-color` | 进度条已播放颜色 |
| `--aplayer-time-color`            | 时间颜色         |
| `--aplayer-icon-color`            | 图标颜色         |

<details>
<summary>点击查看 CSS 代码模板</summary>

```css
:root {
  --aplayer-bg-color: ;

  --aplayer-title-color: ;
  --aplayer-artist-color: ;
  --aplayer-lyrics-color: ;

  --aplayer-progress-bar-color: ;
  --aplayer-progress-loaded-color: ;
  --aplayer-progress-played-color: ;

  --aplayer-time-color: ;
  --aplayer-icon-color: ;
}
```

</details>

### 配色切换方案

根据上面提供的 CSS 变量，也可以通过定义 CSS 变量的方式为播放器提供动态切换配色的功能。

以下是实现示例，你可以根据需求自行修改选择器或者媒体查询。

<details>
<summary>点击查看示例</summary>

```css
@media (prefers-color-scheme: dark) {
  .color-scheme-auto,
  [data-color-scheme='auto'] .aplayer {
    color-scheme: dark;
    --aplayer-bg-color: #18181b;

    --aplayer-title-color: #f4f4f5;
    --aplayer-artist-color: #e4e4e7;
    --aplayer-lyrics-color: #e4e4e7;

    --aplayer-progress-bar-color: #a1a1aa;
    --aplayer-progress-loaded-color: #98989a;
    --aplayer-progress-played-color: #52525b;

    --aplayer-time-color: #e4e4e7;
    --aplayer-icon-color: #e4e4e7;
  }
}

.color-scheme-dark,
.dark,
[data-color-scheme='dark'] .aplayer {
    color-scheme: dark;
    --aplayer-bg-color: #18181b;

    --aplayer-title-color: #f4f4f5;
  	--aplayer-artist-color: #e4e4e7;
    --aplayer-lyrics-color: #e4e4e7;

    --aplayer-progress-bar-color: #a1a1aa;
    --aplayer-progress-loaded-color: #98989a;
    --aplayer-progress-played-color: #52525b;

    --aplayer-time-color: #e4e4e7;
    --aplayer-icon-color: #e4e4e7;
}
```

</details>

此外，为了让主题可以更加方便的适配暗黑模式，此插件也提供了一套暗黑模式的配色方案，主题可以直接使用此方案，而不需要自己去适配暗黑模式，适配方式如下：

1. 在 html 或者 body 标签添加 class：
   1. `color-scheme-auto`：自动模式，根据系统的暗黑模式自动切换。
   2. `color-scheme-dark` / `dark`：强制暗黑模式。
   3. `color-scheme-light` / `light`：强制明亮模式。
2. 在 html 或者 body 标签添加 `data-color-scheme` 属性：
   1. `auto`：自动模式，根据系统的暗黑模式自动切换。
   2. `dark`：强制暗黑模式。
   3. `light`：强制明亮模式。
