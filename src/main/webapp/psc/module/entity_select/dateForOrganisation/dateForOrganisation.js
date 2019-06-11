// entity_select/dateForOrganisation/dateForOrganisation.js

var fieldName = "";
var dateStr;
var dateJSON = {year: 2000, month: 1, day: 1};
var guiControls = "";

function  calendarReload(){
dateJSON = getTodayJSON();
dateJSON = getGivenDate();
console.log(" dateJSON=getTodayJSON();" + JSON.stringify(dateJSON));
createMonthAndYearGUI();
displayCalendar(dateJSON);
}

function createMonthAndYearGUI() {
    var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    var gui_month = "<div style='background-color:white;'><select id='combo_month' onchange='inputChangedByUser()'>";
    for (var i = 0; i < 12; i++) {
        gui_month += "<option VALUE='" + i + "' >" + monthNames[i] + "</option>";
    }
    gui_month += "</select>";

    var gui_year = "<select id='combo_year' onchange='inputChangedByUser()'>";
    for (var i = 2016; i < 2025; i++) {
        gui_year += "<option VALUE='" + i + "' >" + i + "</option>";
    }
    gui_year += "</select>";

    var gui_todayButton = "<input id='input_button_today' onclick='getTodayJSON()' type='button' value='Show Today' >";



    guiControls = gui_month + "" + gui_year + "" + gui_todayButton + "</div>";

    return guiControls;
}
// var day_selected=1;
function daySel(d) {
    console.log("day set d" + d);
    dateJSON.day = d;
    inputChangedByUser();
//    date_selection_finished2(dateStr);
}

function dateFinalised(){
    dateStr=getDateDashed(dateJSON);
      date_selection_finished2(dateStr);
     document.getElementById('modalDate').style='display:none';
}

function inputChangedByUser() {

    var month_val = $("#combo_month").val();
    var year_val = $("#combo_year").val();

    dateJSON.year = year_val;
    dateJSON.month = month_val;
    console.log("from recalculateDate() , dateJSON =" + getDateDashed(dateJSON));
    $("#cal_input_date").val(getDateDashed(dateJSON));
    displayCalendar(dateJSON);
}

function getTodayJSON() {
    var dateNow = new Date();
    dateJSON = {year: dateNow.getFullYear(), month: dateNow.getMonth() + 1, day: dateNow.getDate()};
    console.log("getTodayJSON() dateJSON= " + JSON.stringify(dateJSON));
    $("#combo_month").val(dateJSON.month);
    $("#combo_year").val(dateJSON.year);
    console.log("getTodayJSON = " + JSON.stringify(dateJSON));
    displayCalendar(dateJSON);
    return dateJSON;
}
function getGivenDate(){
    var s="";
   
    var strDate=mn.module['select'].obj.value+'';
     console.log(" getGivenDate() input="+strDate);
    if(strDate!==''){
    var parts=strDate.split('-');
     dateJSON.year=Number(parts[0]);
     dateJSON.month=Number(parts[1]);
     dateJSON.day=Number(parts[2]);
 }else{
      dateJSON=  getTodayJSON();
 }
     $("#combo_month").val(dateJSON.month);
    $("#combo_year").val(dateJSON.year);
    displayCalendar(dateJSON);
     console.log(' got '+strDate+' is converted to json '+JSON.stringify(dateJSON));
    return dateJSON;
}
function getDateDashed(dateJSON) {

    console.log("before getDateDashed() dateJSON= " + JSON.stringify(dateJSON));
    var day_str = "0";
    dateStr = "" + dateJSON.year + "-" + twoDigitise(dateJSON.month) + "-" +twoDigitise(dateJSON.day);
    console.log("-------after getDateDashed() dateStr= " + day_str);
    return dateStr;
}

function displayCalendar(dateJSON) {
    console.log("displayCalendar()");

    var htmlContent = "";
    var FebNumberOfDays = "";
    var counter = 1;
    var month = dateJSON.month - 1;
    var nextMonth = month + 1; //+1; //Used to match up the current month with the correct start date.
    var prevMonth = month - 1;
    var day = dateJSON.day
    var year = dateJSON.year;
    //Determing if February (28,or 29)
    if (month == 1) {
        if ((year % 100 != 0) && (year % 4 == 0) || (year % 400 == 0)) {
            FebNumberOfDays = 29;
        } else {
            FebNumberOfDays = 28;
        }
    }


// names of months and week days.
    var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    var dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday"];
    var dayPerMonth = ["31", "" + FebNumberOfDays + "", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"]


// days in previous month and next one , and day of week.
    var nextDate = new Date(nextMonth + ' 1 ,' + year);
    var weekdays = nextDate.getDay();
    var weekdays2 = weekdays
    var numOfDays = dayPerMonth[month];
// this leave a white space for days of pervious month.
    while (weekdays > 0) {
        htmlContent += "<td class='monthPre'></td>";
        // used in next loop.
        weekdays--;
    }

// loop to build the calander body.
    while (counter <= numOfDays) {

// When to start new line.
        if (weekdays2 > 6) {
            weekdays2 = 0;
            htmlContent += "</tr><tr>";
        }


// if counter is current day.
// highlight current day using the CSS defined in header.
        var handle1 = "onclick='daySel(" + counter + ")' ";
        if (counter == day) {
            htmlContent += "<td " + handle1+" class='dayNow td' >"+ counter + "</td>";
        } else {
            htmlContent += "<td " + handle1+ " class='monthNow td' >" + counter + "</td>";
        }

        weekdays2++;
        counter++;
    }


// building the calendar html body.
    var calendarBody = "<table class='calendar'> <tr class='monthNow'><th colspan='7'>"
            + monthNames[month] + " " + year + "</th></tr>";
    calendarBody += "<tr class='dayNames'>  <td class='dayDiv td' style='background-color: #820606;'>Sun</td>  <td class='dayDiv td'>Mon</td> \n\
<td class='dayDiv td'>Tue</td>" +
            "<td class='dayDiv td'>Wed</td> <td class='dayDiv td'>Thu</td> <td class='dayDiv td'>Fri</td> <td class='dayDiv td'>Sat</td> </tr>";
    calendarBody += "<tr>";
    calendarBody += htmlContent;
    calendarBody += "</tr></table>";
// set the content of div .


    // console.log(guiControls+calendarBody);
    document.getElementById("calendar").innerHTML = calendarBody;
}
function date_selection_finished2(dateStr) {
    $("#" + mn.module['select'].obj.input).val(dateStr);
    $("#" + mn.module['select'].obj.input+"_display").html(dateStr);
    document.getElementById("modalDate").style = "display:none";
    console.log("date_selection_finished2  le input" + mn.module['select'].obj.input);
}

calendarReload();
document.getElementById('entity_select_closeButton_modalDate').style.display='none';