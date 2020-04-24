package murex.dev.mxem.Environments.service;

import murex.dev.mxem.Environments.exception.PermissionNotFoundException;
import murex.dev.mxem.Environments.exception.RoleNotFoundException;
import murex.dev.mxem.Environments.exception.UserNotFoundException;
import murex.dev.mxem.Environments.model.Permission;
import murex.dev.mxem.Environments.model.Role;
import murex.dev.mxem.Environments.model.User;
import murex.dev.mxem.Environments.repository.PermissionRepository;
import murex.dev.mxem.Environments.repository.RoleRepository;
import murex.dev.mxem.Environments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService implements IRoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PermissionRepository permissionRepository;

    public List<Role> findAllRoles() {
        List<Role> roles = (List<Role>) roleRepository.findAll();
        return roles;
    }

    @Override
    public Optional<Role> findRoleById(Long id) throws RoleNotFoundException {
        Optional<Role> role = roleRepository.findById(id);
        if (!role.isPresent()) {
            throw new RoleNotFoundException();
        }
        return role;
    }

    public Role findRoleByName(String name){
        if(roleRepository.findByName(name).size()!=0){
       return (roleRepository.findByName(name).get(0));}
        else{
            return null;
        }

    }

    @Override
    public Set<Permission> findPermissionsForRole(String id) throws RoleNotFoundException {
        return findRoleByName(id).getPermissions();
    }

    @Override
    public Set<User> findUsersForRole(Long id) throws RoleNotFoundException {
        return findRoleById(id).get().getUsers();
    }

    @Override
    public void deleteAllRoles() {
        roleRepository.deleteAll();

    }

    @Override
    public void deleteRoleById(String id) throws RoleNotFoundException {
        List<Role> result = roleRepository.findByName(id);
        if (result.size()==0) {
            throw new RoleNotFoundException();
        }
        roleRepository.deleteById(result.get(0).getId());

    }

    @Override
    public void deletePermissionsForRole(Long id) throws RoleNotFoundException {
        Role role = findRoleById(id).get();
        role.setPermissions(Collections.EMPTY_SET);
        roleRepository.save(role);

    }

    @Override
    public void deleteUsersForRole(Long id) throws RoleNotFoundException {
        Role role = findRoleById(id).get();
        role.setUsers(Collections.EMPTY_SET);
        roleRepository.save(role);

    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) throws RoleNotFoundException {
        Optional<Role> roleInTable = roleRepository.findById(id);
        if (!roleInTable.isPresent()) {
            throw new RoleNotFoundException();
        }
        role.setId(id);
        return roleRepository.save(role);
    }

    @Override
    public Role updateNameofRole(Long id, String name) throws RoleNotFoundException {
        Role role= findRoleById(id).get();
        role.setName(name);
        return roleRepository.save(role);
    }

    @Override
    public User addUserForRole(Long roleId, Long userId) throws RoleNotFoundException, UserNotFoundException {
        Optional<Role> roleInTable = roleRepository.findById(roleId);
        if (!roleInTable.isPresent()) {
            throw new RoleNotFoundException();
        }

        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException();
        }
        roleInTable.get().getUsers().add(user.get());
        roleRepository.save(roleInTable.get());
        return user.get();
    }

    @Override
    public Permission addPermissionForRole(Long roleId, Long permissionId) throws RoleNotFoundException, PermissionNotFoundException {
        Optional<Role> roleInTable = roleRepository.findById(roleId);
        if (!roleInTable.isPresent()) {
            throw new RoleNotFoundException();
        }
        Optional<Permission> permissionInTable = permissionRepository.findById(permissionId);
        if (!roleInTable.isPresent()) {
            throw new PermissionNotFoundException();
        }
        roleInTable.get().getPermissions().add(permissionInTable.get());
        roleRepository.save(roleInTable.get());
        return permissionInTable.get();
    }
}
