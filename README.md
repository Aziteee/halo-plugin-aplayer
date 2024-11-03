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

插入以下代码，并更改其中除了 class 以外的属性。

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
