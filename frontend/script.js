const API_BASE_URL = "http://54.147.189.248:8080/building";

async function register() {
    var name = document.getElementById("name").value;
    var address = document.getElementById("address").value;
    var price = document.getElementById("price").value;
    var size = document.getElementById("size").value;
    var description = document.getElementById("description").value;
    var dto = {
        name: name,
        address: address,
        price: price,
        size: size,
        description: description
    };
    await sendRegister(dto);
}

async function sendRegister(dto) {
    var response = await fetch(API_BASE_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dto)
    });
    if (!response.ok) {
        alert("Ocurrio un error inesperado en el registro, por favor intente de nuevo");
        return
    }
    var result = await response.json();
    alert(result.result);
}

async function getData() {
    var response = await fetch(API_BASE_URL, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    });
    if (!response.ok) {
        alert("Ocurrio un error inesperado en la tabla, por favor intente mas tarde");
        return
    }
    var result = await response.json();
    var buildings = result.data || result;
    tableBuilding(buildings);
}

function tableBuilding(buildingInfo) {
    const tabla = document.getElementById("buildings");
    const tbody = tabla.querySelector("tbody");
    tbody.innerHTML = "";
    if (!buildingInfo || buildingInfo.length === 0) {
        tbody.innerHTML = "<tr><td colspan='6'>No hay construcciones registradas.</td></tr>";
        return;
    }
    buildingInfo.forEach(building => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${building.propertyId}</td>
            <td>${building.name}</td>
            <td>${building.address}</td>
            <td>${building.price}</td>
            <td>${building.size}</td>
            <td>${building.description}</td>
        `;
        tbody.appendChild(row);
    });
}

async function modify() {
    var idBuilding = document.getElementById("id-edit").value;
    var name = document.getElementById("name-edit").value;
    var address = document.getElementById("address-edit").value;
    var price = document.getElementById("price-edit").value;
    var size = document.getElementById("size-edit").value;
    var description = document.getElementById("description-edit").value;
    var dto = {
        name: name,
        address: address,
        price: price,
        size: size,
        description: description
    };
    var response = await fetch(`${API_BASE_URL}?id=${idBuilding}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dto)
    });
    if (!response.ok) {
        alert("Ocurrio un error inesperado al intentar modificar la construcción, por favor intente mas tarde");
    } else {
        alert("Construcción modificada exitosamente");
    }
}

async function deleteBuilding() {
    var idBuilding = document.getElementById("id-delete").value;
    var response = await fetch(`${API_BASE_URL}?id=${idBuilding}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    });
    if (!response.ok) {
        alert("Ocurrio un error inesperado al intentar eliminar la construcción, por favor intente mas tarde");
    } else {
        alert("Construcción eliminada exitosamente");
    }
}