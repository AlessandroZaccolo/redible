const urlParams = new URLSearchParams(window.location.search);
const mealId = urlParams.get('mealId');


axios.get("http://localhost:8080/api/meals/"+ mealId)
    .then(function(response) {

        const meal = response.data; // In axios you get a response object with the data inside

        displayMeal(meal);

    }).catch(function (error) {
        console.log("There is an error", error);
        displayError(error);

});


function displayMeal(meal) {


    let mealContainer = document.getElementById("meal-container");

    const mealName = document.createElement("h3");
    mealName.textContent = `Meal: ${meal.name}`;
    mealContainer.appendChild(mealName);

    const mealQuantity = document.createElement("p");
    mealQuantity.textContent = ` Quantity:  ${meal.quantity}`;
    mealContainer.appendChild(mealQuantity);

    const mealFullPrice = document.createElement("p");
    mealFullPrice.textContent = `Full-Price: ${meal.price} €`;
    mealContainer.appendChild(mealFullPrice);

    const mealDiscPrice = document.createElement("p");
    mealDiscPrice.textContent = `Discounted-Price: ${meal.discountedPrice} €`;
    mealContainer.appendChild(mealDiscPrice);


    // Qty:  ${meal.quantity}, Full-Price: ${meal.price} €, Discounted-Price: ${meal.discountedPrice} €`;
}

function displayError(error) {

    let mealContainer = document.getElementById("meal-container");

    const mealError = document.createElement("p");
    mealError.textContent = "There is an error: " + error;
    mealContainer.appendChild(mealError);


}
