const BASE_URL = "/api";

export async function getProducts() {
  const response = await fetch(`${BASE_URL}/products`);
  if (!response.ok) {
    throw new Error(`Failed to load products: ${response.status}`);
  }
  return response.json();
}

export async function createProduct(name) {
  const response = await fetch(`${BASE_URL}/products`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name }),
  });
  if (!response.ok) {
    throw new Error(`Failed to create product: ${response.status}`);
  }
  return response.json();
}
