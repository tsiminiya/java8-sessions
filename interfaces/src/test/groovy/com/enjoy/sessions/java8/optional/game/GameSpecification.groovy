package com.enjoy.sessions.java8.optional.game

import spock.lang.Specification

class GameSpecification extends Specification {

    Game game
    GameChannel gameChannel = Mock(GameChannel)
    GameConnectionPool pool = Mock(GameConnectionPool)
    GameConnection conn = Mock(GameConnection)

    def setup() {
        game = new Game(gameChannel)
    }

    def "should be able to assign connection to game"() {
        given:
            gameChannel.getConnectionPool() >> pool
        and:
            pool.getConnection() >> conn
        and:
            pool.isInitialized() >> true
        and:
            conn.isOpen() >> true
        when:
            game.connect()
        then:
            1 * conn.assign(game)
    }

}
