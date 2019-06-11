//   /dashboard/helper_for_controller


var mn = {
    a: 3,
    b: 4,
    jserror: '',
    appointment: {
        patient: {id: "", name: ""},
        doctor: {id: "", name: ""},
        date: ""
    },
    doctor: {},
    patient: {},
    medicineBrandName: {},
    module: ["a", "b"]

};



$.views.helpers(
        {
            pageNewAy: function (status) {
                if (status === 1) {
                    return "&refreshId=" + Math.random();
                } else {
                    return "?refreshId=0";
                }

            },
            expiryFormat1: function expiryFormat1(yyyy_mm_dd) {
                var dparts = yyyy_mm_dd.split("-");
                console.log(dparts);
                return dparts[0] + "-" + dparts[1];
            }
            ,

            listFiles: listFiles
            ,

            jsonise: jsonise
            ,

            ayLoad: ayLoad
            ,
            ckeditor_activate: ckeditor_activate,
            ckeditor_save: ckeditor_save,
            setABCD: setABCD,

            utilities: {
                maxCount: 23,
                subtractMax: function (val) {
                    return val - this.maxCount;
                },
                errorMessages: {
                    msg1: "not available"
                },
                alert2: function (val) {
                    alert('hai2');
                }

            }

        });

function setABCD(v) {
   
      console.log('setABCD ='+v);
    document.getElementById('answer').value = v;
    document.getElementById('abcd_A').style = 'background-color:green';
    document.getElementById('abcd_B').style = 'background-color:green';
    document.getElementById('abcd_C').style = 'background-color:green';
    document.getElementById('abcd_D').style = 'background-color:green';
    document.getElementById('abcd_' + v).style = 'background-color:red';
}

function ckeditor_activate() {
    console.log('ckeditor_activated');
    CKEDITOR.replace('myEditor',
            {
                fullPage: true,
                height: '800px',
                uiColor: '#efe8ce'
            });
    var myEditorSpanDiv = document.getElementById('myEditor_span');
    myEditorSpanDiv.style = 'display:none';

}



function ckeditor_save() {
    if (1 == 0) {
        var editorContent = CKEDITOR.instances['myEditor'].getData();
        var myEditorDiv = document.getElementById('myEditor');
        myEditorDiv.value = editorContent;
        console.log('editorContent=' + editorContent);
    }

    save('question');
}

function ayLoad(url) {
    $.get(url, function (result) {
        console.log('ayLoad url=' + url);
    });

}
function listFiles(patientId, category, div) {
    var dataGot;

    var result = "";
    $.ajax({
        async: false,
        url: '/clinicPlus/api/fileStore/folder/patient.' + patientId + "." + category,
        type: 'GET',
        success: function (fullJson) {
            console.log("listFiles success JSON.stringify(fullJson)=" + JSON.stringify(fullJson));
            dataGot = fullJson;

            for (var a  in dataGot) {
                console.log('a.path=' + dataGot[a].path);
                if (dataGot[a].fileType === 'jpeg') {
                    result += "<img width='150px' style='padding:10px' src='" + dataGot[a].path + "'> ";

                } else {
                    result += "<a target='_blank' href='" + dataGot[a].path + "'>" + dataGot[a].name + " </a><br>";

                }
            }


            var divElement = document.getElementById(div);
            if (divElement !== null) {
                divElement.innerHTML = result;
            }

        }


    });






    return dataGot;
}

function jsonise(o) {
    return JSON.stringify(o);
}

function pageNewAy(status) {
    if (status === 1) {
        return "&refreshId=" + Math.random();
    } else {
        return "?refreshId=0";
    }

}








mn.module['question_new'] = {
    "name": '',
    "answer": '',
    "myEditor": '',
    "id": 0
};





