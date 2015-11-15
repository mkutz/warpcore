package de.assertagile.warpcore.service

import groovy.transform.ToString
import groovy.util.logging.Slf4j

@Slf4j
@ToString(includeFields = true, includePackage = false)
class Service {

    private final String name
    private final Status status

    public Service(String name, Status status) {
        this.name = name
        this.status = status
    }

    public Boolean isRunning() {
        Process process = "service ${name} status".execute()
        process.waitFor() == 0
    }

    public Boolean isEnabled() {
        Process process = "ls -1 /etc/init.d/".execute()
        List<String> enabledServices = process.text.split("\n")

        log.info("Discovered enabled services:\n\t${enabledServices.join("\n\t")}")

        enabledServices.contains(name)
    }
}
