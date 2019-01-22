/*获取json数据中的某一个字段*/
function getParamValues(name, json) {
    var ret = [];
    var len = Object.keys(json).length;

    for (var i = 0; i < len; i++) {
        ret.push(json[i][name]);
    }
    return ret;
}

/*获取json数据中的某一个字段key根据给定value => 数组*/
function getParamValuesByCname(name, json, key, value) {
    var ret = [];
    var len = Object.keys(json).length;

    for (var i = 0; i < len; i++) {
        if (json[i][key] == value) {
            ret.push(json[i][name]);
        }
    }
    return ret;
}

/*数组去重*/
Array.prototype.delDuplicate = function () {
    var arr = new Array();
    for (var i = 0; i < this.length; i++) {
        if (arr.indexOf(this[i]) == -1) {
            arr.push(this[i]);
        }
    }
    console.log(JSON.stringify(arr));
    return arr;
}
/*遍历js数组*/
// Array.prototype.traversal = function(){
//     var arrStr = '';
//     for(var i=0;i<this.length;i++){
//         arrStr += this[i];
//     }
//     return arrStr;
// }

//获取以公司为key的todayprice数组
function getJsonResult(name, json, key, values) {
    var DataJSONStr = '';
    var ret = [];
    var len = Object.keys(json).length;

    for (var j = 0; j < values.length; j++) {
        for (var i = 0; i < len; i++) {
            if (json[i][key] == values[j]) {
                // console.log("values[i]:" + values[i]);
                // console.log("json[i][name]:" + json[i][name]);
                ret.push(json[i][name]);

            }
        }

        if (j != values.length - 1) {
            DataJSONStr += ("'" + values[j] + "':[" + ret + "],");
            ret = [];
        } else {
            DataJSONStr += ("'" + values[j] + "':[" + ret + "]");
            ret = [];
        }
        // console.log('values[i] + ":" + ret+",":' + values[i] + ":[" + ret + "],");
    }
    // var newJson = onDataStr.substring(onDataStr.length, onDataStr.length);
    var jsonStr = "{"+DataJSONStr+"}";
    console.log("jsonStr>>>>"+jsonStr);
    return jsonStr;
}

//根据输入公司名获取公司的历史价格数组
// function getPriceByCname(cname,dataJson){
//     var ret = [];
//     var len = Object.keys(dataJson).length;
//     console.log("dataJson:"+dataJson);
//
//     for (var i = 0; i < len; i++) {
//         // alert(JSON.stringify(dataJson));
//         if (dataJson[i]) {
//
//             // alert("dataJson[i][cname]:"+dataJson[i][cname]);
//         }
//     }
//     // }
//     return ret;
//
// }

//根据传入的json数据,
// function getArrByName(name,json){
//     var b = json.hasOwnProperty(name);
//     console.log("b:>>>"+b);
//     return b;
// }

/*size:需要设定几个. typeIn:line,row?*/
function getSeriesContent(size,typeIn){
    var contentArr = [];
    for(var i=0;i<size;i++){
        contentArr.push({type: typeIn});
    }
    console.log("contentArr:"+contentArr);
    return contentArr;
}