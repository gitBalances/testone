package com.tansuo365.test1.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tansuo365.test1.bean.user.EMenu;
import com.tansuo365.test1.service.redis.RedisService;
import com.tansuo365.test1.service.user.EMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 权限菜单的工具类,用户根据parentid,roleid(s)获取EMenu树形菜单
 * 只有当权限菜单添加或删除时,返回的allMenu json字符串才不会相同
 * 当设定menu菜单时,需要对redis进行更新(根据emenu存储在redis中的key)
 */
@Component
public class EMenuUtils {

    @Autowired
    private EMenuService eMenuService;
    @Autowired
    private RedisService redisService;

    /**
     * 获取所有菜单信息 (单条不适用)
     *
     * @param parentId
     * @param
     * @return
     */
    public JSONArray getAllMenuByParentIdAndSingleRoleId(Integer parentId, Long roleId) {
        JSONArray jsonArray = getMenuByParentIdAndSingleRoleId(parentId, roleId);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if ("open".equals(jsonObject.get("state").toString())) {
                continue;
            } else {
                jsonObject.put("children", getAllMenuByParentIdAndSingleRoleId((Integer) jsonObject.get("id"), roleId));
            }
        }
//        System.out.println("getAllMenuByParentIdAndSingleRoleId(Integer parentId, Long roleId):" + jsonArray);
        return jsonArray;
    }

    /**
     * 根据父节点和用户角色id查询菜单 (单条不适用)
     *
     * @param parentId
     * @param roleId
     * @return
     */
    private JSONArray getMenuByParentIdAndSingleRoleId(Integer parentId, Long roleId) {
        List<EMenu> eMenuList = eMenuService.findByParentIdAndSingleRoleId(parentId, roleId);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = null;

        for (EMenu eMenu : eMenuList) {
            jsonObject = new JSONObject();
            jsonObject.put("id", eMenu.getId());//节点id
            jsonObject.put("text", eMenu.getName());//节点名称
            if (eMenu.getState() == 1) {//根节点
                jsonObject.put("state", "closed");
            } else {//叶子节点
                jsonObject.put("state", "open");
            }
            jsonObject.put("iconCls", eMenu.getIcon());
            JSONObject attributeObject = new JSONObject();//扩展属性
            attributeObject.put("url", eMenu.getUrl());//菜单请求地址
            jsonObject.put("attributes", attributeObject);
            jsonArray.add(jsonObject);
        }
//        System.out.println("findByParentIdAndSingleRoleId:getEmenuList:jsonArray:" + jsonArray);
        return jsonArray;
    }

    /*============ids为数组时的方法=============*/

    /**
     * 根据多个roleid获取EMenu(已去重复EMenu)
     * 会有循环异常,比如根节点-1下两个同样的1节点,1节点下面同样的两个1010节点.
     *
     * @param parentId
     * @param ids
     * @param j
     * @return
     */
    public JSONArray getAllMenuByParentId(Integer parentId, Long[] ids, int j) { //<<<<<<<<<<

        JSONArray jsonArray = null;
        first:
        for (int k = j; k < ids.length; j++) { //如2个角色该for循环2次
            //先获取如role5的角色以及对应parentid的emenu
            Long id = ids[k];
//            System.out.println("forTIme:ID"+id);
            jsonArray = this.getMenuByParentIdAndSingleRoleId(parentId, id);
//            jsonArray = this.getMenuByParentId(parentId, ids);
            j++;
            second:
            for (int i = 0; i < jsonArray.size(); i++) {//size为该parentid节点下的含有的,根节点菜单及子菜单的数量

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                if ("open".equals(jsonObject.get("state").toString())) {//叶子节点,无法放children
                    continue;
//                    continue second;//继续执行上面for循环获取另一个菜单(根或子)
//                    break second;
                } else {
                    //-1,10
                    //如果有根节点[0],通过根节点的id即parentid,获取之下的子节点菜单
//                for(int j=0;j<ids.length;j++){
                    jsonObject.put("children", getAllMenuByParentId((Integer) jsonObject.get("id"), ids, j));
//                }
                }
            }
        }
//        System.out.println("getAllMenuByParentId(Integer parentId, Long[] ids):" + jsonArray);
        return jsonArray;
    }

    /**
     * 假如先传入-1 pid,ids,那么返回的应该是ids对应的所有的-1下的
     * 上面方法的附属方法,会被重复调用(bug)
     *
     * @param parentId
     * @param ids
     * @return
     */
    private JSONArray getMenuByParentId(Integer parentId, Long[] ids) {
        //获取不重复的EMenuList
        List<EMenu> eMenuList = eMenuService.findByParentIdAndRoleIdArr(parentId, ids);
//        System.err.println("eMenuList.size:" + eMenuList.size());
        JSONArray jsonArray = new JSONArray();
        for (EMenu eMenu : eMenuList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", eMenu.getId());//节点id
            jsonObject.put("text", eMenu.getName());//节点名称
            if (eMenu.getState() == 1) {//根节点
                jsonObject.put("state", "closed");
            } else {//叶子节点
                jsonObject.put("state", "open");
            }
            jsonObject.put("iconCls", eMenu.getIcon());
            JSONObject attributeObject = new JSONObject();//扩展属性
            attributeObject.put("url", eMenu.getUrl());//菜单请求地址
            jsonObject.put("attributes", attributeObject);
            jsonArray.add(jsonObject);
        }
//        System.out.println("findByParentIdAndRoleIdArr:getEmenuList:jsonArray:" + jsonArray);
        return jsonArray;
    }


    /**
     * 根据父节点ID和权限菜单ID集合获取复选框菜单节点
     * 用于AdminRoleController中loadCheckMenuInfo
     *
     * @param parentId
     * @param menuIdList
     * @return
     */
    public JSONArray getAllCheckedEMenuByParentId(Integer parentId, List<Integer> menuIdList) {
        JSONArray jsonArray = getCheckedMenuByParentId(parentId, menuIdList);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if ("open".equals(jsonObject.get("state").toString())) {
                continue;
            } else {
//                jsonObject.put("children",getAllCheckedEMenuByParentId((Integer) jsonObject.get("id"),menuIdList));
                jsonObject.put("children", getAllCheckedEMenuByParentId((Integer) jsonObject.get("id"), menuIdList));
            }
        }
        return jsonArray;
    }

    /**
     * 根据父节点ID和权限菜单ID集合获取复选框菜单节点 (new)
     * 用于AdminRoleController中loadCheckMenuInfo
     *
     * @param parentId
     * @param menuIds
     * @return
     */
    public JSONArray getAllEMenuByParentIdAndMenuIds(Integer parentId, int[] menuIds) {
        JSONArray jsonArray = getMenuByParentIdAndMenuIds(parentId, menuIds);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if ("open".equals(jsonObject.get("state").toString())) {
                continue;
            } else {
                jsonObject.put("children", getAllEMenuByParentIdAndMenuIds((Integer) jsonObject.get("id"), menuIds));
            }
        }
        return jsonArray;
    }


    /**
     * 根据父节点ID和权限菜单ID集合获取复选框菜单节点
     * 上面方法的附属方法
     *
     * @param parentId
     * @param menuIdList
     * @return
     */
    private JSONArray getCheckedMenuByParentId(Integer parentId, List<Integer> menuIdList) {
//    private JSONArray getCheckedMenuByParentId(Integer parentId, int[] menuIds) {
        List<EMenu> menuList = eMenuService.findByParentId(parentId);
//        List<EMenu> menuList = eMenuService.findByParentIdAndEMenuIds(parentId, menuIds);
        JSONArray jsonArray = new JSONArray();
        for (EMenu eMenu : menuList) {
            JSONObject jsonObject = new JSONObject();
            //获取menuid
            int menuId = eMenu.getId();
            jsonObject.put("id", menuId); //节点id
            jsonObject.put("text", eMenu.getName()); //节点名称 / 菜单名
            if (eMenu.getState() == 1) { //根节点
                jsonObject.put("state", "closed");
            } else { //叶子节点
                jsonObject.put("state", "open");
            }
            if (menuIdList.contains(menuId)) { //如果用户role涵盖的menuId list包含这个通过parentid查询到的 节点菜单
                jsonObject.put("checked", true);
            }
            jsonObject.put("iconCls", eMenu.getIcon());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    //通过menuIds获取菜单json
    private JSONArray getMenuByParentIdAndMenuIds(Integer parentId, int[] menuIds) {
//        List<EMenu> menuList = eMenuService.findByParentId(parentId);
        List<EMenu> menuList = eMenuService.findByParentIdAndEMenuIds(parentId, menuIds);

        JSONArray jsonArray = new JSONArray();
        for (EMenu eMenu : menuList) {
            JSONObject jsonObject = new JSONObject();
            //获取menuid
            int menuId = eMenu.getId();
            jsonObject.put("id", menuId); //节点id
            jsonObject.put("text", eMenu.getName()); //节点名称 / 菜单名
            if (eMenu.getState() == 1) { //根节点
                jsonObject.put("state", "closed");
            } else { //叶子节点
                jsonObject.put("state", "open");
            }
//            if(menuIdList.contains(menuId)){ //如果用户role涵盖的menuId list包含这个通过parentid查询到的 节点菜单
//                jsonObject.put("checked",true);
//            }
            jsonObject.put("iconCls", eMenu.getIcon());
            JSONObject attributeObject = new JSONObject();//扩展属性
            attributeObject.put("url", eMenu.getUrl());//菜单请求地址
            jsonObject.put("attributes", attributeObject);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

}
