package de.assertagile.warpcore

import de.assertagile.warpcore.service.Service
import de.assertagile.warpcore.service.Services

class Infrastructure {

    private Services services

    public Services getServices() {
        if (services == null) {
            services = new Services()
        }
        services
    }
}
