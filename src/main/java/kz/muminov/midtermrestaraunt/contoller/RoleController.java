package kz.muminov.midtermrestaraunt.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.muminov.midtermrestaraunt.entity.Role;
import kz.muminov.midtermrestaraunt.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(value = "Role Management System")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @ApiOperation(value = "Get all roles")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

}
