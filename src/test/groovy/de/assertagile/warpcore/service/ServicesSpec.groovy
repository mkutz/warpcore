package de.assertagile.warpcore.service

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream
import spock.lang.Specification
import spock.lang.Subject

class ServicesSpec extends Specification {

    @Subject
    Services services

    def "there should be services"() {
        when:
        services = new Services()

        then:
        services
    }
}
