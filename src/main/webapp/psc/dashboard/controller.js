
updateCurrentDate('dateCurrent');

function  routeFunctions() {
    console.log('sammy all ');
    this.debug = true;
    this.get('#/', function () {
        this.app.swap('Click form!');
    });
    this.get('#/file', file_i);
    this.get('#/cmd', cmd);
    this.get('#/dummy', dummy);
    this.post('#/cmd/post', cmd_post);
       this.post('#/postFile', postFile);


}
var module;
var id = 0;
var action;
var directUrl;
var pageNumber = 1;

// controller
(function ($) {
    console.log('sammy loaded ');
//var sammy_navbar = $.sammy('#navbar', routeFunctions);
    var sammy_main1 = $.sammy('#main1_inner', routeFunctions);
    var sammy_main2_inner = $.sammy('#main2_inner', routeFunctions);
    var sammy_main3_inner = $.sammy('#main3_inner', routeFunctions);





    $(function () {
        //sammy_navbar.run('#/');
        sammy_main1.run('#/');
        sammy_main2_inner.run('#/');
        sammy_main3_inner.run('#/');
    });
})(jQuery);


function postFile(context, data) {
    console.log("akr #/postFile=" + this);
}

function dummy(context) {
    console.log("dummy-----------");

}

function cmd(context) {
    console.log("cmd-----------");
    module = this.params['module'];
    action = this.params['action'];
    directUrl = this.params['directUrl'];

    if (this.params['pageNumber'] !== undefined) {
        pageNumber = this.params['pageNumber'];
    }
    if (pageNumber === undefined) {
        pageNumber = 1;
    }

    id = this.params['id'];
    console.log("___id=" + id);
    console.log("___module=" + module);
    console.log("___action=" + action);
    console.log("___directUrl=" + directUrl);

    mn.module[module] = {"id": id};
    mn.id = id;
    mn.module.current = module;
    mn.module.pageNumber = pageNumber;

    if (directUrl === undefined)
    {
    
        listAsPages(module, pageNumber, 'main1');
    } else
    {

    }

    // this.partial(partial_path);
}


function cmd_post(context, data) {
    console.log("akr #/cmd/post=" + this);
//                    alert('a data' + data);
    var module_direct = this.params['module_direct'];
    var redirect = this.params['redirect'];
    if (module_direct !== undefined) {
        module = module_direct;
    }
   
  

    if (module === "question") {
        var d = {
               "myEditor": this.params['myEditor'],
            "body": this.params['body'],
            "name": this.params['name'],
          "answer": this.params['answer'],
            "id": this.params['id']
        
        };
    } else

    if (module === "fileStore") {
        var d = {

            "title": this.params['title'],
            "status": this.params['status'],
            "id": this.params['id']

        };
    } else



    if (module === "fileStorage") {
        var d = {
            "file": this.params['file']
        };
    }



    var addOrDeleteFlag = this.params['addOrDeleteFlag'];

    //alert_1("addOrDeleteFlag=" + addOrDeleteFlag);

    if (addOrDeleteFlag === 'add')
    {
        //  alert_1("add",d);
        d.id = 0;
        d.rid = 0;

    } else
    {
        //  alert_1("edit",d);
    }
    console.log("akr api_Posting : " + JSON.stringify(d));
    $.post('/psc/api/' + module + '', d)
            .fail(
                    function (data)
                    {
                        console.log("error ay " + JSON.stringify(data));
                        alert_1('ERROR ', JSON.stringify(data), 'error');
                    }
            )
            .done(
                    function (data)
                    {
                        alert_1('OK', JSON.stringify(data), 'success');
                        mn.module[module] = data;
                        console.log("post.done module=" + module + ", data=" + JSON.stringify(data));

                        var path = "#/cmd?module=" + module + "&action=/all/list" + pageNewAy(1);
                        console.log('redirect to ' + path);
                        // window.location.href = path;
//                        if (redirect === undefined) {
//                           // window.location.href = path;
//                        } else {
//                            window.location.href = redirect+pageNewAy(1);
//
//                        }

                    }
            )
            ;
}

function file_i(context) {

    var path = this.params['path'];
    id = this.params['id'];

    mn.module[module] = {"id": id};
    mn.module.current = module;

    var partial_path = '/psc/' + path + '?' + pageNewAy(1);
    document.getElementById('main1_menu').innerHTML = "";

    console.log("#/file , partial=" + partial_path);
    this.partial(partial_path);
}

