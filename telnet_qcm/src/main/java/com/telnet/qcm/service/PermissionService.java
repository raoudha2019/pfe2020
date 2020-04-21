package com.telnet.qcm.service;
import java.util.List;

import com.telnet.qcm.entities.Permission;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PermissionService {

    public List<Permission> getAllPerm();
    public void savePerm(@RequestBody Permission perm);
    public void removeperm( @PathVariable("id") Long id) ;
    public void updateperm( @PathVariable("id") Integer id) ;
    public Permission getpermissionbyid(Long id);
    public void removeAll(List<Permission> perm);

}