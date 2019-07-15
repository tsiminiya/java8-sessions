package com.enjoy.sessions.java8.streams.samples

import spock.lang.Specification
import spock.lang.Unroll

class StreamSamplesSpecification extends Specification {

    @Unroll
    def "should return list of #count integer elements with value #value"() {
        when:
            List<Integer> numbers = StreamSamples.generateNumbers(count, value)
        then:
            numbers == expected
        where:
            count | value | expected
            10    | 5     | [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
            3     | 7     | [7, 7, 7]
    }

    @Unroll
    def "should return list of #count integer elements in sequence starting at #startValue with interval #interval"() {
        when:
            List<Integer> numbers = StreamSamples.generateNumbers(count, startValue, interval)
        then:
            numbers == expected
        where:
            count | startValue | interval | expected
            10    | 1          | 1        | [1, 2, 3, 4, 5, 6, 7, 8, 9 ,10]
            5     | 0          | 2        | [0, 2, 4, 6, 8]
    }

}
