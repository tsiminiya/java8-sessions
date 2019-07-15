package com.enjoy.sessions.java8.streams.filebased;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileBasedContent {

    String id;

    String type;

    String name;

    Integer majorVersion;

    Integer minorVersion;

    String value;

    String dateCreated;

    String createdBy;

    String dateUpdated;

    String updatedBy;

    Integer active;

    Integer deleted;

}
