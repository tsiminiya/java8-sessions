package com.enjoy.sessions.java8.streams.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageRequest {

    int page;

    int pageSize;

    Sort sort;

}
