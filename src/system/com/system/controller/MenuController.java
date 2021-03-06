package com.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.model.Menu;
import com.system.model.Menu.Submenu;
import com.system.model.Role;
import com.system.service.ISystemService;
import com.system.service.dao.IHibernateDao;
import com.system.util.SystemMessage;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	
	@Autowired
	private IHibernateDao<Object, String> hibernateDao;
	
	@Autowired
	private ISystemService systemService;
	
	@RequestMapping(value="/save.html",produces="text/html;charset=utf-8")
	@ResponseBody
	public String saveOrUpdate(Menu menu){
		hibernateDao.saveOrUpdate(menu);
		return SystemMessage.getMessage("success");
	}
	
	@RequestMapping(value="/delete.html",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delMenu(Menu menu){
		hibernateDao.del(menu, true);
		return SystemMessage.getMessage("deleteSuccess");
	}
	
	@RequestMapping(value="/submenuList.html")
	public String openSubmenuList(Menu menu,Model model){
		List<Submenu> submenuList = systemService.getSubmenuList(menu);
		model.addAttribute("submenuList", submenuList);
		model.addAttribute("menu", menu);
		return "WEB-INF/views/menu/submenu.jsp";
	}
	
	@RequestMapping(value="/saveSubmenu.html",produces="text/html;charset=utf-8")
	@ResponseBody
	public String saveSubmenu(Submenu submenu){
		systemService.saveSubmenu(submenu);
		return SystemMessage.getMessage("success");
	}
	
	@RequestMapping(value="/delSubmenu.html",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delSubmenu(Submenu submenu){
		hibernateDao.del(submenu);
		return SystemMessage.getMessage("deleteSuccess");
	}
	
	@RequestMapping(value="/menuList.html")
	public String getRoleList(Role role, Model model){
		List<Menu> menuList = systemService.getMenuList(role);
		model.addAttribute("role", role);
		model.addAttribute("_menuList", menuList);
		return "WEB-INF/views/role/role_menu.jsp";
	}
}
