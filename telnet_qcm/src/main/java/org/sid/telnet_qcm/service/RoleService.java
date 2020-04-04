package org.sid.telnet_qcm.service;

import org.sid.telnet_qcm.entities.Role;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface RoleService {

    public List<Role> getAllroles();
    public void saveRole(@RequestBody Role role);
    public void removerole( @PathVariable("id") Long id) ;
    public void updaterole( @PathVariable("id") Long id) ;
    public Role getRolebyid(Long id);
}
