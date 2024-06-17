function adicionarIngrediente() {
    var container = document.getElementById('ingredientes-container');
    var index = container.children.length;
    var html = `
        <div class="ingrediente">
            <label for="nomeIngrediente${index}">Nome:</label>
            <input type="text" id="nomeIngrediente${index}" name="ingredientes[${index}].nome" required />

            <label for="quantidade${index}">Quantidade:</label>
            <input type="number" id="quantidade${index}" name="ingredientes[${index}].quantidade" required />

            <button class="remove" type="button" onclick="removerIngrediente(this)">-</button>
        </div>
    `;
    container.insertAdjacentHTML('beforeend', html);
}

function removerIngrediente(button) {
    var container = document.getElementById('ingredientes-container');
    container.removeChild(button.parentNode);
}