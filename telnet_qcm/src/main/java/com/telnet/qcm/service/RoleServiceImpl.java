package com.telnet.qcm.service;

import com.telnet.qcm.dao.RoleRepository;
import com.telnet.qcm.dao.UserRepository;
import com.telnet.qcm.entities.Role;
import com.telnet.qcm.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleservice")
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;
@Autowired
   UserRepository userRepository;
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
    public Role getRoleByName (String name) {

        return roleRepository.findRoleByName(name);

    }

    @Override
    public List <User> findUserByRole(Long id) {
        return userRepository.findUserByRole(id);

    }
    @Override
    public Role getRolebyid(Long id) {

        return roleRepository.getOne(id);
    }
}
