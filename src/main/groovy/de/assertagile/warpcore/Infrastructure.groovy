package de.assertagile.warpcore

import de.assertagile.warpcore.service.Service

class Infrastructure {

    private Collection<Service> services

    public Collection<Service> getServices() {
        if (services == null) {
            services = discoverServices()
        }
        return services
    }

    private Collection<Service> discoverServices() {
        return []
    }
}
