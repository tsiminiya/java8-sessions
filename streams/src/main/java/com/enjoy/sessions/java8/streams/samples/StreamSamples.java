package com.enjoy.sessions.java8.streams.samples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSamples {

    protected StreamSamples() {
        throw new UnsupportedOperationException();
    }

    public static List<Integer> generateNumbers(int count, int value) {
        return Stream.generate(() -> value).limit(count)
                .collect(Collectors.toList());
    }

    public static List<Integer> generateNumbers(int count, int startValue, int interval) {
        return Stream.iterate(startValue, (value) -> value + interval).limit(count)
                .collect(Collectors.toList());
    }

}
