let mainContainer = document.getElementById("main-container");

let select = document.createElement("select");
let user = document.createElement("option");
let business = document.createElement("option");
let typeUser = document.createElement("option");

typeUser.textContent = "Who are you?";
user.textContent = "User";
business.textContent = "Business";

select.add(typeUser);
select.add(user);
select.add(business);
mainContainer.appendChild(select);


let button = document.createElement("button");
button.textContent = "Select";
mainContainer.appendChild(button);

let buttonMoveToMeals = document.querySelector("button");
buttonMoveToMeals.addEventListener("click", function (){
    console.log("Button was clicked");
    window.location = "http://localhost:8080/meals.html"
});
