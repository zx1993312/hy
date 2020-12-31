package com.jlcc.cctp.model.vo;

import java.io.Serializable;

public abstract class BaseVo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6038179747642164527L;

	public Integer pageNum;//当前页码

	public Integer pageSize;//每页数量

}
