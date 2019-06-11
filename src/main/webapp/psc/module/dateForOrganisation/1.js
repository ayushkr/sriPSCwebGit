
    var dateStr;
    var dateJSON = {year: 2000, month: 1, day: 1};
    dateJSON = getTodayJSON();
    //  alert(" dateJSON=getTodayJSON();"+dateJSON);
    displayCalendar(dateJSON);

    // var day_selected=1;
    function daySel(d) {
        console.log("day set d" + d);
        dateJSON.day = d;
        recalculateDate();
        date_selection_finished(dateStr);
    }

    function recalculateDate() {

        var month_val = $("#combo_month").val();
        var year_val = $("#combo_year").val();
        dateJSON.year = year_val;
        dateJSON.month = month_val;
        // dateJSON.day=day_selected;
        console.log("recalculateDate() day set dateJSON.day" + dateJSON.day);
        console.log("date =" + getDateDashed(dateJSON));
        $("#cal_input_date").val(getDateDashed(dateJSON));

        displayCalendar(dateJSON);

    }

    function getTodayJSON() {
        var dateNow = new Date();
        dateJSON = {year: dateNow.getFullYear(), month: dateNow.getMonth() + 1, day: dateNow.getDate()};
        $("#combo_month").val(dateJSON.month);
        $("#combo_year").val(dateJSON.year);
        console.log("getTodayJSON = " + JSON.stringify(dateJSON));
        recalculateDate();
        return dateJSON;
    }

    function getDateDashed(dateJSON) {

        console.log("date dashed = " + JSON.stringify(dateJSON));
        var day_str = "0";
        if (dateJSON.day < 10) {
            day_str = "0" + dateJSON.day;
        } else {

            day_str = "" + dateJSON.day;
        }

        var month_str = "";
        if (dateJSON.month < 10) {
            month_str = "0" + dateJSON.month;
        } else {
            month_str = "" + dateJSON.month + "";
        }

        //dateStr = "" + dateJSON.year + "-" + month_str + "-" + day_str;
        dateStr = "" + day_str + "-" + month_str + "-" + dateJSON.year;
        return dateStr;
    }




    function displayCalendar(dateJSON) {


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
                htmlContent += "<td " + handle1 + " class='dayNow'  onMouseOver='this.style.background=\"#FF0000\"; this.style.color=\"#FFFFFF\"' " +
                        "onMouseOut='this.style.background=\"#FFFFFF\"; this.style.color=\"#00FF00\"'>" + counter + "</td>";
            } else {
                htmlContent += "<td " + handle1 + " class='monthNow' onMouseOver='this.style.background=\"#FF0000\"'" +
                        " onMouseOut='this.style.background=\"#FFFFFF\"'>" + counter + "</td>";

            }

            weekdays2++;
            counter++;
        }


        // building the calendar html body.
        var calendarBody = "<table class='calendar'> <tr class='monthNow'><th colspan='7'>"
                + monthNames[month] + " " + year + "</th></tr>";
        calendarBody += "<tr class='dayNames'>  <td>Sun</td>  <td>Mon</td> <td>Tue</td>" +
                "<td>Wed</td> <td>Thu</td> <td>Fri</td> <td>Sat</td> </tr>";
        calendarBody += "<tr>";
        calendarBody += htmlContent;
        calendarBody += "</tr></table>";
        // set the content of div .
        document.getElementById("calendar").innerHTML = calendarBody;

    }
