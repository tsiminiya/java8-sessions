package com.enjoy.sessions.java8.interfaces.player

import spock.lang.Specification

class DefaultPlayerServiceSpecification extends Specification {

    PlayerService playerService
    PlayerRepository playerRepository

    def setup() {
        playerRepository = Mock(PlayerRepository)
        playerService = new DefaultPlayerService(playerRepository)
    }

    def "should return player by email"() {
        given:
            def playerEntity = new PlayerEntity()
            playerEntity.country = 'PH'
            playerRepository.findByEmail(_ as String) >> Optional.of(playerEntity)
        when:
            def player = playerService.findPlayerByEmail('rm@gmail.com')
        then:
            player.isPresent()
    }

}
