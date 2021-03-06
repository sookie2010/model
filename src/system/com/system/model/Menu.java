package com.system.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONType;
/**
 * 菜单实体类
 * @author 41882
 *
 */
@JSONType(ignores={"roles"})
public class Menu implements Serializable,Comparable<Menu> {
	private static final long serialVersionUID = -2750501428057074001L;
	
	private String id;//主键
	private String menuName;//菜单名称
	private String url;//URL地址
	private String icon;//图标编码
	private String remark;//备注
	private int index;
	private List<Submenu> childrenMenu;//子菜单
	private Set<Role> roles;//该菜单对应的角色
	/**
	 * 子菜单实体类
	 * @author 41882
	 *
	 */
	public static class Submenu implements Serializable {
		private static final long serialVersionUID = 2119936011887556337L;
		private String id;
		private String submenuName;//子菜单名称
		private String url;//URL地址
		private String remark;//备注
		private Menu menu;//父菜单对象
		public String getId() {
			return id;
		}
		public void setId(String id) {
			if(id!=null && id.length()==0){
				id = null;
			}
			this.id = id;
		}
		public String getSubmenuName() {
			return submenuName;
		}
		public void setSubmenuName(String submenuName) {
			this.submenuName = submenuName;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public Menu getMenu() {
			return menu;
		}
		public void setMenu(Menu menu) {
			this.menu = menu;
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id!=null && id.length()==0){
			id = null;
		}
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<Submenu> getChildrenMenu() {
		return childrenMenu;
	}
	public void setChildrenMenu(List<Submenu> childrenMenu) {
		this.childrenMenu = childrenMenu;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIndex(){
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public int compareTo(Menu obj) {
		if(this.index > obj.index) {
			return 1;
		} else if(this.index < obj.index) {
			return -1;
		} else {
			return 0;
		}
	}
}
