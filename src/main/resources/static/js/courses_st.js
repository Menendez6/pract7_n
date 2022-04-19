const table = document.getElementById("tabla");


async function mostrarStudents(){

    fetch("/api/courses/all2") //Devuelve una promise
            .then(response =>  response.json())
            .then(data => {
                console.log(data)
                /*if(data.error){
                    document.querySelector('h1').innerHTML = "Not found";
                    return;
                }*/
                


                //Miramos a ver si hay más páginas antes o después de la actual
                
                for(let i = 0;i<data.length;i++){
                    
                    // Create an empty <tr> element and add it to the last position of the table:
                    var row = table.insertRow();

                    // Insert new cells (<td> elements) of the "new" <tr> element:
                    var cell1 = row.insertCell(0);
                    cell1.classList.add('align-middle');
                    var cell2 = row.insertCell(1);
                    cell2.classList.add('align-middle');
                    var cell3 = row.insertCell(2);
                    cell3.classList.add('align-middle');
                    var cell4 = row.insertCell(3);
                    cell4.classList.add('align-middle');
                    var cell5 = row.insertCell(4);
                    cell5.classList.add('align-middle');
                    
                    

                    // Add some text to the new cells:
                    
                    cell1.innerHTML = data[i].courseName;
                    cell2.innerHTML = data[i].semester;
                    cell3.innerHTML = data[i].degree;
                    cell4.innerHTML = data[i].customerName;
                    cell5.innerHTML = data[i].customerEmail;

                }

        })
    
}


document.addEventListener('DOMContentLoaded',mostrarStudents())