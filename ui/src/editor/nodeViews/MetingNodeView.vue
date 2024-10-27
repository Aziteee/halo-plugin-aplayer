<script lang="ts" setup>
import { type NodeViewProps, NodeViewWrapper } from "@halo-dev/richtext-editor";
import { ref, watch } from "vue";

const props = defineProps<NodeViewProps>();

const autoLink = ref(props.node.attrs.auto);

watch(autoLink, (newVal) => {
  props.updateAttributes({ auto: newVal });
});
</script>

<template>
  <NodeViewWrapper>
    <div class="meting-nodeview-container">
      <div class="meting-nodeview-header">
        <div class="meting-nodeview-title">Meting</div>
      </div>
      <div class="meting-nodeview-content">
        <input v-model="autoLink" type="text" placeholder="请输入歌曲链接" />
      </div>
    </div>
  </NodeViewWrapper>
</template>

<style lang="scss" scoped>
.meting-nodeview-container {
  margin: 10px 5px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  display: flex;
  flex-direction: column;

  .meting-nodeview-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-left: 5px;
    margin-right: 10px;

    .meting-nodeview-title {
    }

    .autoplay-switch {
      display: flex;
      align-items: center;

      span {
        margin-right: 5px;
      }
    }
  }

  .meting-nodeview-content {
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
