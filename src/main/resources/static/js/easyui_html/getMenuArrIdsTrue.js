function getMenuArrIdsTrue(menuArrIds) {

    var menuArrIdsTrue = [];
    var parentOK = null;
    var unEquals = null;
    var isParent = null;
    var isRootParent = null;
    for (var j in menuArrIds) {
        for (var k in menuArrIds) {
            // var isParent = Math.abs(menuArrIds[k].toString().length - menuArrIds[j].toString().length) < 3;
            var rootParent = menuArrIds[k].toString().length + menuArrIds[j].toString().length;
            // console.log("isParent:"+isParent);
            // console.log("parentBoolean:"+isParent<2+"");
            if (rootParent == 3 || rootParent == 6) {
                isParent = true;
                if (rootParent == 3) {
                    isRootParent = true;
                } else {
                    isRootParent = false;
                }
                // parentOK = true;
                // console.log(menuArrIds[k].toString()+":"+menuArrIds[j].toString() + parentOK);
                unEquals = menuArrIds[k].toString() !== menuArrIds[j].toString();
            }
            if (isParent) {
                if (isRootParent) { //当1,50  或 50,1 出现时
                    //不管那一边的数字为2,则判定查看是否有它的子菜单
                    if (menuArrIds[k].toString().length == 2) {
                        for (var u in menuArrIds) {
                            if (menuArrIds[u].toString().startsWith(menuArrIds[k].toString())) {
                                parentOK = true;
                            } else {
                                parentOK = false;
                            }
                        }
                    }
                    if (menuArrIds[j].toString().length == 2) {
                        for (var w in menuArrIds) {
                            if (menuArrIds[w].toString().startsWith(menuArrIds[j].toString())) {
                                parentOK = true;
                            } else {
                                parentOK = false;
                            }
                        }
                    }
                } else {
                    if (menuArrIds[k].toString().length > menuArrIds[j].toString().length) {
                        parentOK = menuArrIds[k].toString().startsWith(menuArrIds[j].toString());
                    }
                    else {
                        parentOK = menuArrIds[j].toString().startsWith(menuArrIds[k].toString());
                    }
                    unEquals = menuArrIds[k].toString() !== menuArrIds[j].toString();
                }
            }
            if (parentOK && unEquals) {
                menuArrIdsTrue.push(menuArrIds[j]);
            }

            //判断两个值是否一样
            // console.log(menuArrIds[k].toString() !== menuArrIds[j].toString());
            // console.log("内层k的menuID:" + menuArrIds[k] + ",外层j的menuID:" + menuArrIds[j]+",parentOK:"+parentOK+",unEquals:"+unEquals);

            parentOK = null;
        }
    }
    return menuArrIdsTrue;
}