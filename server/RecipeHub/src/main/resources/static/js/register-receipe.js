function adicionarIngrediente() {
    var container = document.getElementById('ingredientes-container');
    var allIngredientes = container.querySelectorAll('.ingrediente');
    var index = allIngredientes.length; // Correctly count only '.ingrediente' divs
    var html = `
        <div class="ingrediente">
            <label for="nomeIngrediente${index}">Nome:</label>
            <input type="text" id="nomeIngrediente${index}" name="ingredientes[${index}].nome" required />

            <label for="quantidade${index}">Quantidade:</label>
            <input type="number" id="quantidade${index}" name="ingredientes[${index}].quantidade" required />

            <label for="medida${index}">Medida:</label>
            <select id="medida${index}" name="ingredientes[${index}].medida">
                <option th:each="medida : ${T(org.example.recipehub.model.Medida).values()}"
                        th:value="${medida.name()}"
                        th:text="${medida.getDescricao()}">
                    Descrição
                </option>
            </select>

            <button class="remove" type="button" onclick="removerIngrediente(this)">-</button>
        </div>
    `;
    container.insertAdjacentHTML('beforeend', html);
}

function removerIngrediente(button) {
    var container = document.getElementById('ingredientes-container');
    container.removeChild(button.parentNode);
    reindexIngredientes();
}

function reindexIngredientes() {
    var ingredientes = document.querySelectorAll('.ingrediente');
    ingredientes.forEach((ingrediente, index) => {
        ingrediente.querySelector('[id^="nomeIngrediente"]').name = `ingredientes[${index}].nome`;
        ingrediente.querySelector('[id^="nomeIngrediente"]').id = `nomeIngrediente${index}`;
        ingrediente.querySelector('[id^="quantidade"]').name = `ingredientes[${index}].quantidade`;
        ingrediente.querySelector('[id^="quantidade"]').id = `quantidade${index}`;
        ingrediente.querySelector('[id^="medida"]').name = `ingredientes[${index}].medida`;
        ingrediente.querySelector('[id^="medida"]').id = `medida${index}`;
    });
}