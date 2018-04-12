package tagcloudgenerator.model;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Program that will read words from a .txt file and create a fully formed html
 * page displaying a tag cloud of the words from the .txt file.
 *
 * @author Matthew Shoemaker, Andrew Petrilli, Eddy Liang
 *
 */
public final class Model {

    /**
     * Constructor for this.
     */
    public Model() {
        this.createNewModel();
    }

    /**
     * Initializes all of the instance variables that belong to this.
     */
    private void createNewModel() {
        this.tags = new Map1L<>();
        this.sortedTags = new Queue1L<>();
        this.removeCommonWords = true;
    }

    /**
     * The collection of pairs containing tags and their corresponding
     * frequency.
     */
    private Map<String, Integer> tags;

    /**
     * Collection of keys in this.tags, in sorted order.
     */
    private Queue<String> sortedTags;

    /**
     * State of removeCommonWordsButton
     */
    private boolean removeCommonWords;

    /**
     * Adds {@code tag} to {@code this.model.tags} and if {@code tag} is already
     * in {@code tags} then it simply increments the value of that pair.
     *
     * @param tag
     *            the key to be added to this.model.tags
     */
    public void addTagToMap(String tag) {
        if (this.tags.hasKey(tag)) {
            Map.Pair<String, Integer> pair = this.tags.remove(tag);
            int count = pair.value();
            count++;
            this.tags.add(tag, count);
        } else {
            this.tags.add(tag, 1);
        }
    }

    /**
     * Returns a reference to this.model.tags.
     *
     * @return reference to this.model.tags
     */
    public Map<String, Integer> getTagsMap() {
        return this.tags;
    }

    /**
     * Adds {@code tag} to the {@code this.model.sortedTags}.
     *
     * @param tag
     *            tag to be added to this.model.sortedTags
     */
    public void addSortedTag(String tag) {
        this.sortedTags.enqueue(tag);
    }

    /**
     * Returns a reference to {@code this.model.sortedTags}.
     *
     * @return this.model.sortedTags
     */
    public Queue<String> getSortedTags() {
        return this.sortedTags;
    }

    /**
     * Returns this.removeCommonWords.
     *
     * @return this.removeCommonWords
     */
    public boolean removeCommonWords() {
        return this.removeCommonWords;
    }

    public void setRemoveCommonWords(boolean selected) {
        this.removeCommonWords = selected;
    }

    /**
     * Resets this.model.tags and this.sortedTags to their initial value.
     */
    public void clearModel() {
        this.createNewModel();
    }

}
