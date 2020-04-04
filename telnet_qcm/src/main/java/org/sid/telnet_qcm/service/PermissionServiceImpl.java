package org.sid.telnet_qcm.service;

import org.sid.telnet_qcm.dao.PermissionRepository;
import org.sid.telnet_qcm.entities.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("Permissionservice")
public class PermissionServiceImpl implements PermissionService {


    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public List<Permission> getAllPerm() {
        return permissionRepository.findAll();
    }







    @Override
    public void savePerm(Permission perm) {
        permissionRepository.save(perm);

    }

    @Override
    public void removeperm(Long id) {
        Permission perm = permissionRepository.getOne(id);
        permissionRepository.delete(perm);


    }

    @Override
    public void updateperm(Integer id) {

    }

    @Override
    public Permission getpermissionbyid(Long id) {
        return permissionRepository.getOne(id);
    }

    @Override
    public void removeAll(List<Permission> perm) {
        permissionRepository.deleteAll(perm);
    }
}
