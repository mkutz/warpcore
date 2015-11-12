package de.assertagile.warpcore.service

class SshService extends Service {

    @Override
    boolean isRunning() {
        return false
    }

    @Override
    boolean isEnabled() {
        return false
    }
}
