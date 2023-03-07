package com.taisiia.musicApp.service

import com.taisiia.musicApp.domain.dao.Track
import com.taisiia.musicApp.exception.NotFoundException
import com.taisiia.musicApp.repository.TrackRepository
import spock.lang.Specification

import javax.persistence.EntityNotFoundException

class TrackServiceSpec extends Specification {

    def trackRepository = Mock(TrackRepository)
    def trackService = new TrackService(trackRepository)


    def "should find track by id"() {

        given:

        def id = 5
        def optionalTrack = Optional.of(new Track())

        when:
        trackService.findTrackById(id)
        then:
        1 * trackRepository.findById(id) >> optionalTrack
        0 * _

    }

    def "should not find track by id"() {
        given:

        def id = 5
        def optionalTrack = Optional.empty();

        trackRepository.findById(id) >> optionalTrack

        when:
        trackService.findTrackById(id)
        then:
        thrown NotFoundException

    }

    def " should find all tracks"() {


        given:
        def trackList = List.of(Mock(Track), Mock(Track), Mock(Track))

        trackRepository.findAll() >> trackList
        when:
        def result = trackService.getAllTracks();
        then:
        result == trackList
    }
}
