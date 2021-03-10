let addstoryMenuOpen = false;
setup();

function setup() {
    getStories().then(() => {
        checkLogin().then(() => {
            if (loggedUser.role.name === 'Assistant Editor') committeeSetup();
        });
    });
}

async function getStories() {
    let url = baseUrl + '/story';
    let response = await fetch(url);
    if (response.status === 200) {
        let stories = await response.json();
        populateCats(stories);
    }
}

function populateStories(stories) {
    let storySection = document.getElementById('storySection');
    storySection.innerHTML = '';

    if (stories.length > 0) {
        let table = document.createElement('table');
        table.id = 'storyTable';

        table.innerHTML = `
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        `;

        for (let s of stories) {
            let tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${s.id}</td>
                <td>${s.title}</td>
                <td>${s.description}</td>
            `;
            
            tr.appendChild(td);

            let approuveBtn = document.createElement('button');
            approuveBtn.type = 'button';
            approuveBtn.id = s.title + '_' + s.id;
            approuveBtn.textContent = 'Approuve';
            approuveBtn.disabled = !loggedUser;
            // <button type="button" id="Howard_6"
            //  disabled="false">Adopt</button>
            
            let btnTd = document.createElement('td');
            btnTd.appendChild(approuveBtn);
            tr.appendChild(btnTd);
            table.appendChild(tr);
            
            adoptBtn.addEventListener('click', approuveStory);
        }

        catSection.appendChild(table);
    } else {
        catSection.innerHTML = 'No cats are available.';
    }
}

async function approuveStory() {
    let btnId = event.target.id;
    let index = btnId.indexOf('_'); // find underscore (see line 46)
    let id = btnId.slice(index+1); // get text after underscore
    let name = btnId.replace('_', ''); // remove underscore
    if (confirm('You want to approuve ' + title + '?')) {
        let url = baseUrl + '/s/approuve/' + id;
        let response = await fetch(url, {method:'PUT'});
        switch (response.status) {
            case 200:
                alert('You approuved ' + title + '!');
                break;
            case 409:
                alert('That story doesn\'t seem to exist...');
                break;
            case 401:
                alert('Hold on, you\'re not logged in!');
                break;
            default:
                alert('Something went wrong.');
                break;
        }
    }
}

function committeeSetup() {
    let committeeSpan = document.getElementById('com');
    employeeSpan.removeAttribute('hidden');
    // add story
    if (!(document.getElementById('addStoryBtn'))) {
        let addStoryBtn = document.createElement('button');
        addStoryBtn.type = 'button';
        addStoryBtn.textContent = 'Add Story';
        addStoryBtn.id = 'addStoryBtn';
        addStoryBtn.onclick = addStoryMenu;
        committeeSpan.appendChild(addStoryBtn);
    }

    // edit cat
    let storiesTable = document.getElementById('storyTable');
    for (let tr of storiesTable.childNodes) {
        if (tr.nodeName === 'TR') {
            let td = document.createElement('td');
            if (tr != catsTable.childNodes.item(0)) {
                let editBtn = document.createElement('button');
                editBtn.id = 'edit_' + tr.childNodes.item(1).textContent;
                editBtn.type = 'button';
                editBtn.textContent = 'Edit';
                editBtn.onclick = editCat;
                td.appendChild(editBtn);
            }
            tr.appendChild(td);
        }
    }
}

function addStoryMenu() {
    let committeeSpan = document.getElementById('com');
    addStoryMenuOpen = !addStoryMenuOpen;
    console.log('add story menu open? ' + addstoryMenuOpen);

    if (addstoryMenuOpen) {
        committeeSpan.innerHTML += `<form id="add-story-form">
        <label for="name">title:</label>
        <input type="text" id="title" placeholder="Title" required />
        
        <label for="age">Description:</label>
        <input type="text" id="des" placeholder="Description" required />
        
        <label for="breed">Tag-line:</label>
        <input type="text" id="tl" placeholder="Description" required />

        <button type="button" onclick="addStory()" id="submit-add-cat-form" >Submit</button>
        </form>
        `;
        
        let submitAddBtn = document.getElementById('submit-add-story-form');
        submitAddBtn.onclick = addStory;
    } else {
        committeeSpan.removeChild(document.getElementById('add-story-form'));
    }

    let addStoryBtn = document.getElementById('addStoryBtn');
    addStoryBtn.onclick = addStoryMenu;
}

function editStory() {
    let editBtn = event.target;
    let editId = event.target.id;
    let editTd = editBtn.parentElement;
    let editTr = editTd.parentElement;

    let nodes = editTr.childNodes;

    editTr.innerHTML = `
        <td>${nodes.item(1).innerHTML}</td>
        <td><input id = "eCName" type = "text" value = ${nodes.item(3).innerHTML}></td>
        <td><input id = "eCAge" type = "text" value = ${nodes.item(5).innerHTML}></td>
        <td>${nodes.item(7).innerHTML}</td>
        <td>${nodes.item(9).innerHTML}</td>
        <td><button disabled = 'true'>Adopt</button>
        <button id = ${editId}>Save</button></td>
        `;
    //<input id = "eCBreed" type = "text" value = ${nodes[3].innerHTML}>
    editBtn = document.getElementById(editId);
    editBtn.addEventListener('click', saveCat);

}

async function saveCat()
{
    let btnId = event.target.id;
    let index = btnId.indexOf('_');
    let id = btnId.slice(index+1); // get text after underscore

    let url = baseUrl + '/story/' + id;



    let response = await fetch(url);

    let cat = await response.json();

    cat.name = document.getElementById('eCName').value;
    cat.age = document.getElementById('eCAge').value;

    let newResponse = await fetch(url,{method:'PUT',body:JSON.stringify(cat)});
    if (newResponse.status === 200) {
        alert('Updated successfully.');
    } else {
        alert('Something went wrong.');
    }
    
    setup();
}

// async function populateBreeds() {
//     let breedDropDown = document.getElementById('breed');
//     let url = baseUrl + '/employee/breed';
//     let response = await fetch(url);
//     if (response.status === 200) {
//         let breeds = await response.json();
//         for (let breed of breeds) {
//             let breedOption = document.createElement('option');
//             breedOption.value = breed.id;
//             breedOption.textContent = breed.name;
//             breedDropDown.appendChild(breedOption);
//         }
//     } else {
//         alert('Something went wrong.');
//         addCatMenuOpen = true;
//         addCatMenu();
//     }
// }

