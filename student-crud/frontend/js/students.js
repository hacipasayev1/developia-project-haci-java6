var selectedStudentId=0;
var API_URL="http://localhost:8585";
var studentNameInput=document.getElementById('student-name');
var studentSurnameInput=document.getElementById('student-surname');
var studentsTbodyElement = document.getElementById('students-tbody');
var headerTextElement= document.getElementById('header-text');
var nameErrorElement=document.getElementById('name-error');
var surnameErrorElement=document.getElementById('surname-error');
function onSaveStudent(event) {
    event.preventDefault();
    var studentName = studentNameInput.value;
    var studentSurname =studentSurnameInput.value;

    var studentObject = {};
    studentObject.id=selectedStudentId;
    studentObject.name = studentName;
    studentObject.surname = studentSurname;
    var http = new XMLHttpRequest();
    http.onload = function () {
        if(this.status==400){
            var nameError="";
            var surnameError="";
            var errorObject=JSON.parse(this.responseText);
            errorObject.validations.forEach(error => {
                if(error.field=='name'){
                  
                   nameError+=error.message+"<br>";
                }
                if(error.field=='surname'){
                    surnameError+=error.message+"<br>";
  
                }
                
            });
             nameErrorElement.innerHTML=nameError;
             surnameErrorElement.innerHTML=surnameError;
        }else{
            clearErrorMessages();
            selectedStudentId=0;
            setHeaderText('Yeni tələbə qeydiyyatı');
    
            loadAllStudents();
        }
        
    }
    http.open("POST",API_URL+ "/students", true);
    http.setRequestHeader("Content-type", "application/json");
    http.send(JSON.stringify(studentObject));
}
function loadAllStudents() {
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var studentsArray = JSON.parse(response);
        fillStudentsTable(studentsArray);
    }
    http.open("GET", API_URL+"/students", true);
    http.send();
}
function fillStudentsTable(students) {
    var studentsTbodyElement = document.getElementById('students-tbody');
    var studentsTbodyHtml = "";
    for (var i = 0; i < students.length; i++) {
        var student = students[i];
        studentsTbodyHtml += "<tr><td>" + student.id + "</td>";
        studentsTbodyHtml += "<td>" + student.name + "</td>";
        studentsTbodyHtml += "<td>" + student.surname + "</td>";

        studentsTbodyHtml += "<td><button class='btn btn-danger' onclick='onDeleteStudent(" + student.id + ")'>Sil</button> ";
        studentsTbodyHtml += "<button class='btn btn-primary' onclick='onEditStudent(" + student.id + ")'>Redakte</button></td></tr>";
    }
    studentsTbodyElement.innerHTML = studentsTbodyHtml;
}
loadAllStudents();
function onDeleteStudent(studentId) {
    if(confirm('silmeye eminsiniz?')){
    var http = new XMLHttpRequest();
    http.onload = function () {
        loadAllStudents();
    }
    http.open("DELETE", API_URL+"/students/" + studentId, true);
    http.send();
}
}
function onEditStudent(studentId){
    selectedStudentId=studentId;
    setHeaderText('Tələbə redaktəsi, id='+studentId);
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response=this.responseText;
        var studentObject=JSON.parse(response);
        studentNameInput.value=studentObject.name;
        studentSurnameInput.value=studentObject.surname;
    }
    http.open("GET", API_URL+"/students/" + studentId, true);
    http.send();
}
function setHeaderText(text){
   headerTextElement.innerHTML=text;
}
setHeaderText('Yeni tələbə qeydiyyatı');
function clearErrorMessages(){
    nameErrorElement.innerHTML="";
    surnameErrorElement.innerHTML="";
}
