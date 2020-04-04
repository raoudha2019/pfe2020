package org.sid.telnet_qcm.service;

import org.sid.telnet_qcm.dao.PermissionGroupRepository;
import org.sid.telnet_qcm.entities.Permission;
import org.sid.telnet_qcm.entities.PermissionGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PermissionGroup")
public class PermissionGroupServiceImp implements PermissionGroupService {

    @Autowired
    PermissionGroupRepository permissionGroupRepository;

    /**
     * @return
     */
    @Override
    public List<PermissionGroup> getAllpermissionGroups() {
        return permissionGroupRepository.findAll();
    }

    /**
     * @param permissionGroup
     */
    @Override
    public void savePermissionGroup(PermissionGroup permissionGroup) {
        permissionGroupRepository.save(permissionGroup);


    }

    /**
     * @param id
     */
    @Override
    public void removePermissionGroup(Long id) {
        PermissionGroup permissionGroup = permissionGroupRepository.getOne(id);
        permissionGroupRepository.delete(permissionGroup);

    }

    @Override
    public void updatePermissionGroup(Long id) {

    }

    @Override
    public List<Permission> getPermissionGroup(Long id) {
        PermissionGroup permissionGroup = permissionGroupRepository.getOne(id);
        return permissionGroup.getpermission();
    }

    @Override
    public PermissionGroup getPermissionGroupbyId(Long id) {
        return permissionGroupRepository.getOne(id);
    }
}
