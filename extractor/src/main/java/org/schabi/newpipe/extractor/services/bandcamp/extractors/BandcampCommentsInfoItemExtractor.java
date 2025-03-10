package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import org.jsoup.nodes.Element;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.exceptions.ParsingException;

public class BandcampCommentsInfoItemExtractor implements CommentsInfoItemExtractor {

    private final Element writing;
    private final String url;

    public BandcampCommentsInfoItemExtractor(final Element writing, final String url) {
        this.writing = writing;
        this.url = url;
    }

    @Override
    public String getName() throws ParsingException {
        return writing.getElementsByClass("text").first().ownText();
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getThumbnailUrl() throws ParsingException {
        return writing.getElementsByClass("thumb").attr("src");
    }

    @Override
    public String getCommentText() {
        return writing.getElementsByClass("text").first().ownText();
    }

    @Override
    public String getUploaderName() throws ParsingException {
        return writing.getElementsByClass("name").first().text();
    }

    @Override
    public String getUploaderAvatarUrl() {
        return writing.getElementsByClass("thumb").attr("src");
    }
}
