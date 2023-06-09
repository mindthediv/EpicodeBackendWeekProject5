package com.weekproject5.wp5.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekproject5.wp5.Common.dvc_type;
import com.weekproject5.wp5.models.Device;
import com.weekproject5.wp5.models.Employee;
import com.weekproject5.wp5.repositories.DeviceRepo;

@Service
public class DeviceService {
    @Autowired public DeviceRepo deviceRepo;

    public void save(Device e){
        deviceRepo.save(e);
    }
    public void saveAndFlush(Device e){
        deviceRepo.saveAndFlush(e);
    }
    public void update(Device e){
        deviceRepo.save(e);
    }
    public void delete(Device e){
        deviceRepo.delete(e);
    }
    public Optional<Device> findById(long id){
        return deviceRepo.findById(id);
    }
    public Device post(Employee o, dvc_type dt) {
        Device d = new Device(o, dt);
        deviceRepo.saveAndFlush(d);
        return d;
    }
}
