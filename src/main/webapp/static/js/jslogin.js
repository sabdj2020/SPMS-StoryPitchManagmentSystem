let baseUrl = '/Project1SPMS';
alert("Iam in jslogin");


    let loginBtn = document.getElementById('loginBtn');
    loginBtn.onclick = login;

    let registerBtn = document.getElementById('reg');
    registerBtn.onclick = register;




async function login() {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/user/login?';

    url += 'user=' + document.getElementById('user').value + '&';
    url += 'pass=' + document.getElementById('pass').value;
    let response = await fetch(url, {method: 'POST'});
    
    switch (response.status) {
        case 200: // successful
            loggedUser = await response.json();
            window.location.href = "index2.html";
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            document.getElementById('pass').value = '';
            break;
        case 404: // user not found
            alert('That user does not exist.');
            document.getElementById('user').value = '';
            document.getElementById('pass').value = '';
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}


async function register() {

    let person={}
    person.id=0;
    person.fName=document.getElementById('fn').value;
    person.lName=document.getElementById('ln').value;
    person.username=document.getElementById('username').value;
    person.password=document.getElementById('password').value;
    person.email=document.getElementById('email').value;
    story.role= {};
    story.role.id = 1;
    story.role.name = 'Author';

    let url = baseUrl + '/user';
    let response = await fetch(url, {method:'POST', body:JSON.stringify(story)});
    console.log(response);

    
    if (response.status === 201) {
        alert('Added author successfully.');
    } else {
        alert('Something went wrong.');
    }
}

