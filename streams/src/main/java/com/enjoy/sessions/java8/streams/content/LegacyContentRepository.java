package com.enjoy.sessions.java8.streams.content;

import com.enjoy.sessions.java8.streams.legacy.LegacyContent;
import com.enjoy.sessions.java8.streams.legacy.LegacyContentApiClient;
import com.enjoy.sessions.java8.streams.utils.PageRequest;
import com.enjoy.sessions.java8.streams.utils.Sort;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class LegacyContentRepository implements ContentRepository {

    private final LegacyContentApiClient legacyContentApiClient;

    @Override
    public Optional<Content> findOne(String id) {
        return Optional.ofNullable(legacyContentApiClient.getContent(id))
                    .map(legacyContent -> mapToContent(legacyContent));
    }

    @Override
    public List<Content> findAll() {
        long size = legacyContentApiClient.count();
        return toStream(legacyContentApiClient.getContents(0, size, null, null))
                    .map(legacyContent -> mapToContent(legacyContent))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Content> findAll(Sort sort) {
        long size = legacyContentApiClient.count();
        return toStream(legacyContentApiClient.getContents(0, size, sort.getSortBy(), sort.isAscending() ? "ASC" : "DESC"))
                    .map(legacyContent -> mapToContent(legacyContent))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Content> findByContentType(String contentType) {
        long size = legacyContentApiClient.count();
        return toStream(legacyContentApiClient.getContents(0, size, null, null))
                    .filter(legacyContent -> legacyContent.getType().equalsIgnoreCase(contentType))
                    .map(legacyContent -> mapToContent(legacyContent))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Content> findByPageRequest(PageRequest pageRequest) {
        return toStream(legacyContentApiClient.getContents(pageRequest.getPage(), pageRequest.getPageSize(),
                                                pageRequest.getSort() != null ? pageRequest.getSort().getSortBy() : null,
                                                Optional.ofNullable(pageRequest.getSort()).filter(sort -> sort.isAscending())
                                                        .map(sort -> "ASC")
                                                        .orElse("DESC")))
                .map(legacyContent -> mapToContent(legacyContent))
                .collect(Collectors.toList());
    }

    private Stream<LegacyContent> toStream(List<LegacyContent> contents) {
        if (contents == null) {
            return Stream.empty();
        }
        return contents.stream();
    }

    private Content mapToContent(LegacyContent legacyContent) {
        return Content.builder()
                    .id(legacyContent.getId())
                    .name(legacyContent.getName())
                    .type(legacyContent.getType())
                    .majorVersion(legacyContent.getMajorVersion())
                    .minorVersion(legacyContent.getMinorVersion())
                    .value(legacyContent.getValue())
                    .dateCreated(LocalDateTime.parse(legacyContent.getDateCreated()))
                    .createdBy(legacyContent.getCreatedBy())
                    .dateUpdated(legacyContent.getDateUpdated() == null ? null : LocalDateTime.parse(legacyContent.getDateCreated()))
                    .updatedBy(legacyContent.getUpdatedBy())
                    .active(legacyContent.getActive() == 1)
                    .deleted(legacyContent.getDeleted() == 1)
                    .build();
    }

}
