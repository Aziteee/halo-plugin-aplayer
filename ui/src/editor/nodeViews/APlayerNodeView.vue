<script lang="ts" setup>
import { type NodeViewProps, NodeViewWrapper } from "@halo-dev/richtext-editor";
import { ref, watch } from "vue";
import { VSwitch } from "@halo-dev/components";

const props = defineProps<NodeViewProps>();
const localAttrs = ref({
  name: props.node.attrs.name,
  artist: props.node.attrs.artist,
  url: props.node.attrs.url,
  cover: props.node.attrs.cover,
  lrc: props.node.attrs.lrc,
  theme: props.node.attrs.theme,
  autoplay: props.node.attrs.autoplay,
});

watch(
  localAttrs,
  (newAttrs) => {
    props.updateAttributes(newAttrs);
  },
  { deep: true },
);
</script>

<template>
  <NodeViewWrapper>
    <div class="aplayer-nodeview-container">
      <div class="aplayer-nodeview-header">
        <div class="aplayer-nodeview-title">APlayer</div>
        <div class="autoplay-switch">
          <span>自动播放</span>
          <VSwitch v-model="localAttrs.autoplay" />
        </div>
      </div>
      <div class="aplayer-nodeview-content">
        <input
          v-model="localAttrs.name"
          type="text"
          placeholder="请输入歌曲名称"
        />
        <input
          v-model="localAttrs.artist"
          type="text"
          placeholder="请输入艺术家"
        />
        <input
          v-model="localAttrs.url"
          type="text"
          placeholder="请输入歌曲地址"
        />
        <input
          v-model="localAttrs.cover"
          type="text"
          placeholder="请输入封面地址"
        />
        <input
          v-model="localAttrs.lrc"
          type="text"
          placeholder="请输入歌词地址"
        />
      </div>
    </div>
  </NodeViewWrapper>
</template>

<style lang="scss" scoped>
.aplayer-nodeview-container {
  margin: 10px 5px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  display: flex;
  flex-direction: column;

  .aplayer-nodeview-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-left: 5px;
    margin-right: 15px;

    .aplayer-nodeview-title {
    }

    .autoplay-switch {
      display: flex;
      align-items: center;

      span {
        margin-right: 5px;
      }
    }
  }

  .aplayer-nodeview-content {
    margin-top: 10px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;

    input {
      margin: 5px 5px;
      padding: 5px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 14px;
      width: calc(100% - 30px);
      box-sizing: border-box;
    }
  }
}
</style>
