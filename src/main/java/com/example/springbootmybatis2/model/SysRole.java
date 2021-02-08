package com.example.springbootmybatis2.model;


import com.example.springbootmybatis2.constant.Enabled;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色表
 */
public class SysRole implements Serializable {
	private static final long serialVersionUID = 6320941908222932112L;
	/**
	 * 角色ID
	 */
	private Long id;
	/**
	 * 角色名
	 */
	private String roleName;
	/**
	 * 有效标志
	 */
	private Enabled enabled;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用户信息
	 */
	private SysUser user;
	/**
	 * 创建信息
	 */
	private CreateInfo createInfo;
	
	public CreateInfo getCreateInfo() {
		return createInfo;
	}

	public void setCreateInfo(CreateInfo createInfo) {
		this.createInfo = createInfo;
	}

	/**
	 * 角色包含的权限列表
	 */
	List<SysPrivilege> privilegeList;

	public List<SysPrivilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<SysPrivilege> privilegeList) {
		this.privilegeList = privilegeList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/***
	 *  枚举值特殊性 set get
	  *
	 * @author Charles
	 * @date 2021/2/8 15:47
	 * @return java.lang.Integer
	 */
	public Integer getEnabled() {
		return enabled.getValue();
	}

	public void setEnabled(Integer enabled) {
		this.enabled = Enabled.enabled;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

}
