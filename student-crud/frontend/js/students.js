var selectedStudentId = 0;
var API_URL = "http://localhost:8585";
var username=localStorage.getItem('username');
var password=localStorage.getItem('password');
var token="Basic "+window.btoa(username+":"+password);
var gridOptionsGlobal;
var studentNameInput = document.getElementById('student-name');
var studentSurnameInput = document.getElementById('student-surname');
var studentProfilePhotoInput = document.getElementById('student-photo');
var studentsTbodyElement = document.getElementById('students-tbody');
var notesTbodyElement = document.getElementById('notes-tbody');

var headerTextElement = document.getElementById('header-text');
var nameErrorElement = document.getElementById('name-error');
var surnameErrorElement = document.getElementById('surname-error');
var studentNoteInput = document.getElementById('student-note');


async function onSaveStudent(event) {
    event.preventDefault();
    let formData=new FormData();
    let photo=studentProfilePhotoInput.files[0];

    formData.append("file",photo);
    let response=await fetch(API_URL+'/files/upload',{
        method:"POST",
        body:formData,
        headers:{
            "Authorization":token
        }
    });
  var photoName=await response.json();
  saveStudent(photoName.fileName);
}
function loadAllStudents() {
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var studentsArray = JSON.parse(response);
        fillStudentsTable(studentsArray);
    }
    http.open("GET", API_URL + "/students", true);
    http.setRequestHeader("Authorization", token);
    http.send();
}
function fillStudentsTable(students) {
    gridOptionsGlobal.api.setRowData(students);
}

function onDeleteStudent(studentId) {
    if (confirm('silmeye eminsiniz?')) {
        var http = new XMLHttpRequest();
        http.onload = function () {
            loadAllStudents();
        }
        http.open("DELETE", API_URL + "/students/" + studentId, true);
        http.setRequestHeader("Authorization", token);
        http.send();
    }
}
function onEditStudent(studentId) {
    selectedStudentId = studentId;
    setHeaderText('Tələbə redaktəsi, id=' + studentId);
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var studentObject = JSON.parse(response);
        studentNameInput.value = studentObject.name;
        studentSurnameInput.value = studentObject.surname;
    }
    http.open("GET", API_URL + "/students/" + studentId, true);
    http.setRequestHeader("Authorization", token);
    http.send();
}
function setHeaderText(text) {
    headerTextElement.innerHTML = text;
}
setHeaderText('Yeni tələbə qeydiyyatı');
function clearErrorMessages() {
    nameErrorElement.innerHTML = "";
    surnameErrorElement.innerHTML = "";
}
function onNoteStudent(studentId) {
    selectedStudentId = studentId;

}

function onSaveStudentNote(event) {
    event.preventDefault();
    var studentNote = studentNoteInput.value;

    var studentNoteObject = {};
    studentNoteObject.note = studentNote;
    studentNoteObject.studentId = selectedStudentId;
    var http = new XMLHttpRequest();
    http.onload = function () {
        if (this.status == 400) {
            alert('Qeyd əlavə edilə bilmədi!');

        } else {

            alert('Qeyd əlavə edildi');
        }

    }
    http.open("POST", API_URL + "/student-notes", true);
    http.setRequestHeader("Content-type", "application/json");
    http.setRequestHeader("Authorization", token);
    http.send(JSON.stringify(studentNoteObject));
}

function onShowStudentNotes(studentId) {
loadAllStudentNotes(studentId);
}


function fillStudentNotesTable(notes) {

    var notesTbodyHtml = "";
    for (var i = 0; i < notes.length; i++) {
        var note = notes[i];
        notesTbodyHtml += "<tr><td>" + note.id + "</td>";
        notesTbodyHtml += "<td>" + note.note + "</td>";

        notesTbodyHtml += "</tr>";

    }
    notesTbodyElement.innerHTML = notesTbodyHtml;
}


function loadAllStudentNotes(studentId) {
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var notesArray = JSON.parse(response);
        fillStudentNotesTable(notesArray);
    }
    http.open("GET", API_URL + "/student-notes/student/"+studentId, true);
    http.setRequestHeader("Authorization", token);
    http.send();
}


function prepareAgGridTable(){
    const columnDefs = [
        { field: "id",headerName:"Kod"},
        { field: "name",headerName:"Ad" },
        { field: "surname",headerName:"Soyad" }
      ];
      
      
      
      // let the grid know which columns and what data to use
      const gridOptions = {
        columnDefs: columnDefs,
        rowData: [],
        defaultColDef:{sortable:true,filter:true},
        animateRows:true,
        floatingFilter:true,
        pagination:true,
        rowSelection:'multiple'
      };
      gridOptionsGlobal=gridOptions;
      
      // setup the grid after the page has finished loading
      document.addEventListener('DOMContentLoaded', () => {
          const gridDiv = document.querySelector('#myStudents');
          new agGrid.Grid(gridDiv, gridOptions);
      });
      
}
prepareAgGridTable();
loadAllStudents();

function saveStudent(photo){
    var studentName = studentNameInput.value;
    var studentSurname = studentSurnameInput.value;

    var studentObject = {};
    studentObject.id = selectedStudentId;
    studentObject.name = studentName;
    studentObject.surname = studentSurname;
    studentObject.profilePhoto=photo;
    var http = new XMLHttpRequest();
    http.onload = function () {
        if (this.status == 400) {
            var nameError = "";
            var surnameError = "";
            var errorObject = JSON.parse(this.responseText);
            errorObject.validations.forEach(error => {
                if (error.field == 'name') {

                    nameError += error.message + "<br>";
                }
                if (error.field == 'surname') {
                    surnameError += error.message + "<br>";

                }

            });
            nameErrorElement.innerHTML = nameError;
            surnameErrorElement.innerHTML = surnameError;
        } else {
            clearErrorMessages();
            selectedStudentId = 0;
            setHeaderText('Yeni tələbə qeydiyyatı');

            loadAllStudents();
        }

    }
    http.open("POST", API_URL + "/students", true);
    http.setRequestHeader("Content-type", "application/json");
    http.setRequestHeader("Authorization", token);
    http.send(JSON.stringify(studentObject));
}

function onShowImage(){
    var selectedStudents=gridOptionsGlobal.api.getSelectedRows();
    console.log(selectedStudents[0]);
    document.getElementById('student-image').src=API_URL+"/files/download/"+ selectedStudents[0].profilePhoto;
}