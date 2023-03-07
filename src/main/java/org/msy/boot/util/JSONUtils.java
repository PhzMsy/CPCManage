package org.msy.boot.util;


import org.msy.boot.entity.Menu;
import org.springframework.util.StringUtils;

import java.util.List;

public class JSONUtils {

    private  StringBuffer json = new StringBuffer("");

    public String build(List<Menu> menuList) {
        json.append("[");
        for(int i = 0; i < menuList.size() ; i ++) {
            Menu menu = menuList.get(i);
            json.append("{");
            // 菜单id
            json.append("\"id\":\"").append(menu.getMid()).append("\",");
            // 菜单名称
            json.append("\"text\":\"").append(menu.getMName()).append("\"");

            if(menu.isChecked()) {
                json.append(",\"state\": {\"selected\":true}");
            } else {
                json.append(",\"state\": {\"selected\":false}");
            }

            if(menu.getMenuList() != null && menu.getMenuList().size() > 0) {
                json.append(",\"children\":");
                build(menu.getMenuList());
            }

            // 结尾
            if(i < menuList.size() - 1) {
                json.append("},");
            } else {
                json.append("}");
            }
        }
        json.append("]");

        return json.toString();
    }


    // json 转数组
    public static Integer[] jsonToIntArray(String strJson) {
        if(StringUtils.hasLength(strJson)) {
            String[] split = strJson.split(",");
            Integer[] arr = new Integer[split.length];
            for (int i = 0; i < split.length ; i ++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            return arr;
        }
        return null;
    }
}
