package de.assertagile.warpcore

import spock.lang.PendingFeature
import spock.lang.Specification
import spock.lang.Subject

class InfrastructureSpec extends Specification {

    @Subject
    Infrastructure infrastructure = new Infrastructure()

    @PendingFeature
    def "infrastructe should be able to tell me if a service is running"() {
        expect:
        infrastructure.services.ssh.running
    }

    @PendingFeature
    def "infrastructe should be able to tell me if a sevice is enabled"() {
        expect:
        infrastructure.services.ssh.enabled
    }
}