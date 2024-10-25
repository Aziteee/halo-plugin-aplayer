import {
  Node,
  VueNodeViewRenderer,
  mergeAttributes,
  Editor,
  ToolboxItem,
} from "@halo-dev/richtext-editor";
import { markRaw } from "vue";
import TablerMusic from "~icons/tabler/music";
import APlayerNodeView from "./nodeViews/APlayerNodeView.vue";

export const ExtensionAPlayer = Node.create({
  name: "aplayer",
  group: "block",
  selectable: true,
  allowGapCursor: true,
  atom: true,
  addAttributes() {
    return {
      name: {
        default: "",
      },
      artist: {
        default: "",
      },
      url: {
        default: "",
      },
      cover: {
        default: "",
      },
      lrc: {
        default: "",
      },
      autoplay: {
        default: false,
      },
    };
  },
  addOptions() {
    return {
      ...this.parent?.(),
      getToolboxItems({ editor }: { editor: Editor }) {
        return [
          {
            priority: 100,
            component: markRaw(ToolboxItem),
            props: {
              editor,
              icon: markRaw(TablerMusic),
              title: "APlayer",
              action: () => {
                editor
                  .chain()
                  .focus()
                  .insertContent([{ type: "aplayer" }])
                  .run();
              },
            },
          },
        ];
      },
    };
  },
  parseHTML() {
    return [
      {
        tag: "div",
      },
    ];
  },
  renderHTML({ HTMLAttributes }) {
    return ["div", mergeAttributes(HTMLAttributes, { class: "aplayer" })];
  },
  addNodeView() {
    return VueNodeViewRenderer(APlayerNodeView);
  },
});
