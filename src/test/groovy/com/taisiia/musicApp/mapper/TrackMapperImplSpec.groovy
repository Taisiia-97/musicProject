package com.taisiia.musicApp.mapper

import com.taisiia.musicApp.domain.dao.Track
import spock.lang.Specification

import java.time.LocalTime

class TrackMapperImplSpec extends Specification {

    def trackMapperImpl = new TrackMapperImpl()

    def " should map Track to TrackDto"() {


        given:


        def track = new Track(id: 1, tittle: "tittle", performer: "performer", duration: LocalTime.of(0, 3, 20))

        when:

        def result = trackMapperImpl.toDto(track)

        then:
        result.id == track.id
        result.tittle == track.tittle
        result.performer == track.performer
        result.duration == track.duration


    }


    def " should not map Track to TrackDto"() {
        given:

        def track = null
        when:

        def result = trackMapperImpl.toDto(track)

        then:
        result == null


    }


}
