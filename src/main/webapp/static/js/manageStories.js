checkLogin().then(getPitches);

async function getPitches() {
    let url = baseUrl + '/story';
    let response = await fetch(url);
    if (response.status === 200) {
        let stories = await response.json();
        console.log(stories);
        populatePitches(stories);
    }
}

function populatePitches(stories) {
    let storySection = document.getElementById('storySection');
    storySection.innerHTML = '';

    if (stories.length > 0) {
        let table = document.createElement('table');
        table.style.width='100%';
        table.style.color='black';
        table.style.border='1px solid black';
        table.id = 'storyTable';

        table.innerHTML = `
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Tag Line</th>
            </tr>
        `;

        for (let s of stories) {
            let tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${s.id}</td>
                <td>${s.title}</td>
                <td>${s.description}</td>
                <td>${s.tagline}</td>

            `;
            let td = document.createElement('td');
            let ul = document.createElement('ul');
            
            td.appendChild(ul);
            tr.appendChild(td);

            let approuveBtn = document.createElement('button');
            approuveBtn.type = 'button';
            approuveBtn.textContent = 'Approuve';
            approuveBtn.style.backgroundColor='green';

            let rejectBtn = document.createElement('button');
            rejectBtn.type = 'button';
            rejectBtn.textContent = 'Reject';
            rejectBtn.style.backgroundColor='red';


            let infoBtn = document.createElement('button');
            infoBtn.type = 'button';
            infoBtn.textContent = 'Ask the Author';
            infoBtn.style.backgroundColor='yellow';
            
            // <button type="button" id="Howard_6"
            //  disabled="false">Adopt</button>
            
            let btnTd = document.createElement('td');
            btnTd.appendChild(approuveBtn);
            btnTd.appendChild(rejectBtn);
            btnTd.appendChild(infoBtn);
            tr.appendChild(btnTd);
            table.appendChild(tr);
            
            approuveBtn.addEventListener('click', approuveStory);
            rejectBtn.addEventListener('click', rejectStory);
        }

        storySection.appendChild(table);
    } else {
        storySection.innerHTML = 'No story to manage.';
    }
}

async function approuveStory() {
    let btnId = event.target.id;
    let index = btnId.indexOf('_'); // find underscore (see line 46)
    let id = btnId.slice(index+1); // get text after underscore
    let name = btnId.replace('_', ''); // remove underscore
    if (confirm('You want to approuve ' + title + '?')) {
        let url = baseUrl + '/story/approuve/' + id;
        let response = await fetch(url, {method:'PUT'});
        switch (response.status) {
            case 200:
                alert('You approuved ' + name + '!');
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


async function rejectStory() {
    let btnId = event.target.id;
    let index = btnId.indexOf('_'); // find underscore (see line 46)
    let id = btnId.slice(index+1); // get text after underscore
    let name = btnId.replace('_', ''); // remove underscore
    if (confirm('You want to reject ' + title + '?')) {
        let url = baseUrl + '/story/reject/' + id;
        let response = await fetch(url, {method:'PUT'});
        switch (response.status) {
            case 200:
                alert('You rejected ' + name + '!');
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
