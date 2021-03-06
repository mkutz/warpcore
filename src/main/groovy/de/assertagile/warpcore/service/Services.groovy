package de.assertagile.warpcore.service

import groovy.util.logging.Slf4j

import java.util.regex.Matcher

@Slf4j
class Services implements Map<String, Service> {

    @Delegate
    private Map<String, Service> services = new HashMap<>()

    public Services() {
        discoverServices()
    }

    private void discoverServices() {
        Process process = "service --status-all".execute()
        process.text.split("\n").each { String serviceStatusString ->
            Matcher matcher = (serviceStatusString =~ /^ \[ (?<status>[+-?]) \]\s+(?<name>[^\s]+)$/)
            if (matcher.find()) {
                String name = matcher.group("name")
                Status status = Status.forSymbol(matcher.group("status"))

                log.info("Discovered service ${name} in state ${status}")

                this.put(name, new Service(name, status))
            }
        }
    }
}