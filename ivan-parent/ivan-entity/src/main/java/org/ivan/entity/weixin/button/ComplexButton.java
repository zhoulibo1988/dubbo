package org.ivan.entity.weixin.button;
/**
 * 二级菜单数组
 * 个数应为1~5个
 * @author ICHN
 *
 */
public class ComplexButton extends Button{
	 //二级菜单数组
    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
