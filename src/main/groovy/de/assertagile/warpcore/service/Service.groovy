package de.assertagile.warpcore.service

import groovy.transform.ToString

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
        enabledServices.contains(name)
    }
}
