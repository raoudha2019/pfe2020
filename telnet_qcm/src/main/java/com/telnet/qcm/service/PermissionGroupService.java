package com.telnet.qcm.service;

import java.util.List;

import com.telnet.qcm.entities.Permission;
import com.telnet.qcm.entities.PermissionGroup;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PermissionGroupService {

    public List<PermissionGroup> getAllpermissionGroups();
    public void savePermissionGroup(@RequestBody PermissionGroup permissionGroup);
    public void removePermissionGroup( @PathVariable("id") Long id) ;
    public void updatePermissionGroup( @PathVariable("id") Long id) ;
    public List<Permission> getPermissionGroup(Long id);
    public PermissionGroup getPermissionGroupbyId(Long id);

}
