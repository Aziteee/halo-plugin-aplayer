import {
  Node,
  VueNodeViewRenderer,
  Editor,
  ToolboxItem,
  nodeInputRule,
} from "@halo-dev/richtext-editor";
import { markRaw } from "vue";
import TablerMusic from "~icons/tabler/music";
import MetingNodeView from "./nodeViews/MetingNodeView.vue";

export const ExtensionMeting = Node.create({
  name: "meting",
  group: "block",
  selectable: true,
  allowGapCursor: true,
  atom: true,
  addAttributes() {
    return {
      auto: {
        default: "",
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
              title: "Meting",
              action: () => {
                editor
                  .chain()
                  .focus()
                  .insertContent([{ type: "meting" }])
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
        tag: "meting-js",
      },
    ];
  },
  renderHTML({ HTMLAttributes }) {
    return ["meting-js", HTMLAttributes];
  },
  addNodeView() {
    return VueNodeViewRenderer(MetingNodeView);
  },
  addInputRules() {
    return [
      nodeInputRule({
        find: /^:meting[\s\n]$/,
        type: this.type,
        getAttributes: () => {
          return {
            content: "",
            editMode: true,
          };
        },
      }),
    ];
  },
});
