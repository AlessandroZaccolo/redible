console.log("Meals js loaded");

axios.get("/api/meals")
    .then(function(response) {

        const meals = response.data; // In axios you get a response object with the data inside

        // This function will be called when the data comes
        // At this point, games contains the data that the end-point sends (the list of games)

        let mealsContainer = document.getElementById("meals-container");

        for (let meal of meals) {

            const p = document.createElement("h3");
            p.textContent = `Id:  ${meal.mealId}, Meal:  ${meal.name}`;
            mealsContainer.appendChild(p);

            const link = document.createElement("a");
            link.textContent = `See details`;
            link.href = "http://localhost:8080/meal.html?mealId=" + meal.mealId;
            mealsContainer.appendChild(link);
        }
    });
