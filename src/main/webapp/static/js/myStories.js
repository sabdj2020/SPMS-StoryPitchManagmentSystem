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
           

            
            // <button type="button" id="Howard_6"
            //  disabled="false">Adopt</button>
            
            
            table.appendChild(tr);
            
        }

        storySection.appendChild(table);
    } else {
        storySection.innerHTML = 'No story to manage.';
    }
}

