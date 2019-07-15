package com.enjoy.sessions.java8.streams.legacy;

import java.util.List;

public interface LegacyContentApiClient {

    LegacyContent getContent(String id);

    List<LegacyContent> getContents(int page, long size, String sortBy, String direction);

    long count();

}
