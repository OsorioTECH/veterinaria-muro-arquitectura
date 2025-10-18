const API_URL = "http://localhost:8080/clientes";

const form = document.getElementById("formCliente");
const tabla = document.getElementById("tablaClientes");
const msg = document.getElementById("msg");

// Cargar lista de clientes al inicio
document.addEventListener("DOMContentLoaded", cargarClientes);

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const nombre = document.getElementById("nombre").value;
  const email = document.getElementById("email").value;
  const cedula = document.getElementById("cedula").value;

  const nuevoCliente = { nombre, email, cedula };

  try {
    const res = await fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(nuevoCliente),
    });

    if (!res.ok) throw new Error("Error al registrar el cliente");

    msg.textContent = "✅ Cliente registrado correctamente";
    msg.style.color = "green";
    form.reset();
    cargarClientes();
  } catch (err) {
    msg.textContent = "❌ " + err.message;
    msg.style.color = "red";
  }
});

async function cargarClientes() {
  const res = await fetch(API_URL);
  const clientes = await res.json();

  tabla.innerHTML = clientes
    .map(
      (c) => `
      <tr>
        <td>${c.id}</td>
        <td>${c.nombre}</td>
        <td>${c.email}</td>
        <td>${c.cedula}</td>
      </tr>`
    )
    .join("");
}
