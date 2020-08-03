var URL = "/usuarios";

function  init() {
    allUsers();
    createUser();
}

function  allUsers() {
    $.ajax({
        type: 'GET',
        url: URL,
        success: function (response) {
            console.log(response);

        }
    });
}

function createUser() {
    var user = {
        "id" : 1,
        "username" : "admin1",
        "password" : "12332",
        "email" : "admin@gmail.com"
    }

    $.ajax({
        type: 'POST',
        url: URL,
        data: {user: user},
        success: function (response) {
            console.log(response);
        }
    });
}


init();