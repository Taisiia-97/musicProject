package com.taisiia.musicApp.service

import com.taisiia.musicApp.domain.dao.Album
import com.taisiia.musicApp.domain.dao.Edition
import com.taisiia.musicApp.domain.dao.Track
import com.taisiia.musicApp.exception.NotFoundException
import com.taisiia.musicApp.repository.AlbumRepository
import com.taisiia.musicApp.repository.EditionRepository
import spock.lang.Specification

class AlbumServiceSpec extends Specification {

    def albumRepository = Mock(AlbumRepository)

    def editionRepository = Mock(EditionRepository)

    def albumService = new AlbumService(albumRepository, editionRepository)

    

    def "should find album by editionId"() {

        given:
        def editionId = 5

        def edition = Mock(Edition)

        def album = Mock(Album)


        when:
        albumService.findByEdition(editionId)

        then:
        1 * editionRepository.findById(editionId) >> Optional.of(edition)
        1 * albumRepository.findAlbumByEditionsContains(edition) >> Optional.of(album)
        0 * _


    }


    def "should  not find album by editionId"() {

        given:
        def editionId = 5

        def edition = Mock(Edition)


        when:
        albumService.findByEdition(editionId)

        then:
        1 * editionRepository.findById(editionId) >> Optional.of(edition)
        1 * albumRepository.findAlbumByEditionsContains(edition) >> Optional.empty()
        0 * _

        def exception = thrown NotFoundException
        exception.message == "Not found album"


    }

    def "should  not find edition and album by editionId"() {

        given:
        def editionId = 5

        when:
        albumService.findByEdition(editionId)

        then:
        1 * editionRepository.findById(editionId) >> Optional.empty()
        0 * _

        def exception = thrown NotFoundException
        exception.message == "Not found edition"


    }


    def "should get tracks by editionId"() {


        given:
        def editionId = 5

        def edition = Mock(Edition)

        def tracks = Set.of(Mock(Track), Mock(Track), Mock(Track))

        1 * editionRepository.findById(editionId) >> Optional.of(edition)
        1 * edition.getTracks() >> tracks

        when:
        def result = albumService.getTracksByEdition(editionId)

        then:
        result == tracks

    }

    def "should not get tracks by editionId"() {


        given:
        def editionId = 5



        when:
        albumService.getTracksByEdition(editionId)

        then:
        1 * editionRepository.findById(editionId) >> Optional.empty()
        0 * _

        def exception = thrown NotFoundException
        exception.message == "Not found edition"


    }

}
