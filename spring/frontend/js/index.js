//ajax vasitesile backend serverden json melumatlari getirmek
//json melumati javascript obyektine cevirmek
//obyektin daxilinde olan melumatlari html fayldaki table-a yazdirmaq

function addStudents(students){
var tbody=document.getElementById('students-tbody');

var htmlText='';
students.forEach(s => {
    htmlText+='<tr><td>'+s.id+'</td>';
    htmlText+='<td>'+s.name+'</td>';
    htmlText+='<td>'+s.surname+'</td>';
    htmlText+='<td>'+s.phone+'</td>';
    htmlText+='<td>'+s.email+'</td>';
    htmlText+='<td>'+s.address+'</td>';
    htmlText+='<td>'+s.sector+'</td>';
    htmlText+='<td>'+s.birthday+'</td>';
    htmlText+='<td><button>Sil</button></td></tr>';

});
tbody.innerHTML=htmlText;
}
function loadStudents(){
    var http=new XMLHttpRequest();
    http.open('GET','http://localhost:7777/students',true);
    http.onload= function(){
        var resp=this.responseText;
        var objects=JSON.parse(resp);
        addStudents(objects);
        console.log(objects);
    }
    http.send();
    
}

loadStudents();

function onSave(event){
    event.preventDefault();
var name=document.getElementById('student-name').value;
var surname=document.getElementById('student-surname').value;
var studentobj={};
studentobj.name=name;
studentobj.surname=surname;

var http=new XMLHttpRequest();
    http.open('POST','http://localhost:7777/students',true);
    http.onload= function(){
        var resp=this.responseText;
        var object=JSON.parse(resp);
        addSingleStudent(object);

    }
    http.setRequestHeader('Content-type', 'application/json');
    http.send(JSON.stringify(studentobj));
}

function addSingleStudent(s){
    var tbody=document.getElementById('students-tbody');

    var htmlText='';
    htmlText+='<tr><td>'+s.id+'</td>';
    htmlText+='<td>'+s.name+'</td>';
    htmlText+='<td>'+s.surname+'</td>';
    htmlText+='<td>'+s.phone+'</td>';
    htmlText+='<td>'+s.email+'</td>';
    htmlText+='<td>'+s.address+'</td>';
    htmlText+='<td>'+s.sector+'</td>';
    htmlText+='<td>'+s.birthday+'</td>';
    htmlText+='<td><button>Sil</button></td></tr>';

tbody.innerHTML+=htmlText;

}