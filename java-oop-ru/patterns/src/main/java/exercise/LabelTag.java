package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private TagInterface inputTag;
    private String label;

    LabelTag(String label, TagInterface inputTag) {
        this.inputTag = inputTag;
        this.label = label;
    }

    @Override
    public String render() {
        return "<label>" + this.label + this.inputTag.render() + "</label>";
    }
}
// END
