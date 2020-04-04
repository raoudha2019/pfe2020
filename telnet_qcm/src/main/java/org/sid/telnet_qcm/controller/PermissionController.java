package org.sid.telnet_qcm.controller;

import org.sid.telnet_qcm.entities.Permission;
import org.sid.telnet_qcm.entities.PermissionGroup;
import org.sid.telnet_qcm.service.PermissionGroupService;
import org.sid.telnet_qcm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Permissions")

public class PermissionController {

    @Autowired
    PermissionGroupService permissionGroupService;
    @Autowired
    PermissionService permissionService;


    /**
     * @param perm
     */
    @RequestMapping(value="/addPerm",method= RequestMethod.POST)
    public void savePerm(@RequestBody Permission perm) {
        permissionService.savePerm(perm);

    }


    /**
     * @param perm
     * @param id
     */
    @RequestMapping(value=("/addPerm/{actionid}"),method=RequestMethod.POST)
    public void postsave(@RequestBody Permission perm,@PathVariable("actionid")Long id)
    {

        PermissionGroup permissionGroup =permissionGroupService.getPermissionGroupbyId(id);
        perm.setPermissionGroup(permissionGroup);
      permissionService.savePerm(perm);

    }






    @RequestMapping(value=("/allPerm"),method=RequestMethod.GET)
    public List<Permission> getAllPerm()
    {

        return permissionService.getAllPerm();
    }







    @RequestMapping(value="/deleteperm/{id}",method=RequestMethod.DELETE)
    public void removeperm(@PathVariable("id") Long id) {
        permissionService.removeperm(id);

    }


    @RequestMapping(value=("/permission/{id}"),method=RequestMethod.GET)
    public Permission getpermissionbyid(@PathVariable("id") Long id) {
        return permissionService.getpermissionbyid(id);
    }}

