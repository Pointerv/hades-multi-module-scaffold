package cn.com.felix.system.controller;

import cn.com.felix.common.basic.controller.BaseController;
import cn.com.felix.common.basic.service.BaseService;
import cn.com.felix.system.domain.SysRole;
import cn.com.felix.system.domain.SysWeapp;
import cn.com.felix.system.dto.SysPermissionTreeDTO;
import cn.com.felix.system.service.SysPermissionService;
import cn.com.felix.system.service.SysRoleService;
import cn.com.felix.system.service.SysWeappService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/system/role")
public class SysRoleController extends BaseController<SysRole> {

    private final SysRoleService sysRoleService;
    private final SysPermissionService sysPermissionService;
    private final SysWeappService weappService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService, SysPermissionService sysPermissionService, SysWeappService weappService) {
        this.sysRoleService = sysRoleService;
        this.sysPermissionService = sysPermissionService;
        this.weappService = weappService;
    }


    @Override
    public String getPrefix() {
        return "/system/role";
    }

    @Override
    public BaseService<SysRole, String> getBaseService() {
        return this.sysRoleService;
    }


    @RequestMapping(value = "/getRolePermissions")
    @ResponseBody
    public String getRolePermissions(String roleId) {
        List<SysPermissionTreeDTO> sysPermissionTreeDTOS = sysPermissionService.findPermissionTreeByRoleId(roleId);
        return JSON.toJSONString(sysPermissionTreeDTOS);
    }

    @RequestMapping(value = "/updateRolePermissions")
    @ResponseBody
    public String updateRolePermissions(@RequestParam(name = "permissions[]") String[] permissions, String roleId) {
        sysRoleService.updateRolePermissions(permissions, roleId);
//        shiroAuthorizationManager.refreshAuthorization();
        return ajaxSuccess("配置成功!");
    }

    @RequestMapping(value = "/saveOrUpdate")
    @ResponseBody
    public String saveOrUpdate(SysRole sysRole) {
        SysRole result = sysRoleService.saveOrUpdate(sysRole);

        if (result != null) {
            return ajaxSuccess("保存成功！");
        } else {
            return ajaxError("保存失败！");
        }
    }

    /**
     * 注意此方法如果在使用方变更了其中的属性值，会影响到数据
     * 所以不适用于需要解密，加密类的属性来使用
     * 便如组织列表、部门列表，会影响到结果，应该采用ajax请求数据的方式，
     * 但这个方法是真的方便
     * @return
     */
    @ModelAttribute(value = "weapps")
    public List<SysWeapp> getAllWeapps() {
        return weappService.findAll();
    }
}
