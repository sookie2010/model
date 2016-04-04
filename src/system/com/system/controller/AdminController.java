package com.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.model.Dict;
import com.system.model.Menu;
import com.system.model.Role;
import com.system.model.User;
import com.system.service.dao.IHibernateDao;
import com.system.tags.Page;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private IHibernateDao<Object,String> hibernateDao;
	/**
	 * 菜单管理
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/menuManage.html")
	public String menuManage(Model model,Page page){
		page.setLinkUrl("admin/menuManage.html");
		hibernateDao.dir(Menu.class, page);
		model.addAttribute("page",page);
		return "/WEB-INF/views/admin/menu_manage.jsp";
	}
	/**
	 * 角色管理
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/roleManage.html")
	public String roleManage(Model model,Page page){
		page.setLinkUrl("admin/roleManage.html");
		hibernateDao.dir(Role.class,page);
		model.addAttribute("page", page);
		return "/WEB-INF/views/admin/role_manage.jsp";
	}
	/**
	 * 用户管理
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/userManage.html")
	public String userManage(Model model,Page page){
		page.setLinkUrl("admin/userManage.html");
		hibernateDao.dir(User.class,page);
		model.addAttribute("page", page);
		return "/WEB-INF/views/admin/user_manage.jsp";
	}
	/**
	 * 字典管理
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/dictManage.html")
	public String dictManage(Model model,Page page){
		page.setLinkUrl("admin/dictManage.html");
		hibernateDao.dir(Dict.class,page);
		model.addAttribute("page", page);
		return "/WEB-INF/views/admin/dict_manage.jsp";
	}
	
}
