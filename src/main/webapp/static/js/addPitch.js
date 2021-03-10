checkLogin().then(getGenresTypes);

async function getGenresTypes() {
  let url = baseUrl + '/type';
  let response = await fetch(url);

  let url2 = baseUrl + '/genre';
  let response2 = await fetch(url2);

  if ((response.status === 200)&&(response2.status === 200)) {
      let sTypes = await response.json();
      let sGenres = await response2.json();
      console.log(sTypes);
      console.log(sGenres);
      
      addStories(sTypes, sGenres)
  }
}



function addStories(sTypes, sGenres) {
    let addSection = document.getElementById('addSection');

    addSection.innerHTML += `<form>
    <div class="form-group">
      <input type="text" class="form-control" id="title" placeholder="Enter the Story Title">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" id="desc" placeholder="Enter the Description">
    </div>
  <div class="form-group">
      <input type="email" class="form-control" id="tl" placeholder="Enter the Tag Line">
    </div>

   
    <select class="custom-select my-1 mr-sm-2" id="st">
    <option selected>Select One Story Type</option>`;
    for (let t of sTypes) {
      let sel= document.getElementById('st');
    sel.innerHTML +=`
    <option value=${t.id}> ${t.name}</option>
    `;

  }
  addSection.innerHTML +=`</select>
  
  
    <select class="custom-select my-1 mr-sm-2" id="sg" >
    <option selected>Select One</option>`;

    for (let g of sGenres) {
      let sel= document.getElementById('sg');
    sel.innerHTML +=`
    <option value=${g.id}> ${g.name}</option>
    `;

  }

  addSection.innerHTML +=`</select>
    
    <button type="button" class="btn btn-danger" id ="submitStory" onclick="add()">Submit</button>
  </form>
        `;
        
        let submitAddBtn = document.getElementById('submitStory');
        submitAddBtn.onclick = add;
    
}
async function add() {

  let date=new Date();
    let story = {};

    story.id= 0,
    story.title= document.getElementById('title').value;
    story.description= document.getElementById('desc').value;
    story.tagLine = document.getElementById('tl').value;
    story.date= date.getDate;
    story.attachment= null;
    story.priority= 2;
    story.draft= null;
    story.sg= {};
    story.sg.id = 0;
    story.sg.name = document.getElementById('sg').value;
    story.st= {};
    story.st.id = 0;
    story.st.name = document.getElementById('st').value;
    story.st.weight=0;
    story.ss= {};
    story.ss.id = 1;
    story.ss.name = '';
    story.pAuthor= {};
    story.pAuthor.id = loggedUser.id;
    story.pAuthor.role = loggedUser.role;
    story.pReview1=null;
    story.pReview2=null;
    story.pReview3=null;
  
    let url = baseUrl + '/story';
    let response = await fetch(url, {method:'POST', body:JSON.stringify(story)});
    console.log(response);

    
    if (response.status === 201) {
        alert('Added story successfully.');
    } else {
        alert('Something went wrong.');
    }
}


