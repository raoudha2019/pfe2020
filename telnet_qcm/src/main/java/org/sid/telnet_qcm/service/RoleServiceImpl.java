package org.sid.telnet_qcm.service;

import org.sid.telnet_qcm.dao.RoleRepository;
import org.sid.telnet_qcm.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleservice")
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAllroles() {

        return roleRepository.findAll();
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public void removerole(Long id) {
        Role role = roleRepository.getOne(id);
        roleRepository.delete(role);

    }

    @Override
    public void updaterole(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Role getRolebyid(Long id) {

        return roleRepository.getOne(id);
    }

}
