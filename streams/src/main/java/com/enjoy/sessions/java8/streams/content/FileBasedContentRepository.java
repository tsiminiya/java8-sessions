package com.enjoy.sessions.java8.streams.content;

import com.enjoy.sessions.java8.streams.filebased.FileBasedContent;
import com.enjoy.sessions.java8.streams.filebased.FileBasedContentApi;
import com.enjoy.sessions.java8.streams.utils.PageRequest;
import com.enjoy.sessions.java8.streams.utils.Sort;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class FileBasedContentRepository implements ContentRepository {

    private final FileBasedContentApi fileBasedContentApi;

    @Override
    public Optional<Content> findOne(String id) {
        return Optional.ofNullable(fileBasedContentApi.getContent(id))
                    .map(fileBasedContent -> mapToContent(fileBasedContent));
    }

    @Override
    public List<Content> findAll() {
        return toStream(fileBasedContentApi.getContents(null, null))
                    .map(fileBasedContent -> mapToContent(fileBasedContent))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Content> findAll(Sort sort) {
        return toStream(fileBasedContentApi.getContents(sort.getSortBy(), sort.isAscending() ? "ASC" : "DESC"))
                    .map(fileBasedContent -> mapToContent(fileBasedContent))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Content> findByContentType(String contentType) {
        return toStream(fileBasedContentApi.getContents(null, null))
                    .map(fileBasedContent -> mapToContent(fileBasedContent))
                    .filter(content -> content.getType().equalsIgnoreCase(contentType))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Content> findByPageRequest(PageRequest pageRequest) {
        int page = pageRequest.getPage();
        long size = pageRequest.getPageSize();

        Sort sort = pageRequest.getSort();
        String sortBy = sort != null ? sort.getSortBy() : null;
        String direction = Optional.ofNullable(sort).filter(s -> s.isAscending()).map(s -> "ASC").orElse("DESC");

        return toStream(fileBasedContentApi.getContents(sortBy, direction))
                    .skip(page * size)
                    .limit(size)
                    .map(legacyContent -> mapToContent(legacyContent))
                    .collect(Collectors.toList());
    }

    private Stream<FileBasedContent> toStream(FileBasedContent[] contents) {
        if (contents == null) {
            return Stream.empty();
        }
        return Stream.of(contents);
    }

    private Content mapToContent(FileBasedContent fileBasedContent) {
        return Content.builder()
                .id(fileBasedContent.getId())
                .name(fileBasedContent.getName())
                .type(fileBasedContent.getType())
                .majorVersion(fileBasedContent.getMajorVersion())
                .minorVersion(fileBasedContent.getMinorVersion())
                .value(fileBasedContent.getValue())
                .dateCreated(LocalDateTime.parse(fileBasedContent.getDateCreated()))
                .createdBy(fileBasedContent.getCreatedBy())
                .dateUpdated(fileBasedContent.getDateUpdated() == null ? null : LocalDateTime.parse(fileBasedContent.getDateCreated()))
                .updatedBy(fileBasedContent.getUpdatedBy())
                .active(fileBasedContent.getActive() == 1)
                .deleted(fileBasedContent.getDeleted() == 1)
                .build();
    }

}
