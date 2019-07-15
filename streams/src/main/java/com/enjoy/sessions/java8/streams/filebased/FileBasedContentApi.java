package com.enjoy.sessions.java8.streams.filebased;

public interface FileBasedContentApi {

    FileBasedContent getContent(String id);

    FileBasedContent[] getContents(String sortBy, String direction);

    long count();

}
