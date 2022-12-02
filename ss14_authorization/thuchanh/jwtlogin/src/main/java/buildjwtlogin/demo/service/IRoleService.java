package buildjwtlogin.demo.service;

import buildjwtlogin.demo.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}