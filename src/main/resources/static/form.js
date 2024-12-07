document.getElementById("form-receita").addEventListener("submit", async (e) => {
    e.preventDefault();

    const nomeInput = document.getElementById("nome");
    const preparoInput = document.getElementById("preparo");
    const ingredientesInput = document.getElementById("ingredientes");

    const nome = nomeInput.value.trim();
    const preparo = preparoInput.value.trim();
    const ingredientes = ingredientesInput.value.trim();

    document.getElementById("nome-error").textContent = "";
    document.getElementById("preparo-error").textContent = "";
    document.getElementById("ingredientes-error").textContent = "";

    nomeInput.classList.remove("error-input");
    preparoInput.classList.remove("error-input");
    ingredientesInput.classList.remove("error-input");

    let isValid = true;

    if (!nome) {
        document.getElementById("nome-error").textContent = "O nome da receita não deve estar em branco";
        nomeInput.classList.add("error-input");
        isValid = false;
    }
    if (!preparo) {
        document.getElementById("preparo-error").textContent = "O modo de preparo não deve estar em branco";
        preparoInput.classList.add("error-input");
        isValid = false;
    }
    if (!ingredientes) {
        document.getElementById("ingredientes-error").textContent = "Os ingredientes não devem estar em branco";
        ingredientesInput.classList.add("error-input");
        isValid = false;
    }

    if (!isValid) return;

    const receita = { nome, modoPreparo: preparo, ingredientes };

    try {
        const response = await fetch("http://localhost:8080/receita", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(receita),
        });

        if (!response.ok) {
            if (response.status === 400) {
                const errors = await response.json();
                for (const field in errors) {
                    const errorElement = document.getElementById(`${field}-error`);
                    const inputElement = document.getElementById(field);
                    if (errorElement) {
                        errorElement.textContent = errors[field];
                    }
                    if (inputElement) {
                        inputElement.classList.add("error-input");
                    }
                }
            }
        } else {
            alert("Receita incluida com sucesso");
            window.location.href = "list.html";
        }
    } catch (error) {
        console.error(error);
        alert("Falha ao salvar a receita.");
    }
});
