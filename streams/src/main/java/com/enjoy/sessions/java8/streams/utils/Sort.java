package com.enjoy.sessions.java8.streams.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sort {

    String sortBy;

    boolean ascending;

}
