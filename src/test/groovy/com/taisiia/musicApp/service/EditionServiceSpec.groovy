package com.taisiia.musicApp.service

import com.taisiia.musicApp.domain.dao.Edition
import com.taisiia.musicApp.domain.dao.Track
import com.taisiia.musicApp.exception.NotFoundException
import com.taisiia.musicApp.repository.EditionRepository
import spock.lang.Specification

class EditionServiceSpec extends Specification {

    def editionRepository = Mock(EditionRepository)
    def editionService = new EditionService(editionRepository)


    def "should find edition by id"() {

        given:

        def id = 5
        def optionalEdition = Optional.of(new Edition())

        when:
        editionService.findById(id)
        then:
        1 * editionRepository.findById(id) >> optionalEdition
        0 * _

    }

    def "should not find edition by id"() {
        given:

        def id = 5
        def optionalEdition = Optional.empty();

        editionRepository.findById(id) >> optionalEdition

        when:
        editionService.findById(id)
        then:
        thrown NotFoundException

    }

    def " should find all editions"() {


        given:
        def editionList = List.of(Mock(Edition), Mock(Edition), Mock(Edition))

        editionRepository.findAll() >> editionList
        when:
        def result = editionService.getAllEditions()
        then:
        result == editionList
    }
}
