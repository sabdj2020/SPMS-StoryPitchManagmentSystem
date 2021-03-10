let baseUrl = '/Project1SPMS';
let nav = document.getElementById('navBar');
let loggedUser = null;
checkLogin();
setNav();

function setNav() {
    nav.innerHTML = `
            <a href="index.html"><strong>SPMS</strong></a>`;
    if ((loggedUser) && (loggedUser.role.name === 'Author')) {
        nav.innerHTML += `
        <a href="addPitch.html">Create a new Pitch</a>    
        <a href="myStories.html">My Stories</a>
        <div style="color:yellow">Number of Points: <br> ${100-loggedUser.numPts}</div>
            <span>
                
                <a href="profile.html">Welcome ${loggedUser.username}&nbsp;</a>
                <button  id="logoutBtn" type="button" class="btn btn-danger"> Sign Out</button>
            </span>
        `;
    } else {
        nav.innerHTML += `
        <a href="addPitch.html">View Approuved Pitches</a>    
        <a href="manageStories.html">Manage Pitches</a>
            <span>
                <a href="profile.html">${loggedUser.username}&nbsp;</a>
                <button type="button" id="logoutBtn">Sign Out</button>
            </span>
        `;

    }

    let logoutBtn = document.getElementById('logoutBtn');
    if (loggedUser) logoutBtn.onclick = logout;
}


async function logout() {
    let url = baseUrl + '/user';
    let response = await fetch(url, {method:'DELETE'});

    if (response.status != 200) {
        console.log('Something went wrong.');
    }
    loggedUser = null;
    window.location.href = "index.html";}

async function checkLogin() {
    let url = baseUrl + '/user';
    let response = await fetch(url);
    if (response.status === 200) loggedUser = await response.json();
    console.log(loggedUser);
    setNav();
}