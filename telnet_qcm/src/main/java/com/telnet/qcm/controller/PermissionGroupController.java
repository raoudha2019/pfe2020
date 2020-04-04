package com.telnet.qcm.controller;
import com.telnet.qcm.entities.Permission;
import com.telnet.qcm.service.PermissionService;
import com.telnet.qcm.entities.PermissionGroup;
import com.telnet.qcm.service.PermissionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@CrossOrigin("*")

@RestController

@RequestMapping("/PermissionGroup")


public class PermissionGroupController {
    @Autowired
    PermissionGroupService permissionGroupService;
    @Autowired
    PermissionService permissionService;


    /**
     * @param permissionGroup
     */
    @RequestMapping(value="/addPermissionGroup",method= RequestMethod.POST)

    public void savePermissionGroup(@RequestBody PermissionGroup permissionGroup) {
       permissionGroupService.savePermissionGroup(permissionGroup);

    }



    @RequestMapping(value=("/allPermGroup"),method=RequestMethod.GET)
    public List<PermissionGroup> getAllpermissionGroups() {
        return permissionGroupService.getAllpermissionGroups();
    }


    /**
     * @param id
     * @return permissionGroup By ID
     */
    @RequestMapping(value=("/PermissionGroup/{id}"),method=RequestMethod.GET)
    public List<Permission> removePermissionGroup(@PathVariable("id") Long id) {
        return permissionGroupService.getPermissionGroup(id);
    }


    /**
     * @param perm
     * @param id
     * ADD PermissionGroup
     */
    @RequestMapping(value=("/addPerm/{permissionGroupid}"),method=RequestMethod.POST)
    public void postsave(@RequestBody Permission perm,@PathVariable("permissionGroupid")Long id)
    {

        PermissionGroup permissionGroup =permissionGroupService.getPermissionGroupbyId(id);
        perm.setPermissionGroup(permissionGroup);
        permissionService.savePerm(perm);

    }


    /**
     * delete PermissionGroup
     * @param id
     */

    @RequestMapping(value="/deletePermGroup/{id}",method=RequestMethod.DELETE)
    public void removeAction(@PathVariable("id") Long id) {
        List<Permission> perm=permissionGroupService.getPermissionGroup(id);
        permissionService.removeAll(perm);
        permissionGroupService.removePermissionGroup(id);
    }
}


