function includeHtml(divName,file) {
  var  xhttp;

var elem=document.getElementById(divName);

  elem.innerHTML ="trying...";

    if (file) {
      /* Make an HTTP request using the attribute value as the file name: */
      xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
          if (this.status == 200) {elem.innerHTML = this.responseText;}
          if (this.status == 404) {elem.innerHTML = "Page not found.";}
          
        }
      } 
      xhttp.open("GET", file+"?ran="+Math.random(), true);
      xhttp.send();
      /* Exit the function: */
      return;
    }
  
}