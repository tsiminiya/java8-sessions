package com.enjoy.sessions.java8.streams.content;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Content {

    String id;

    String type;

    String name;

    Integer majorVersion;

    Integer minorVersion;

    String value;

    LocalDateTime dateCreated;

    String createdBy;

    LocalDateTime dateUpdated;

    String updatedBy;

    Boolean active;

    Boolean deleted;

}
