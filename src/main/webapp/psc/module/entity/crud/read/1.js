//  /entity/crud/read/1.js

var path = "/clinicPlus/api/" + mn.module.current + "/" + mn.module[mn.module.current].id;
console.log("entity/read/view path " + path);
if(mn.module.current!==undefined){
$.get(path, function (result) {
    console.log("result=" + JSON.stringify(result));

    result.json = JSON.stringify(result, null, 2);
    mn.module[mn.module.current] = result;
    aylinker({
        urlOfTemplate: "/clinicPlus/module/" + mn.module.current + "/read.html?ran=" + Math.random(),
        selector: "entity_read_view",
        data: result
    }
    );
});
}

//////////////////////////////////
function goto_update() {
    var path = '#/cmdc?module=entity&action=/crud/update&id=' + mn.module[mn.module.current].id + pageNewAy(1);
    console.log("goto_create path=" + path);
    window.location.href = path;
}

function goto_list() {
    var path = '#/cmdc?module=' + mn.module.current + '&action=/all/list' + pageNewAy(1);
    console.log("goto_list path=" + path);
    window.location.href = path;
}


function goto_delete() {
    var path = '#/cmdc?module=entity&action=/crud/delete&id=' + mn.module[mn.module.current].id + pageNewAy(1);
    console.log("goto_create path=" + path);
    window.location.href = path;
}
