package de.assertagile.warpcore

import de.assertagile.warpcore.service.Service
import spock.lang.Specification
import spock.lang.Subject

import java.util.regex.Matcher

class InfrastructureSpec extends Specification {

    @Subject
    Infrastructure infrastructure = new Infrastructure()

    def "infrastructure should be able to tell me if a service is running"() {
        expect:
        !infrastructure.services."rsync".isRunning()
    }

    def "infrastructure should be able to tell me if a service is enabled"() {
        expect:
        infrastructure.services."network-manager".isEnabled()
    }

    def "an unknown service should be null"() {
        expect:
        !infrastructure.services."unknwon-service"
    }
}