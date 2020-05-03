package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.entity.Role;
import kz.muminov.midtermrestaraunt.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleById(Long id){
        return roleRepository.findById(id).orElse(null);
    }

}
