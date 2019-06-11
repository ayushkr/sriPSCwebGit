// item{name:"url" ,selector:"commonArea" }
var ayrender = function (item) {

    $.get(item.name, function (data, status) {
        // console.log("jsrender "+JSON.stringify(data));
        rend(data);
    });

    var rend = function (tmplData) {
        // console.log("got tmplData"+JSON.stringify(tmplData));
        // console.log("name=" + item.name);
        // console.log("SELECTOR " + item.selector);
        // console.log("data" + JSON.stringify(item.data));
        $.templates({tmpl: tmplData});

        $(item.selector).html($.render.tmpl(item.data));
    };


}

var link_ay = function (templateBody, item) {
    // console.log("templateBody---->  \n"+templateBody);
    // console.log("item.data ---> \n " + JSON.stringify(item.data));
    console.log("item.selector --->  " + item.selector);

    var templateObj = $.templates(templateBody);
    //    console.log("templateObj=",templateObj);
    templateObj.link("#" + item.selector, item.data);
//    console.log('link_ay finish');
    try {
        afterLinking();
    } catch (err) {
//        console.log('afterLinking nt available here');
    }

};

var templateBodyG = "";

var aylinker = function (item) {
//    console.log('aylinker');


    $.get(item.urlOfTemplate,
            function (templateBody, status) {
                //console.log("item.urlOfTemplate ---> \n" + item.urlOfTemplate);
                templateBodyG = templateBody;
                link_ay(templateBodyG, item);
            },
            );

//    console.log('aylinker end');





}
