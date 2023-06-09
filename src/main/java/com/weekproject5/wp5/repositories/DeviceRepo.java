package com.weekproject5.wp5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.weekproject5.wp5.models.Device;

public interface DeviceRepo extends JpaRepository<Device,Long> {
    
}
