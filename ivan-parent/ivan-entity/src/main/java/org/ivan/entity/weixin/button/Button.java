package org.ivan.entity.weixin.button;
/**
 * 菜单按钮
 * @author ICHN
 */
public class Button {
	 //菜单标题，不超过16个字节，子菜单不超过40个字节
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
