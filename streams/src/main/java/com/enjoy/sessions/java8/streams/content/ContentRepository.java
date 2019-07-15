package com.enjoy.sessions.java8.streams.content;

import com.enjoy.sessions.java8.streams.utils.PageRequest;
import com.enjoy.sessions.java8.streams.utils.Sort;

import java.util.List;
import java.util.Optional;

public interface ContentRepository {

    Optional<Content> findOne(String id);

    List<Content> findAll();

    List<Content> findAll(Sort sort);

    List<Content> findByContentType(String contentType);

    List<Content> findByPageRequest(PageRequest pageRequest);

}
