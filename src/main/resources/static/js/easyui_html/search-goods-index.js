
//弹出框内的逻辑操作
function checkboxOnClick(checkbox) {
    if (checkbox.checked) {
        appendChildAtInput(checkbox.name);
    } else {
        removeChildAtInput(checkbox.name);
    }
}

/*向div中input后添加子元素*/
function appendChildAtInput(name) {

    var childSelectL = document.createElement("select");
    childSelectL.id = name + "SelectL";
    childSelectL.class = "easyui-combobox";
    childSelectL.setAttribute("class", "easyui-combobox");

    var opt1 = new Option("＝", "＝");
    var opt2 = new Option("＜", "＜");
    var opt3 = new Option("≤", "≤");
    var opt4 = new Option("＞", "＞");
    var opt5 = new Option("≥", "≥");
    childSelectL.options.add(opt1);
    childSelectL.options.add(opt2);
    childSelectL.options.add(opt3);
    childSelectL.options.add(opt4);
    childSelectL.options.add(opt5);

    var childInputL = document.createElement("input");
    childInputL.type = "text";
    childInputL.id = name + "ChildL";
    childInputL.className = "easyui-textbox";
    childInputL.setAttribute("class", "easyui-textbox");
    childInputL.required = true;

    var childSelectR = document.createElement("select");
    childSelectR.id = name + "SelectR";
    childSelectR.class = "easyui-combobox";
    childSelectR.setAttribute("class", "easyui-combobox");
    var opt0 = new Option("", "");
    var opt1 = new Option("＝", "＝");
    var opt2 = new Option("＜", "＜");
    var opt3 = new Option("≤", "≤");
    var opt4 = new Option("＞", "＞");
    var opt5 = new Option("≥", "≥");
    childSelectR.options.add(opt0);
    childSelectR.options.add(opt1);
    childSelectR.options.add(opt2);
    childSelectR.options.add(opt3);
    childSelectR.options.add(opt4);
    childSelectR.options.add(opt5);
    //设定了左右两个select,之后需要再设定R的select变更选项时,出现inputR

    var childInputR = document.createElement("input");
    childInputR.type = "text";
    childInputR.className = "easyui-textbox";
    childInputR.setAttribute("class", "easyui-textbox");
    childInputR.id = name + "ChildR";

    document.getElementById(name + "Div").appendChild(childSelectL);
    document.getElementById(name + "Div").appendChild(childInputL);
    document.getElementById(name + "Div").appendChild(childSelectR);
    document.getElementById(name + "Div").appendChild(childInputR);

}

/*将div后的子元素移除*/
function removeChildAtInput(name) {
    document.getElementById(name + "Div").removeChild(document.getElementById(name + "SelectL"));
    document.getElementById(name + "Div").removeChild(document.getElementById(name + "ChildL"));
    document.getElementById(name + "Div").removeChild(document.getElementById(name + "SelectR"));
    document.getElementById(name + "Div").removeChild(document.getElementById(name + "ChildR"));
}
