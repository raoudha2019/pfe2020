package com.telnet.qcm.service;

import com.telnet.qcm.entities.Role;
import com.telnet.qcm.entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface RoleService {

    public List<Role> getAllroles();
    public void saveRole(@RequestBody Role role);
    public void removerole( @PathVariable("id") Long id) ;
    public void updaterole( @PathVariable("id") Long id) ;
    public Role getRolebyid(Long id);
    public Role getRoleByName (String name);
    public List<User> findUserByRole (Long id);
}
